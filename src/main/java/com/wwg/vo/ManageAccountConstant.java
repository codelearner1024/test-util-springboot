package com.wwg.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * @类描述: 管理账户操作常量类
 * @Author wwg
 * @date: 2019/8/27 14:25
 * @Version: 1.0
 **/
public class ManageAccountConstant {

    private ManageAccountConstant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String FAIL_INSERT = "插入管理账户数据失败！！！";
    public static final String SUCCESS_INSERT = "插入管理账户数据成功！！！";
    public static final String FAIL_ACCOUNT_EXIST = "已经存在对应账户，无需重复处理！！！";

    /** accounting_direction 记账方向 */
    public static final String ACCOUNTING_DIRECTION_INCR = "增加";
    public static final String ACCOUNTING_DIRECTION_DECR = "减少";

    /** accounting_type 记账类型 0：转账transfer:1：现金 */
    public static final String ACCOUNTING_TYPE_TRANSFER = "转账";
    public static final String ACCOUNTING_TYPE_CASH = "现金";

    /**status  状态 1：正常*/
    public static final String STATUS_OK = "正常";
    
    /**
     * 摘要: 
     * 01-供应商结算、02-供应商退款、03-供应商补货款、04-融资客户结算、05-退款融资客户、
     * 06-融资客户补货款、07-预存监管费、08-缴纳监管费、99-其他，默认选项为“07-预存监管费”
     */
    public enum AccountRecordType {
        
        SUPPLIER_SETTLEMENT("01","供应商结算"),
        SUPPLIER_REFUND("02","供应商退款"),
        SUPPLIER_REPLENISHMENT("03","供应商补货款"),
        FINANCING_CUSTOMER_SETTLEMENT("04","融资客户结算"),
        FINANCING_CUSTOMER_REFUND("05","退款融资客户"),
        FINANCING_CUSTOMER_REPLENISHMENT("06","融资客户补货款"),
        PRESTORAGE_SUPERVISIONFEE("07","预存监管费"),
        PAY_SUPERVISIONFEE("08","缴纳监管费"),
        OTHERS("99","其他");
        
        private static final Map<String, AccountRecordType> MAP = new HashMap<>();

        static {
            for (AccountRecordType typeEnum : values()) {
                MAP.put(typeEnum.getName(), typeEnum);
            }
        }

        public static AccountRecordType byName(String name) {
            if(MAP.containsKey(name)){
                return MAP.get(name);
            }else{
                return null;
            }

        }

        private static final Map<String, String> KV_MAP = new HashMap<>();
        
        static {
            for (AccountRecordType typeEnum : values()) {
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

        private AccountRecordType(String code, String name) {
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
}
