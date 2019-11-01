package com.wwg.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wwg.util.BigDecimalUtil;
import com.wwg.util.DownloadUtils;
import com.wwg.util.HSSFWorkbookUtil;
import com.wwg.vo.ManageAccountConstant;
import com.wwg.vo.ManageAccountRecord;
import com.wwg.vo.ManageAccountType;
import com.wwg.vo.ResultDic;
import com.wwg.vo.ReturnDto;

/**
 * 类描述:管理账户相关操作入口
 *
 * @Author:WWG
 * @date:2019年8月28日
 * @Version:1.0
 */
@Controller
@RequestMapping("/back/manage/account")
public class ManageAccountController extends BaseController {
  
    
    /**
     * @param record
     * @param result
     * @return
     * @功能描述:新增记账流水
     * @Author:WWG
     * @date:2019年9月1日 下午5:09:24
     * @Version:1.0
     */
    @PostMapping(value = "/insertAccountDetail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<ReturnDto> insertAccountRecord(@RequestBody @Valid ManageAccountRecord record, BindingResult result) {
        ResponseEntity<ReturnDto> responseEntity;
        if (result.hasErrors()) {
            responseEntity = super.generateErrorResponse(result);
        } else {
            try {
                responseEntity = new ResponseEntity<>(new ReturnDto(ResultDic.SUCCESS_CODE, ResultDic.SUCCESS_DESC), HttpStatus.OK);
            } catch (Exception e) {
                responseEntity = new ResponseEntity<>(new ReturnDto(ResultDic.FAIL_CODE, ResultDic.FAIL_DESC, null), HttpStatus.OK);
                LOGGER.error(e.getMessage(), e);
            }
        }
        return responseEntity;
    }
    
