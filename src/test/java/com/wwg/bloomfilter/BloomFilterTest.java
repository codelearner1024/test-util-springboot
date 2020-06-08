package com.wwg.bloomfilter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.wwg.util.math.MathUtil;

public class BloomFilterTest {
    private static final int insertions = 1000000; // 100w

    @Test
    public void bfTest() {
        // 初始化一个存储string数据的布隆过滤器，初始化大小100w,不能设置为0
        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), insertions, 0.001);
        // 初始化一个存储string数据的set，初始化大小100w
        Set<String> sets = new HashSet<>(insertions);
        // 初始化一个存储string数据的set，初始化大小100w
        List<String> lists = new ArrayList<String>(insertions);

        // 向三个容器初始化100万个随机并且唯一的字符串---初始化操作
        for (int i = 0; i < insertions; i++) {
            String uuid = UUID.randomUUID().toString();
            bf.put(uuid);
            sets.add(uuid);
            lists.add(uuid);
        }

        int wrong = 0;// 布隆过滤器错误判断的次数
        int right = 0;// 布隆过滤器正确判断的次数
        int j = 1000000;
        for (int i = 0; i < j; i++) {
//            String test = i % 100 == 0 ? lists.get(i / 100) : UUID.randomUUID().toString();// 按照一定比例选择bf中肯定存在的字符串
            String test = i % 2 == 0 ? lists.get(i / 2) : UUID.randomUUID().toString();// 按照一定比例选择bf中肯定存在的字符串
            
//            if (bf.mightContain(test)) {
//                // 布隆过滤器判断该值存在
//                if (sets.contains(test)) {
//                    // 实际在sets中确实存在，bingo
//                    right++;
//                } else {
//                    // 实际在sets中不存在，即布隆过滤器判断错误
//                    wrong++;
//                }
//            }else {
//             // 布隆过滤器判断该值不存在
//                if (sets.contains(test)) {
//                    // 实际在sets中确实存在，bingo
//                    wrong++;
//                } else {
//                    // 实际在sets中不存在，即布隆过滤器判断正确
//                    right++;
//                }
//            }
            if (bf.mightContain(test) && sets.contains(test)) {
                // 都判断存在
                right++;
            }else if(!bf.mightContain(test) && !sets.contains(test)) {
                // 都判断不存在
                right++;
            }else {
                wrong++;
            }
        }

        System.out.println("=================right=====================" + right);// 100
        System.out.println("=================wrong=====================" + wrong);
        System.out.println("=================wrong_rate=====================" + MathUtil.getPercentageChange(wrong, j, 3));
    }
}
