package com.wwg.cache;

import java.lang.ref.SoftReference;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author simon 用map实现一个简单的缓存功能
 */
public class MapCacheDemo {

    /**
     * 使用 ConcurrentHashMap，线程安全的要求。 我使用SoftReference <Object> 作为映射值，因为软引用可以保证在抛出OutOfMemory之前，如果缺少内存，将删除引用的对象。
     * 在构造函数中，我创建了一个守护程序线程，每5秒扫描一次并清理过期的对象。
     */
    private static final int CLEAN_UP_PERIOD_IN_SEC = 5;

    private final ConcurrentHashMap<String, SoftReference<CacheObject>> cache = new ConcurrentHashMap<>();

    public MapCacheDemo() {
        Thread cleanerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(CLEAN_UP_PERIOD_IN_SEC * 1000);
                    cache.entrySet().removeIf(
                        entry -> Optional.ofNullable(entry.getValue()).map(SoftReference::get).map(CacheObject::isExpired).orElse(false));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        cleanerThread.setDaemon(true);
        cleanerThread.start();
    }

    /**
     * @param key
     * @param value
     * @param periodInMillis
     * @功能描述:增加
     * @Author:WWG
     * @date:2019年11月11日 上午11:30:00
     * @Version:2.2
     */
    public void add(String key, Object value, long periodInMillis) {
        if (key == null) {
            return;
        }
        if (value == null) {
            cache.remove(key);
        } else {
            long expiryTime = System.currentTimeMillis() + periodInMillis;
            cache.put(key, new SoftReference<>(new CacheObject(value, expiryTime)));
        }
    }

    /**
     * @param key
     * @功能描述:删除
     * @Author:WWG
     * @date:2019年11月11日 上午11:28:54
     * @Version:2.2
     */
    public void remove(String key) {
        cache.remove(key);
    }

    /**
     * @param key
     * @return
     * @功能描述:查询
     * @Author:WWG
     * @date:2019年11月11日 上午11:29:05
     * @Version:2.2
     */
    public Object get(String key) {
        return Optional.ofNullable(cache.get(key)).map(SoftReference::get).filter(cacheObject -> !cacheObject.isExpired())
            .map(CacheObject::getValue).orElse(null);
    }

    public void clear() {
        cache.clear();
    }

    public long size() {
        return cache.entrySet().stream().filter(entry -> Optional.ofNullable(entry.getValue()).map(SoftReference::get)
            .map(cacheObject -> !cacheObject.isExpired()).orElse(false)).count();
    }

    /**
     * 缓存对象value
     */
    private static class CacheObject {
        private Object value;
        private long expiryTime;

        private CacheObject(Object value, long expiryTime) {
            this.value = value;
            this.expiryTime = expiryTime;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }

        public Object getValue() {
            return value;
        }

        @SuppressWarnings("unused")
        public void setValue(Object value) {
            this.value = value;
        }
    }
}