    /**
     * 管理账户导出
     * 
     * @param condition
     * @param response
     * @param request
     */
    @GetMapping(value = "/exportAccountList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void exportAccountList(HttpServletRequest request, HttpServletResponse response) {
        try {
            InputStream is = this.generateManageAccountListExcel();
            String string = "管理账户列表";
            DownloadUtils.download(request, response, is, string + ".xls");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 管理账户导出 excel 文件
     * 
     * @param
     * @return
     */
    private InputStream generateManageAccountListExcel() {
        
        
        HSSFWorkbook workbook = new HSSFWorkbook();// 创建工作簿对象
        String sheetName = "管理账户列表";
        String[] rowName = {"序号", "账号", "账户名称", "账户证件号码", "账户类型", "余额", "建立日期", "最近交易日期", "最近交易流水号", "最近交易用户", "状态"};
        HSSFSheet sheet = workbook.createSheet(sheetName);// 创建工作表
        
        //获取工作簿格式化对象
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        //获取工作簿单元格风格对象
        for (int i = 0; i < rowName.length; i++) {
            sheet.setColumnWidth(i, 26 * 256);
        }
        HSSFCellStyle style = HSSFWorkbookUtil.getStyle(workbook);// 单元格样式对象
        Map<String, HSSFCellStyle> numericCellStyleMap = HSSFWorkbookUtil.getNumericCellStyleMap(workbook);//数值格式Map
        
        
        int border = 1;
        // 设置标题
        CellRangeAddress cra = new CellRangeAddress(0, 0, 0, rowName.length - 1);
        sheet.addMergedRegion(cra);
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0, HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(sheetName);
        cell.setCellStyle(HSSFWorkbookUtil.getColumnTopStyle(workbook));// 获取列头样式对象
        RegionUtil.setBorderBottom(border, cra, sheet, workbook);
        RegionUtil.setBorderLeft(border, cra, sheet, workbook);
        RegionUtil.setBorderRight(border, cra, sheet, workbook);
        RegionUtil.setBorderTop(border, cra, sheet, workbook);

        // 列表头部
        int columnNum = rowName.length;
        HSSFRow rowRowName = sheet.createRow(1);
        for (int i = 0; i < columnNum; i++) {
            HSSFCell cellRowName = rowRowName.createCell(i); // 创建列头对应个数的单元格
            cellRowName.setCellType(HSSFCell.CELL_TYPE_NUMERIC); // 设置列头单元格的数据类型
            HSSFRichTextString text = new HSSFRichTextString(rowName[i]);
            cellRowName.setCellValue(text); // 设置列头单元格的值
            cellRowName.setCellStyle(HSSFWorkbookUtil.getColumnTitleStyle(workbook));// 设置列头单元格样式

        }
//        if (accountList != null && !accountList.isEmpty()) {
            // 商品信息
            // 去空处理
//            JSONArray jsonArray = JsonFilterUtil.filterListWithNullValue(accountList);
//            String text1 = "[{\"accountName\":\"吴伟刚\",\"accountNo\":\"321321\",\"accountType\":\"1\",\"creCompanyNo\":\"111111\",\"gmtCreate\":1566373020000,\"gmtUpdate\":null,\"id\":1,\"latestOperator\":null,\"latestTradingDate\":null,\"latestTradingNo\":null,\"remainingAmount\":1234567890121.01,\"status\":\"1\",\"version\":1}, {\"accountName\":\"231\",\"accountNo\":\"231\",\"accountType\":\"02\",\"creCompanyNo\":\"1232131323\",\"gmtCreate\":1567060027000,\"gmtUpdate\":null,\"id\":2,\"latestOperator\":null,\"latestTradingDate\":null,\"latestTradingNo\":null,\"remainingAmount\":1.01,\"status\":\"1\",\"version\":1}, {\"accountName\":\"e\",\"accountNo\":\"2\",\"accountType\":\"e\",\"creCompanyNo\":null,\"gmtCreate\":null,\"gmtUpdate\":null,\"id\":3,\"latestOperator\":null,\"latestTradingDate\":null,\"latestTradingNo\":null,\"remainingAmount\":0.01,\"status\":\"1\",\"version\":1}]";
            String text1 = "[\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 12333,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 312321323.2222,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 23132.111111000,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },{\r\n" + 
                "    \"accountName\": \"吴伟刚\",\r\n" + 
                "    \"accountNo\": \"321321\",\r\n" + 
                "    \"accountType\": \"1\",\r\n" + 
                "    \"creCompanyNo\": \"111111\",\r\n" + 
                "    \"gmtCreate\": 1566373020000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 1,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1234567890121.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"231\",\r\n" + 
                "    \"accountNo\": \"231\",\r\n" + 
                "    \"accountType\": \"02\",\r\n" + 
                "    \"creCompanyNo\": \"1232131323\",\r\n" + 
                "    \"gmtCreate\": 1567060027000,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 2,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 1.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  },\r\n" + 
                "  {\r\n" + 
                "    \"accountName\": \"e\",\r\n" + 
                "    \"accountNo\": \"2\",\r\n" + 
                "    \"accountType\": \"e\",\r\n" + 
                "    \"creCompanyNo\": null,\r\n" + 
                "    \"gmtCreate\": null,\r\n" + 
                "    \"gmtUpdate\": null,\r\n" + 
                "    \"id\": 3,\r\n" + 
                "    \"latestOperator\": null,\r\n" + 
                "    \"latestTradingDate\": null,\r\n" + 
                "    \"latestTradingNo\": null,\r\n" + 
                "    \"remainingAmount\": 0.01,\r\n" + 
                "    \"status\": \"1\",\r\n" + 
                "    \"version\": 1\r\n" + 
                "  }\r\n" + 
                "]";
            JSONArray jsonArray = JSONArray.parseArray(text1);
            
            for (int n = 0; n < jsonArray.size(); n++) {
                HSSFRow productRow = sheet.createRow(n + 2); // 创建所需的行数
                // ManageAccount mo = (ManageAccount)jsonArray.get(n);
                JSONObject mo = (JSONObject)jsonArray.get(n);
                /*"序号", "账号", "账户名称", "账户证件号码", "账户类型", "余额", "建立日期", "最近交易日期", "最近交易流水号", "最近交易用户", "状态"*/

                productRow.createCell(0, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(n + 1);// 序号
                productRow.createCell(1, HSSFCell.CELL_TYPE_STRING).setCellValue(mo.getString("accountNo"));// 账号
                productRow.createCell(2, HSSFCell.CELL_TYPE_STRING).setCellValue(mo.getString("accountName"));// 账户名称
                productRow.createCell(3, HSSFCell.CELL_TYPE_STRING).setCellValue(mo.getString("creCompanyNo"));// 证件号码
                productRow.createCell(4, HSSFCell.CELL_TYPE_STRING)
                    .setCellValue(ManageAccountType.getNameByCode(mo.getString("accountType")));// 账户类型
                productRow.createCell(5, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(mo.getBigDecimal("remainingAmount") == null ? 0
                    :BigDecimalUtil.toDoubleRound(mo.getBigDecimal("remainingAmount"), 2));// 余额
                productRow.createCell(6, HSSFCell.CELL_TYPE_STRING).setCellValue(mo.getString("gmtCreate"));// 建立日期
                productRow.createCell(7, HSSFCell.CELL_TYPE_STRING).setCellValue(mo.getString("latestTradingDate"));// 最近交易日期
                productRow.createCell(8, HSSFCell.CELL_TYPE_STRING).setCellValue(mo.getString("latestTradingNo"));// 最近交易流水号
                productRow.createCell(9, HSSFCell.CELL_TYPE_STRING).setCellValue(mo.getString("latestOperator"));// 最近交易用户
                productRow.createCell(10, HSSFCell.CELL_TYPE_STRING)
                    .setCellValue("1".equals(mo.getString("status")) ? ManageAccountConstant.STATUS_OK : "");// 状态

//                HSSFWorkbookUtil.setTableCellStyle(productRow, rowName.length, style);
//                HSSFWorkbookUtil.setTableCellStyleByCellType(productRow, rowName.length, workbook);
                HSSFWorkbookUtil.setTableCellStyleByCellType(productRow, rowName.length,style,numericCellStyleMap);
            }

        InputStream is = null;
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            workbook.write(os);
            byte[] content = os.toByteArray();
            is = new ByteArrayInputStream(content);
        } catch (IOException e) {
        }
        return is;
    }

}
