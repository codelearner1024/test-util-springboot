package com.wwg.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class T implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(T.class);

    private volatile int count = 100;

    @Override
    public void run() {
        --count;
        System.out.println(Thread.currentThread().getName() + " count" + count);
    }

    public static void main(String[] args) {
        T t = new T();
//        LOG.debug("开始创建》》》》》");
//        long startTime = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            String threadName = "Thread" + j;
//            LOG.debug("创建线程：{}", threadName);
            new Thread(t, threadName).start();
        }
//        long endTime = System.currentTimeMillis();
//        LOG.debug("结束创建《《《《《");
//        LOG.debug("用时:{} ms", endTime - startTime);

    }
}
