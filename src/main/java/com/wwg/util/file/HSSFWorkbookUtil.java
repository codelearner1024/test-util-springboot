package com.wwg.util.file;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HSSFWorkbookUtil {

    /**保留整数*/
    @SuppressWarnings("unused")
    private static final String DECIMAL_DIGITS_0 = "0";
    /**保留两位小数*/
    @SuppressWarnings("unused")
    private static final String DECIMAL_DIGITS_2 = "0.00";

    private static final Logger LOGGER = LoggerFactory.getLogger(HSSFWorkbookUtil.class);
    
    /*
     * 列头单元格样式
     */
    public static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

        // 设置字体
        HSSFFont font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short)18);
        // 字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // 设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        // 设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // 设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        // 设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // 设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        // 设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /*
    * 列头日期格式
    */
    public static HSSFCellStyle getColumnDateTopStyle(HSSFWorkbook workbook) {

        // 设置字体
        HSSFFont font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short)11);
        // 字体加粗
        // font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // 设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        // 设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // 设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        // 设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // 设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        // 设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;
    }

    /*
    * 列表中第一行单元格样式
    */
    public static HSSFCellStyle getColumnTitleStyle(HSSFWorkbook workbook) {

        // 设置字体
        HSSFFont font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short)9);
        // 字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // 设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        // 设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // 设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        // 设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // 设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        // 设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /*
    * 列数据信息单元格样式
    */
    public static HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        // 设置字体大小
        // font.setFontHeightInPoints((short)10);
        // 字体加粗
        // font.setBoldweight(HSSFFont.COLOR_NORMAL);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // 设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        // 设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // 设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        // 设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // 设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        // 设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /**
     * 为数据行设置样式
     * 
     * @param row
     * @param n
     * @param style
     * @return
     */
    public static HSSFRow setTableCellStyle(HSSFRow row, int n, HSSFCellStyle style) {
        for (int i = 0; i < n; i++) {
            row.getCell(i).setCellStyle(style);
        }
        return row;
    }
    
