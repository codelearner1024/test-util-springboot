package com.wwg.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wwg.vo.ResultDic;
import com.wwg.vo.ReturnDto;

/**
 * 类描述:
 *
 * @Author:WWG
 * @date:2018年7月24日
 * @Version:1.0
 */
public class BaseController {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    protected BaseController() {}

    /**
     * @param restmap
     * @return
     * @功能描述:将service层返回的code message responseData封装返回
     * @Author:WWG
     * @date:2018年9月6日 下午4:48:30
     * @Version:1.0
     */
    protected ResponseEntity<ReturnDto> convertMapToResponseEntity(Map<String, Object> restmap) {
        String retCode = (String)restmap.get("retCode");
        String retMessage = (String)restmap.get("retMessage");
        Object responseData = restmap.get("responseData");
        return new ResponseEntity<>(new ReturnDto(retCode, retMessage, responseData), HttpStatus.OK);
    }

    protected ResponseEntity<ReturnDto> generateErrorResponse(BindingResult result) {
        ResponseEntity<ReturnDto> responseEntity;
        List<ObjectError> allErrors = result.getAllErrors();

        for (ObjectError objectError : allErrors) {
            LOGGER.error("请求参数异常：字段{}》》》{}", objectError.getObjectName(), objectError.getDefaultMessage());
        }
        // 将第一个错误返回到前台进行提示
        responseEntity = new ResponseEntity<>(new ReturnDto(ResultDic.FAIL_CODE, allErrors.get(0).getDefaultMessage()), HttpStatus.OK);
        return responseEntity;
    }

    protected <T> void generatePageSelectResultWithJSONObject(List<T> list, Map<String, Object> returnMap, int listCount) {
        // 处理日期类型数据返回给前端 "YYYY-MM-dd"
        JSONArray parseArray = JSON.parseArray(JSON.toJSONStringWithDateFormat(list, DateFormatUtils.ISO_DATE_FORMAT.getPattern(),
            SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty));
        returnMap.put("total", listCount);
        returnMap.put("rows", parseArray);
    }
}
