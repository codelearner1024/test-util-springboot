package com.wwg.util.math;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Random;

/**
 * @author WWG 数据计算工具 2018年5月2日下午5:32:20
 */
public class MathUtil {

    private static NumberFormat numberFormat = NumberFormat.getInstance();

    /**
     * @Author：DELL
     * @return 获取百分比
     */
    public static String getPercentageChange(double newOne, double oldOne, int point) {
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(point);
        String result = numberFormat.format(newOne / oldOne * 100);
        // System.out.println("num1和num2的百分比为:" + result + "%");
        return result + "%";
    }

    /**
     * @Author：DELL
     * @return 获取百分比
     */
    public static String getPercentageChange(BigDecimal newOne, BigDecimal oldOne, int point) {
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(point);
        BigDecimal subtract = newOne.subtract(oldOne);// 计算被除数
        double doubleValue = subtract.divide(oldOne, 4, BigDecimal.ROUND_HALF_UP).doubleValue();// 相除
        String result = numberFormat.format(doubleValue * 100);
        // System.out.println("num1和num2的百分比为:" + result + "%");
        return result + "%";
    }

    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    /**
     * 提供精确的加法运算。
     * 
     * @param v1
     *            被加数
     * @param v2
     *            加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     * 
     * @param v1
     *            被减数
     * @param v2
     *            减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     * 
     * @param v1
     *            被乘数
     * @param v2
     *            乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     * 
     * @param v1
     *            被除数
     * @param v2
     *            除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     * 
     * @param v1
     *            被除数
     * @param v2
     *            除数
     * @param scale
     *            表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     * 
     * @param v
     *            需要四舍五入的数字
     * @param scale
     *            小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    // 非整除则进位 by tony 20111006
    public int round(int i1, int i2) {
        int modi = 0;
        modi = i1 % i2;
        int i = i1 / i2;
        if (modi == 0) {
            return i;
        } else {
            return i + 1;
        }
    }

    // 使用时一定要注意其大小，不可超出范围
    public int pow(int i1, int i2) {
        double d1 = (double)i1;
        double d2 = (double)i2;
        return (int)java.lang.Math.pow(d1, d2);
    }

    // 对给定数目的自0开始步长为1的数字序列进行乱序
    public static int[] getSequence(int maxnum) {
        int[] sequence = new int[maxnum];
        for (int i = 0; i < maxnum; i++) {
            sequence[i] = i;
        }
        Random random = new Random();
        for (int i = 0; i < maxnum; i++) {
            int p = random.nextInt(maxnum);
            int tmp = sequence[i];
            sequence[i] = sequence[p];
            sequence[p] = tmp;
        }
        random = null;
        return sequence;
    }

    public static void main(String[] agrs) {
        // Arith arith = new Arith();
        // int[] i = arith.getSequence(300);
        // for(int n=0;n<i.length;n++){
        // System.out.println(i[n]);
    }
}
