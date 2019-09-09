package com.wwg.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * json过滤null值工具类
 * 
 * @author wwg
 */
public class JsonFilterUtil {

    /**
     * @param <T>
     * @param list
     * @return
     * @功能描述:将null值去除
     * @Author:WWG
     * @date:2019年8月30日 上午2:08:53
     * @Version:1.0
     */
    public static <T> JSONArray filterListWithNullValue(T list) {
        JSONArray jsonArray = JSON.parseArray(JSON.toJSONStringWithDateFormat(list, DateFormatUtils.ISO_DATE_FORMAT.getPattern(),
            SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty));
        JsonFilterUtil.filterNull(jsonArray);
         return jsonArray;
    }

    public static void filterNull(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.size(); i++) {
            filterNull(jsonArray.getJSONObject(i));
        }
    }

    public static void filterNull(JSONObject jsonObj) {
        if (!ObjectUtils.isEmpty(jsonObj)) {
            Set<String> keySet = jsonObj.keySet();
            Iterator<String> it = keySet.iterator();
            Object obj = null;
            String key = null;
            while (it.hasNext()) {
                key = it.next();
                obj = jsonObj.get(key);
                if (obj instanceof JSONObject) {
                    filterNull((JSONObject)obj);
                }
                if (obj instanceof JSONArray) {
                    JSONArray objArr = (JSONArray)obj;
                    for (int i = 0; i < objArr.size(); i++) {
                        filterNull(objArr.getJSONObject(i));
                    }
                }
                if (obj == null || obj.equals("null")) {
                    jsonObj.put(key, "");
                }
            }
        }

    }

    /**
     * @param jsonParam
     * @功能描述:过滤一些指定值，例如'--'
     * @Author:WWG
     * @date:2019年4月29日 下午2:11:15
     * @Version:1.0
     */
    public static void filterSpecified(JSONObject jsonParam, List<String> list) {
        if (!ObjectUtils.isEmpty(jsonParam)) {
            Set<String> keySet = jsonParam.keySet();
            Iterator<String> it = keySet.iterator();
            Object obj = null;
            String key = null;
            while (it.hasNext()) {
                key = it.next();
                obj = jsonParam.get(key);
                if (obj instanceof JSONObject) {
                    filterSpecified((JSONObject)obj, list);
                }
                if (obj instanceof JSONArray) {
                    JSONArray objArr = (JSONArray)obj;
                    for (int i = 0; i < objArr.size(); i++) {
                        Object object = objArr.get(i);
                        if (object instanceof JSONObject) {
                            filterSpecified(objArr.getJSONObject(i), list);
                        }
                    }
                }
                if (null != list && !list.isEmpty()) {
                    for (String pattern : list) {
                        if (pattern.equals(obj)) {
                            jsonParam.put(key, "");
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

//        List<ManageAccount> t = new ArrayList<>();
//        ManageAccount m = new ManageAccount("123", "123", "123", "01", new BigDecimal("12313313.21"), "1", new Date(), "123", "wwg");

//        t.add(m);

        // t = JsonFilterUtil.filterListWithNullValue(t);
        // System.out.println(t);
//        JSONArray jsonArray = JsonFilterUtil.filterListWithNullValue(t);
//        for (Object object : jsonArray) {
//            JSONObject obj = (JSONObject)object;
//            
//            System.out.println(obj);
//        }
        
//        System.out.println(jsonArray);

        // String json =
        // "{\"bankCodes\":[\"ICBC\",\"LPCBC\",\"JSBC\",\"CSYH\",\"JSCB\",\"BBBB\",\"CBYH\",\"WRCB\",\"AL\",\"GZCR\",\"GZCRA\",\"WRCBX\",\"JYRCB\",\"GZJRBACK\",\"JYCR\",\"aaaae\",\"AAAaa\",\"qwas\",\"AAAaWE\",\"fzlzqd\",\"DASDASDASD\",\"zzzc\",\"qwervc\",\"daanmow\",\"plm\",\"plmm\",\"zxcvv\",\"lol\",\"AAAaQQ\",\"daDASDAQQ\",\"AAAaaz\",\"AAAa\"],\"bankName\":\"\",\"groupNames\":[\"江苏银行一组\",\"工商银行一组\",\"凉山州银行一组\",\"运营一组\",\"运营二组\",\"江苏银行二组\",\"工商银行二组\",\"测试银行一组\",\"江苏银行组\",\"B类银行组\",\"勿选一组\",\"wwwwwwwwww\",\"无锡农商行一组\",\"无锡农商行二组\",\"长融一组\",\"凉山州银行二组\",\"长融银行二组\",\"测试一组\",\"江阴银行一组\",\"感知金融长融一组\",\"江阴农商行长融二组\",\"感知金融长融二组\",\"感知长融A银行二组\",\"感知长融A银行一组\",\"感知金融一组\",\"银行一组\",\"江阴长融一组\",\"江阴长融二组\",\"江阴银行二组\",\"ldd组\",\"APP开发运营一组\",\"APP开发运营二组\",\"test组\",\"App测试一组\"],\"page\":1,\"rows\":10,\"sessionID\":\"5432BBD1E8171494171173F3B15145B0\",\"userId\":114}";
        //
        // JSONObject jsonObject = JSONObject.parseObject(json);
        //
        // filterSpecified(jsonObject, new ArrayList<>());
    }
}
