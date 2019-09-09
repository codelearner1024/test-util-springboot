/*
 * 文件名：ReturnDto.java
 * 描述： Controller层非列表结果的调用返回通用类
 */
package com.wwg.vo;

import java.io.Serializable;

public class ReturnDto extends AbstractModel implements Serializable{
    
    /** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -5137981050466789177L;
	private String  retCode    = "0";
    private String  retMessage = "操作成功";
    private Object  responseData;
    
    // start add by yyh 20190726
    public static final ReturnDto FAIL = new ReturnDto(ResultDic.FAIL_CODE,ResultDic.FAIL_DESC);
    public static final ReturnDto SUCCESS = new ReturnDto(ResultDic.SUCCESS_CODE,ResultDic.SUCCESS_DESC);
    // end add by yyh 20190726

    public ReturnDto() {
        // null
    }

	public ReturnDto(String retCode, String retMessage) {
		this(retCode, retMessage, null);
	}

    public ReturnDto(String retCode, String retMessage,  Object responseData) {
        this.retCode = retCode;
        this.retMessage = retMessage;
        this.responseData = responseData;
    }
    
    // start add by yyh 20190823
    /**  
     * @description 工厂方法：创建成功实例 
     * @return
     * @author yyh  
     * @date 2019年8月23日   下午1:43:36
     */  
    public static ReturnDto newSuccessInstance(){
    	return new ReturnDto(ResultDic.SUCCESS_CODE,ResultDic.SUCCESS_DESC);
    }
      
    /**  
     * @description 工厂方法：创建失败实例   
     * @return
     * @author yyh  
     * @date 2019年8月23日   下午1:43:43
     */  
    public static ReturnDto newFailInstance(){
    	return new ReturnDto(ResultDic.FAIL_CODE,ResultDic.FAIL_DESC);
    }
    // end add by yyh 20190823
    
	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMessage() {
		return retMessage;
	}

	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}
	
	  

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
