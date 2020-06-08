package com.wwg.util.math;


import java.math.BigDecimal;

public class BigDecimalUtil {

    // 计算比例时精度（规模）
    public static final int RATIO_SCALE = 10;

    private BigDecimalUtil(){}

    /**
     * BigDecimal的加法运算封装
     * @param b1
     * @param bn
     * @return
     */
    public static BigDecimal safeAdd(BigDecimal b1, BigDecimal... bn) {
        if (null == b1) {
            b1 = BigDecimal.ZERO;
        }
        if (null != bn) {
            for (BigDecimal b : bn) {
                b1 = b1.add(null == b ? BigDecimal.ZERO : b);
            }
        }
        return b1;
    }

    /**
     * BigDecimal 转double型
     * @param b1
     * @return
     */
    public static Double toDoubleRound2(BigDecimal b1){
        if(null==b1)
        {
           return null;
        }else {
            return b1.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }
    
    /**
     * BigDecimal 转double型
     * @param b1
     * @return
     */
    public static Double toDoubleRound(BigDecimal b1,int round){
        if(null==b1)
        {
           return null;
        }else {
            return b1.setScale(round,   BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }
    
    public static BigDecimal forDouble(Double b1){
        if(null==b1)
        {
            return null;
        }else {
            return BigDecimal.valueOf(b1);
        }
    }

    /**
     * 计算金额方法
     * @param b1
     * @param bn
     * @return
     */
    public static BigDecimal safeSubtract(BigDecimal b1, BigDecimal... bn) {
        return safeSubtract(true, b1, bn);
    }

    /**
     * BigDecimal的安全减法运算
     * @param isZero  减法结果为负数时是否返回0，true是返回0（金额计算时使用），false是返回负数结果
     * @param b1        被减数
     * @param bn        需要减的减数数组
     * @return
     */
    public static BigDecimal safeSubtract(Boolean isZero, BigDecimal b1, BigDecimal... bn) {
        if (null == b1) {
            b1 = BigDecimal.ZERO;
        }
        BigDecimal r = b1;
        if (null != bn) {
            for (BigDecimal b : bn) {
                r = r.subtract((null == b ? BigDecimal.ZERO : b));
            }
        }
        if(isZero){
            return r.compareTo(BigDecimal.ZERO) == -1 ? BigDecimal.ZERO : r;
        } else {
            return r;
        }
    }

    /**
     * 金额除法计算，返回2位小数（具体的返回多少位大家自己看着改吧）
     * @param b1
     * @param b2
     * @return
     */
    public static <T extends Number> BigDecimal safeDivide(T b1, T b2){
        return safeDivide(b1, b2, BigDecimal.ZERO);
    }


    public static <T extends Number> BigDecimal safeDivideScale(T b1, T b2, int scale){
        return safeDivideScale(b1, b2, BigDecimal.ZERO, scale);
    }
    
    public static <T extends Number> BigDecimal safeDivideScale(T b1, T b2, int scale,int roundingMode){
        if (null == b1 || null == b2) {
            return BigDecimal.ZERO;
        }
        try {
            return BigDecimal.valueOf(b1.doubleValue()).divide(BigDecimal.valueOf(b2.doubleValue()), scale, roundingMode);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    /**
     * BigDecimal的除法运算封装，如果除数或者被除数为0，返回默认值
     * @param b1
     * @param b2
     * @param defaultValue
     * @return
     */
    public static <T extends Number> BigDecimal safeDivide(T b1, T b2, BigDecimal defaultValue) {
        if (null == b1 || null == b2) {
            return defaultValue;
        }
        try {
            return BigDecimal.valueOf(b1.doubleValue()).divide(BigDecimal.valueOf(b2.doubleValue()), 2, BigDecimal.ROUND_HALF_UP);
        } catch (Exception e) {
            return defaultValue;
        }
    }


    public static <T extends Number> BigDecimal safeDivideScale(T b1, T b2, BigDecimal defaultValue, int scale) {
        if (null == b1 || null == b2) {
            return defaultValue;
        }
        try {
            return BigDecimal.valueOf(b1.doubleValue()).divide(BigDecimal.valueOf(b2.doubleValue()), scale, BigDecimal.ROUND_HALF_UP);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * BigDecimal的除法运算封装，如果除数或者被除数为0，返回默认值,4位小数
     * @param b1
     * @param b2
     * @param defaultValue
     * @return
     */
    public static <T extends Number> BigDecimal safeFourDivide(T b1, T b2) {
        if (null == b1 || null == b2) {
            return BigDecimal.ZERO;
        }
        try {
            return BigDecimal.valueOf(b1.doubleValue()).divide(BigDecimal.valueOf(b2.doubleValue()), 4, BigDecimal.ROUND_HALF_UP);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    /**
     * BigDecimal的乘法运算封装
     * @param b1
     * @param b2
     * @return
     */
    public static <T extends Number> BigDecimal safeMultiply(T b1, T b2) {
        if (null == b1 || null == b2) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(b1.doubleValue()).multiply(BigDecimal.valueOf(b2.doubleValue())).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    
    
    /**
     * BigDecimal的乘法运算封装,保留8位小数
     * @param b1
     * @param b2
     * @return
     */
    public static <T extends Number> BigDecimal safeMultiplyScale8(T b1, T b2) {
        if (null == b1 || null == b2) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(b1.doubleValue()).multiply(BigDecimal.valueOf(b2.doubleValue())).setScale(8, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 取最小值
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal safeCompare(BigDecimal b1,BigDecimal b2)
    {
        if (null == b1 || null == b2 ) {
            return BigDecimal.ZERO;
        }
        BigDecimal min = b1;
        if (b1.compareTo(b2)==1) {
            min = b2;
        }
        return min;
    }

    public static void main(String[] args) {
        BigDecimal b1=new BigDecimal("2.01");
        BigDecimal b2=new BigDecimal("2");
        BigDecimal b3=new BigDecimal("4.56");
        BigDecimal b4=new BigDecimal("4");
        System.out.print(safeCompare(b1 , b2));
        System.out.print(safeCompare(b1 , b2).compareTo(b4)>=0);
    }
    
	public static BigDecimal countProductAmount(BigDecimal weight, BigDecimal unitPrice) {
		return safeMultiply(unitPrice, weight);
	}
}
