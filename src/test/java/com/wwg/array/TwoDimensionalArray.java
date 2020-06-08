package com.wwg.array;

public class TwoDimensionalArray {
    
    public static void main(String[] args) {
        twoDimensionalArray();
    }

    /**  
     *   
     * @功能描述:二维数组计算:求每行最大值中的最小值
     * @Author:WWG
     * @date:2020年6月8日  下午4:40:50
     * @Version:2.9
     */
    protected static void twoDimensionalArray() {
        int[][] arrays = init();
        
        // 求每行最大值中的最小值
        int rowLength = arrays.length;
        int colunmLength = arrays[0].length;
        System.out.println("rowLength:" + rowLength);
        System.out.println("colunmLength:" + colunmLength);
        Integer min = null;
        int minTemp;
        for (int i = 0; i < rowLength; i++) {
            Integer rowMax = null;
            int temp;
            for (int j = 0; j < colunmLength; j++) {
                if (rowMax == null) {
                    rowMax = arrays[i][j];
                }else {
                    temp = arrays[i][j];
                    rowMax = temp > rowMax? temp:rowMax;
                }
            }
            if (min == null) {
                // 第一行遍历结束后
                min = rowMax;
            }else {
                // 之后几行
                minTemp = rowMax;
                min = minTemp < min? minTemp:min;
            }
        }
        System.out.println("每行最大值中的最小值为：" + min);
    }
    
    protected static int[][] init() {
        int bound = 5;
        // n行
        int n = (int)(Math.random()*bound);
        // m列
        int m = (int)(Math.random()*bound);
        // 初始化
        int[][] arrays = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrays[i][j] = (int)(Math.random()*100);
                System.out.print(arrays[i][j] + "、");
            }
            System.out.println();
        }
        return arrays;
    }
}
