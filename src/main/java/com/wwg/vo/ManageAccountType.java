package com.wwg.vo;

import java.util.HashMap;
import java.util.Map;


/**
 *类描述:管理账户枚举类  
 *
 *@Author:WWG
 *@date:2019年8月27日
 *@Version:1.0
 */
public enum ManageAccountType {
	/**01-存放供应商款项*/
    SUPPLIER_ACCOUNT("01","存放供应商款项"),
    /**02-融资客户存放款项*/
    BUSINESS_USER_ACCOUNT("02","融资客户存放款项"),
    /**03-预存监管费  Pre storage supervision fee*/
    PRESTORAGE_SUPERVISIONFEE_ACCOUNT("03","预存监管费");
	

	private static final Map<String, ManageAccountType> MAP = new HashMap<>();

	static {
		for (ManageAccountType typeEnum : values()) {
			MAP.put(typeEnum.getName(), typeEnum);
		}
	}

	public static ManageAccountType byName(String name) {
		if(MAP.containsKey(name)){
			return MAP.get(name);
		}else{
			return null;
		}

	}

	private static final Map<String, String> KV_MAP = new HashMap<>();
	
	static {
	    for (ManageAccountType typeEnum : values()) {
	        KV_MAP.put(typeEnum.getCode(), typeEnum.getName());
	    }
	}
	
	public static String getNameByCode(String code) {
	    if(KV_MAP.containsKey(code)){
	        return KV_MAP.get(code);
	    }else{
	        return null;
	    }
	}

	private String code;

	private String name;

	private ManageAccountType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}

