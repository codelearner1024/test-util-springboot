package com.wwg.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

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
    	BigDecimal subtract = newOne.subtract(oldOne);//计算被除数
    	double doubleValue = subtract.divide(oldOne,4,BigDecimal.ROUND_HALF_UP).doubleValue();//相除
    	String result = numberFormat.format(doubleValue * 100);
    	// System.out.println("num1和num2的百分比为:" + result + "%");
    	return result + "%";
    }
}
