package com.wwg.array;

import java.math.BigDecimal;

public class TestDouble {
    public static void main(String[] args) {
        double d1 = 0.21 + 0.19;
        double d2 = 0.4;
        System.out.println(d1==d2);
        System.out.println("-----------------------------------");
        
        BigDecimal decimal = new BigDecimal("0.01").add(new BigDecimal("0.02"));
        System.out.println(decimal);
        System.out.println("-----------------------------------");
        float xx = 2.0f;
        float yy = 1.8f;
        float tt = xx - yy;
        System.out.println("tttttt-----" + tt);
        System.out.println("-----------------------------------");
        float f1 = 0.21f + 0.19f;
        float f2 = 0.4f;
        System.out.println(f1==f2);
        System.out.println("-----------------------------------");
    }
}