//private static Map<String, HSSFCellStyle> numericCellStyleMap = new HashMap<>(10);
//    
//    static {
//    	 HSSFWorkbook workbook = new HSSFWorkbook();
//    	 HSSFCellStyle style = workbook.createCellStyle();
//         style.cloneStyleFrom(getStyle(workbook));
//         
//         //获取excel数字单元格格式化模板
//         StringBuilder bld = new StringBuilder("0");
//
//         // 设置整数格式 返回单元格数字 "0"
//         style.setDataFormat(HSSFDataFormat.getBuiltinFormat(bld.toString()));
//         numericCellStyleMap.put(bld.toString() , style);
//
//         //小数位部分
//         //有小数位，并且不全为0
//         bld.append(".");
//         for (int i = 0; i < 10; i++) {
//        	 bld.append("0");
//   		 style.setDataFormat(HSSFDataFormat.getBuiltinFormat(bld.toString()));
//         numericCellStyleMap.put(bld.toString() , style);
//         }
//    }
//    
//    
//    public static HSSFRow setTableCellStyleByCellType2(HSSFRow row, int n, HSSFWorkbook workbook) {
//        HSSFCellStyle cellStyleForString = getStyle(workbook);
//        for (int i = 0; i < n; i++) {
//            HSSFCell cell = row.getCell(i);
//            // 判断是否是数字类型
//            if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
//                // 如果单元格内容是数值类型，涉及到金钱（金额、本、利），则设置cell的类型为数值型，设置data的类型为数值类型
//                double numericCellValue = cell.getNumericCellValue();
//                // 获取小数位对应的格式
//                String format = getDecimalDigitsNum(numericCellValue);
//                cell.setCellStyle(numericCellStyleMap.get(format));
//                // 防止科学计数法
//                cell.setCellValue(Double.parseDouble(BigDecimal.valueOf(numericCellValue).toPlainString()));
//            } else {
//                // 除了数字格式之外,其他的都默认为String,设为默认风格
//                cell.setCellStyle(cellStyleForString);
//            }
//        }
//        return row;
//    }
    
	public static Map<String, HSSFCellStyle> getNumericCellStyleMap(HSSFWorkbook workbook) {
		HSSFCellStyle styleForClone = getStyle(workbook);

		Map<String, HSSFCellStyle> numericCellStyleMap = new HashMap<>(10);
		// 获取excel数字单元格格式化模板
		StringBuilder bld = new StringBuilder("0");

		// 设置整数格式 返回单元格数字 "0"
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.cloneStyleFrom(styleForClone);
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(bld.toString()));
		numericCellStyleMap.put(bld.toString(), cellStyle);

		// 小数位部分
		// 有小数位，并且不全为0
		bld.append(".");
		for (int i = 0; i < 10; i++) {
			bld.append("0");
			HSSFCellStyle cellStyle2 = workbook.createCellStyle();
			cellStyle2.cloneStyleFrom(styleForClone);
			cellStyle2.setDataFormat(HSSFDataFormat.getBuiltinFormat(bld.toString()));
			numericCellStyleMap.put(bld.toString(), cellStyle2);
		}
		return numericCellStyleMap;
	}
    
    
    
    /**
     * 为数据行设置样式 根据不同的单元格数字类型
     * 
     * @param row
     * @param n
     * @param style
     * @return
     */
    public static HSSFRow setTableCellStyleByCellType(HSSFRow row, int n, HSSFWorkbook workbook) {
        Map<String, HSSFCellStyle> numericCellStyleMap = new HashMap<>(10);

        HSSFCellStyle cellStyleForString = getStyle(workbook);
        for (int i = 0; i < n; i++) {
            HSSFCell cell = row.getCell(i);
            // 判断是否是数字类型
            if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                // 如果单元格内容是数值类型，涉及到金钱（金额、本、利），则设置cell的类型为数值型，设置data的类型为数值类型
                double numericCellValue = cell.getNumericCellValue();
                // 获取小数位对应的格式
                String format = getDecimalDigitsNum(numericCellValue);
                if (!numericCellStyleMap.containsKey(format)) {
                                        
                    HSSFCellStyle style = workbook.createCellStyle();
                    style.cloneStyleFrom(cellStyleForString);
                    style.setDataFormat(HSSFDataFormat.getBuiltinFormat(format));
                    numericCellStyleMap.put(format , style);
                }
                cell.setCellStyle(numericCellStyleMap.get(format));
                // 防止科学计数法
                cell.setCellValue(Double.parseDouble(BigDecimal.valueOf(numericCellValue).toPlainString()));
            } else {
                // 除了数字格式之外,其他的都默认为String,设为默认风格
                cell.setCellStyle(cellStyleForString);
            }
        }
        return row;
    }
    
	public static HSSFRow setTableCellStyleByCellType(HSSFRow row, int n, HSSFCellStyle style,
			Map<String, HSSFCellStyle> numericCellStyleMap) {
		for (int i = 0; i < n; i++) {
			HSSFCell cell = row.getCell(i);
			// 判断是否是数字类型
			if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
				// 如果单元格内容是数值类型，涉及到金钱（金额、本、利），则设置cell的类型为数值型，设置data的类型为数值类型
				double numericCellValue = cell.getNumericCellValue();
				// 获取小数位对应的格式
				cell.setCellStyle(numericCellStyleMap.get(getDecimalDigitsNum(numericCellValue)));
				// 防止科学计数法
				cell.setCellValue(Double.parseDouble(BigDecimal.valueOf(numericCellValue).toPlainString()));
			} else {
				// 除了数字格式之外,其他的都默认为String,设为默认风格
				cell.setCellStyle(style);
			}
		}
		return row;

	}
    
    private static String getDecimalDigitsNum(double numericCellValue) {
       return getDecimalDigitsNum(numericCellValue + "");
    }

    /**  
     * @param workbook
     * @param decimalDigits example："0" ，"0.00"
     * @return  HSSFCellStyle
     * @功能描述:获取数字单元格风格,最后几行会失真
     * @Author:WWG
     * @date:2019年9月6日  下午3:14:34
     * @Version:1.0  
     */
    @SuppressWarnings("unused")
    @Deprecated
    private static HSSFCellStyle getNumericStyleByDecimalDigits(HSSFWorkbook workbook, String decimalDigits) {
        HSSFCellStyle style = getStyle(workbook);
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat(decimalDigits)); 
        return style;
    }

    public static String getDecimalDigitsNum(String s) {
        //获取有效小数位位数
        s = new BigDecimal(s).stripTrailingZeros().toPlainString();
        String[] split = s.split("\\.");
        int length = split.length;
        LOGGER.debug("获取的小数位格式为：{}",length);

        //获取excel数字单元格格式化模板
        StringBuilder bld = new StringBuilder("0");
        if (split.length >= 2) {
            // 是整数 返回单元格数字 "0"
            //有小数位，并且不全为0
                //小数位部分
                bld.append(".");
                String decimalDigitsNum = split[1];
                for (int j = 0; j < decimalDigitsNum.length(); j++) {
                    bld.append("0");
                }
        }
        String format = bld.toString();
        LOGGER.debug("excel数字单元格格式化模板：{}",format);
        return format;
    }
    
    
    public static void main(String[] args) {
        
//        String s = "1234567890121.0101";
//        String s = "1234567890121.0101";
        String s = "1234567890121.000";
        getDecimalDigitsNum(s);
        
//        double number = 0.00;
//        if (number % 1 == 0) {
//            System.out.println("number小数部分是0");
//        } else {
//            System.out.println("number小数部分不是0");
//        }
    }


	
}
