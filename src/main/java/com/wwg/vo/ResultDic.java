package com.wwg.vo;

public class ResultDic {
	
	public static final String SUCCESS_CODE_JSBK_FCG = "0000";
	public static final String RESULT_MSG_SUCCESS_JSBK_FCG = "处理成功";
	public static final String SUCCESS_CODE_JYRCB_FCG = "00000";
	public static final String RESULT_MSG_SUCCESS_JYRCB_FCG = "处理成功";
	public static final String SUCCESS_CODE_LSZ_FCG = "000000";
	public static final String RESULT_MSG_SUCCESS_LSZ_FCG = "成功";
	public static final String SUCCESS_CODE = "0";
	public static final String SUCCESS_DESC = "操作成功";
	public static final String SUCCESS_CODE_UCC = "0";
	public static final String SUCCESS_DESC_UCC = "操作成功";
	public static final String FAIL_CODE = "20000";
	public static final String FAIL_DESC = "操作失败";
	public static final String CHECK_USERNAME_CODE = "20001";
	public static final String CHECK_USERNAME_DESC = "用戶名已经存在";	
	public static final String JFPT_FILE_NOT_FOUND_ERROR_CODE = "20002";
	public static final String JFPT_FILE_NOT_FOUND_ERROR_DESC = "文件路径不存在";
	public static final String CHECK_FILE_SIZE_CODE = "20003";
	public static final String CHECK_FILE_SIZE_DESC = "文件大小不正确";
	public static final String CHECK_USERNAME_PASSWORD_CODE="20004";
	public static final String CHECK_USERNAME_PASSWORD_DESC="用户名与密码不正确";
	public static final String CHECK_USERNAME_ISEXIST_CODE="20005";
	public static final String CHECK_USERNAME_ISEXIST_DESC="该用户不存在";
	public static final String NOT_LOGIN="21000";
	public static final String NOT_LOGIN_DESC="用户未登录";
	public static final String CHECK_COMPANYNAME_CODE="20006";
	public static final String CHECK_COMPANYNAME_DESC="公司名称已存在";
	public static final String CHECK_TAX_NUMBER_CODE="20007";
	//public static final String CHECK_TAX_NUMBER_DESC="该税号已存在";
	public static final String CHECK_BANK_ACCOUNT_CODE="20008";
	public static final String CHECK_BANK_ACCOUNT_DESC="该银行账号已存在";
	public static final String CHECK_ENTERPRISE_CODE_CODE="20009";
	public static final String CHECK_ENTERPRISE_CODE_DESC="该组织机构代码已存在";
	public static final String CHECK_OLD_PASSWORD_CODE="20010";
	public static final String CHECK_OLD_PASSWORD_CODE_DESC="原始密码不准确";
	public static final String CHECK_PRODUCT_CODE="20011";
	public static final String CHECK_PRODUCT_CODE_DESC="未填写购买的商品";
	public static final String CHECK_FULLAMOUNT_CODE="20012";
	public static final String CHECK_FULLAMOUNT_CODE_DESC="全款采购，定金需等于商品总额";
	public static final String CHECK_GUARANTEES_CODE="20013";
	public static final String CHECK_GUARANTEES_CODE_DESC="非全款采购时，保证金需小于商品总额";
	public static final String CHECK_QUOTA_CODE="20014";
	public static final String CHECK_QUOTA_CODE_DESC="非全款采购，可用授信额度需要大于融资金额";
	public static final String CHECK_RATIO_CODE="20015";
	public static final String CHECK_RATIO_CODE_DESC="";
	public static final String CHECK_REDEMPTION_PRODUCT_CODE="20016";
	public static final String CHECK_REDEMPTION_PRODUCT_DESC="未选择赎回的商品";
	public static final String CHECK_REDEMPTION_DATE_CODE="20017";
	public static final String CHECK_REDEMPTION_DATE_DESC="未选择赎回的商品";
	public static final String CHECK_LOAN_AVALIABLE_CODE="20018";
	public static final String CHECK_LOAN_AVALIABLE_DESC="融资金额不能大于可用授信额度";

	public static final String CHECK_NOT_EXISTS_PURCHASE_PRODUCT_CODE="20019";
	public static final String CHECK_NOT_EXISTS_PURCHASE_PRODUCT_DESC="未找到相关入库商品记录！";
	
	public static final String CHECK_PURCHASE_PRODUCT_STATUS_NOTAPPLYPLEDGE_CODE="20020";
	public static final String CHECK_PURCHASE_PRODUCT_STATUS_NOTAPPLYPLEDGE_DESC="存在商品记录为非申请质押状态，不能生成仓单!";
	
	public static final String CHECK_NOT_EXISTS_BUSSINESS_USER_CODE="20021";
	public static final String CHECK_NOT_EXISTS_BUSSINESS_USER_DESC="未找到相关商品订单客户信息！";
	
	public static final String CHECK_NOT_EXISTS_WAREHOUSE_CODE="20022";
	public static final String CHECK_NOT_EXISTS_WAREHOUSE_DESC="未找到相关仓库信息！";

	public static final String CHECK_REDEMPTION_NO_CODE="2023";
	public static final String CHECK_REDEMPTION_NO_DESC="出库单表中已经存在该赎回申请单单号，不能重复插入！";
	public static final String WAREHOUSE_ERROR_CODE = "20023";
	public static final String WAREHOUSE_ERROR_DESC = "ERP导入不支持多人同步操作";
	public static final String CHECK_REDEMPTION_STATUS_CODE="20024";
	public static final String CHECK_REDEMPTION_STATUS_DESC="该赎回申请单，已确认解押，不能重复确认！";
	public static final String CHECK_REDEMPTION_VERSION_CODE="20025";
	public static final String CHECK_REDEMPTION_VERSION_DESC="更新失败，该赎回申请单版本号已经更新！";
	public static final String CHECK_BUSINESSUSER_VERSION_CODE="20026";
	public static final String CHECK_BUSINESSUSER_VERSION_DESC="更新失败，该用户信息版本号已经更新！";
	
	public static final String CHECK_BUSINESSUSER_APPROVE_CODE="20027";
	public static final String CHECK_BUSINESSUSER_APPROVE_DESC="该用户资料已审核！";
	public static final String CHECK_BANK_ORDERNO_CODE="20028";
	public static final String CHECK_BANK_ORDERNO_DESC="融资申请单编号不匹配，发送失败！";
	public static final String CHECK_BANK_REDEMPTIONNO_CODE="20029";
	public static final String CHECK_BANK_REDEMPTIONNO_DESC="赎回申请单编号不匹配，发送失败！";
	public static final String CHECK_OBJECT_ISNULL_CODE="20030";
	public static final String CHECK_OBJECT_ISNULL_DESC="数据提交不完整，提交失败！";
	public static final String CHECK_BANK_SEND_LOANINFO_CODE="20031";
	public static final String CHECK_BANK_SEND_LOANINFO_DESC="该融资申请单贷款信息，银行已发送金服，不能再次发送！";
	public static final String CHECK_PARAM_LEGAL_CODE="20032";
	public static final String CHECK_PARAM_LEGAL_DESC="参数中包含非法字符!";
	public static final String SALES_CONTRACT_NO_SAME_CODE="20033";
	public static final String SALES_CONTRACT_NO_SAME_CODE_DESC="销售合同号重复!";
	public static final String PURCHASE_CONTRACT_NO_SAME_CODE="20034";
	public static final String PURCHASE_CONTRACT_NO_SAME_DESC="采购合同号重复!";
	public static final String GUARANTEE_CONTRACT_NO_SAME_CODE="20035";
	public static final String GUARANTEE_CONTRACT_NO_SAME_DESC="担保合同号重复!";
	
	public static final String CHECK_USER_TRUE_CODE="20036";
	public static final String CHECK_USER_TRUE_DESC="无权限操作!";
	
	public static final String USER_BANK_ACCOUNT_ISEMPTY_CODE = "20037";
	public static final String USER_BANK_ACCOUNT_ISEMPTY_DESC = "未传入账户名";
	
	public static final String BANK_ACCOUNT_ISEXIST_CODE = "20038";
	public static final String BANK_ACCOUNT_ISEXIST_DESC = "该账户名下已存在第";
	public static final String BANK_ACCOUNTS_ISEXIST_DESC = "个银行账号";

	public static final String SUPPLIER_REFRENCE_NAME_ISEXIST_CODE = "20039";
	public static final String SUPPLIER_REFRENCE_NAME_ISEXIST_DESC = "供应商名称或社会统一信用代码已存在";


	public static final String CHECK_DEPOSIT_CODE="20040";
	public static final String CHECK_DEPOSIT_DESC="非全款采购时，定金需小于商品总额";
	public static final String CHECK_SEND_BANK_SUCCESS_CODE="20041";
	public static final String CHECK_SEND_BANK_SUCCESS_DESC="您已成功发送银行，不可再次发送";
	public static final String CHECK_SEND_BANK_AUDIT_UNSUCCESS_CODE="20042";
	public static final String CHECK_SEND_BANK_AUDIT_UNSUCCESS_DESC="您已审核不通过，不可发送银行";
	public static final String CHECK_SEND_BANK_NOT_AUDIT_CODE="20043";
	public static final String CHECK_SEND_BANK_NOT_AUDIT_DESC="请先复核通过，再发送银行";
	
	public static final String CHECK_CRECOMPANY_NO_CODE="20044";
	public static final String CHECK_CRECOMPANY_NO_DESC="该统一社会信用代码已存在";
	public static final String CHECK_COMPANY_LICENSE_CODE="20045";
	public static final String CHECK_COMPANY_LICENSE_DESC="该工商注册号已存在";
	
	public static final String INFO_NOT_PERFECT_CODE="20046";
	public static final String INFO_NOT_PERFECT_DESC="企业及银行信息不完善";
	
	public static final String COMPANY_INFO_NOT_PERFECT_CODE="20047";
	public static final String COMPANY_INFO_NOT_PERFECT_DESC="上传公司文件不完善";

	public static final String SEND_BANK_FAIL_CODE="20048";
	public static final String SEND_BANK_FAIL_DESC="发送银行接口未成功";

	public static final String SEND_BANKNO_FAIL_CODE="20049";
	public static final String SEND_BANKNO_FAIL_DESC="该银行订单号已经存在";

    public static final String RETURN_BANK_DATA_FAIL_CODE="20050";
    public static final String RETURN_BANK_DATA_FAIL_DESC="未收到银行网关数据";
    
    public static final String DEPOSIT_FAIL_CODE="20051";
    public static final String DEPOSIT_FAIL_DESC="定金金额不能为空";
    
    public static final String INTENTINFO_FAIL_CODE="20052";
    public static final String INTENTINFO_FAIL_DESC="授信额度不能为空";
	public static final String DEPOSIT_FAIL_ZERO_CODE="20053";
	public static final String DEPOSIT_FAIL_ZERO_DESC="定金金额应该大于0";
    
    public static final String JSCB_CREDIT_QUOTA_CODE="20055";
    public static final String JSCB_CREDIT_QUOTA_CODE_DESC="江苏银行授信额度不为空";
    
    public static final String CREDIT_QUOTA_ERROR_CODE="20054";
    public static final String CREDIT_QUOTA_ERROR_CODE_DESC="授信额度不应小于已用额度";

	public static final String PLEDGE_RATE = "30000";
	public static final String PLEDGE_RATE_DESC="实际质押率大于合同填写质押率,不可申请赎回";

	public static final String KAPTCHA_CODE = "30001";
	public static final String KAPTCHA_DESC = "验证码不正确";
	
	public static final String FRONT_USER_ACCOUNT="FRONT_USER_ACCOUNT";
	public static final String FRONT_USER_ACCOUNT_SESSION_KEY="FRONT_USER_ACCOUNT_SESSION_KEY";
	public static final String COOKIE_WSN_JF_FRONT_NAME="wsn_jf_front_name";
	public static final String BACK_USER_ACCOUNT="OPERATER_ACCOUNT";
	public static final String BACK_USER_ACCOUNT_SESSION_KEY = "OPERATER_ACCOUNT_SESSION_KEY";
	public static final String APP_USER_ACCOUNT="APP_ACCOUNT";
	
	public static final String FRONT_USER_LOGIN_KEY = "front_user_login_key_";
	public static final String FRONT_USER_LOGIN_EXPIRATION_TIME = "front.user.login.expiration.time.minutes";
	
	public static final String BACK_USER_LOGIN_KEY = "back_user_login_key_";
	public static final String BACK_USER_LOGIN_EXPIRATION_TIME = "back.user.login.expiration.time.minutes"; 

	public static final String ORDER_AMOUNT_NOT_MATCH_CODE = "2048";
	public static final String ORDER_AMOUNT_NOT_MATCH_DESC = "订单金额不匹配";

	public static final String CHECK_USER_AVAILABLE_QUOTA_CODE="20056";
	public static final String CHECK_USER_AVAILABLE_QUOTA_DESC="平台可用额度更新失败！";
	public static final String CHECK_USER_BANK_AVAILABLE_QUOTA_CODE="20057";
	public static final String CHECK_USER_BANK_AVAILABLE_QUOTA_DESC="用户银行账号可用额度更新失败！";
	public static final String CHECK_USER_ORDER_TOTALCAPITAL_AMOUNT_CODE="20058";
	public static final String CHECK_USER_ORDER_TOTALCAPITAL_AMOUNT_DESC="更新订单总还款金额失败！";

	public static final String USER_BANK_ACCOUNT_ISEXIST_CODE="20059";
	public static final String USER_BANK_ACCOUNT_ISEXIST_DESC="的银行账号已存在";
	public static final String USER_BANK_ACCOUNT_ISEXIST_CODE_DESC="该银行账号已存在";
	public static final String USER_OTHER_BANK_ACCOUNT_ISEXIST_DESC="的银行账号已被其他用户使用";
	public static final String USER_OTHER_BANK_ACCOUNT_ISEXIST_CODE_DESC="该银行账号已被其他用户使用";


	public static final String CHECK_USER_BANK_AVAILABLE_NOT_EXITS_CODE="20060";
	public static final String CHECK_USER_BANK_AVAILABLE_NOT_EXITS_DESC="调用银行接口，未查询到该用户可用授信额度！";
	public static final String CHECK_USER_BANK_ACCOUNT_NOT_EXITS_CODE="20061";
	public static final String CHECK_USER_BANK_ACCOUNT_NOT_EXITS_DESC="银行账户不存在！";

	public static final String LOGIN_NOT_ALLOWED_CODE = "20062";
	public static final String LOGIN_NOT_ALLOWED_DESC = "已多次输入错误密码，暂时不允许登录！";
    public static final String DEPOSIT_EMPTY_FAIL_CODE="20063";
    public static final String DEPOSIT_EMPTY_FAIL_DESC="请先输入定金，再审批！";
    
    public static final String PRODUCT_UNIFIEDPRODUCT_MODEL_ISEMPTY_CODE="20064";
    public static final String PRODUCT_NO_DESC = "卷号为";
    public static final String PRODUCT_UNIFIEDPRODUCT_MODEL_ISEMPTY_DESC  = " 的产品统一标示型号为空，不能发送银行，请录入统一标示型号后继续发送！！！";
    public static final String PRODUCT_UNIFIEDPRODUCT_MODEL_CONX_CODE="200641";
    public static final String PRODUCT_UNIFIEDPRODUCT_MODEL_CONX_DESC="包含了银行无标识符的商品不允许质押";
    

    public static final String TIME_OUT_CODE="20065";
    public static final String TIME_OUT_DESC="发送时间必须在当日的下午5点半之前";
    
    public static final String SEND_DAILY_PRICE_FILE_CODE="20066";
    public static final String SEND_DAILY_PRICE_FILE_DESC="每天只可发送一次，您已发送，无需重复发送";
    
    public static final String SEND_DAILY_PRICE_FILE_ISEXIST_CODE="20067";
    public static final String SEND_DAILY_PRICE_FILE_ISEXIST_DESC="推送正在处理中，您无需重复操作";
    
    public static final String SUPERVISION_FEESTATUS_RECORD_CODE="20068";
    public static final String SUPERVISION_FEESTATUS_RECORD_DESC="监管费未录入,不可以确认支付";
    
    public static final String SALA_CONTRACT_NO_CREATE_CODE="20069";
	public static final String SALA_CONTRACT_NO_CREATE_DESC="销售合同号生成失败！";
	
    public static final String MOBILE_IS_EXISTS_CODE="20070";
    public static final String MOBILE_IS_EXISTS_DESC="该手机已经注册过！";
    
    public static final String EMAIL_ISEXIST_CODE="20071";
	public static final String EMAIL_ISEXIST_DESC="该邮箱已存在！";
    
    public static final String MOBILE_NOT_EXISTS_CODE="20072";
    public static final String MOBILE_NOT_EXISTS_DESC="该手机未注册！";
    
    public static final String RESET_PASSWD_OVERTIME_CODE="20073";
    public static final String RESET_PASSWD_OVERTIME_DESC="设置密码超时，请重新发起找回密码！";
    
    public static final String SEND_VERIFICATIONCODE_FAIL_CODE="20074";
    public static final String SEND_VERIFICATIONCODE_FAIL_DESC="发送验证码失败，请重新发送！";
    
    public static final String CHECK_VERIFICATIONCODE_FAIL_CODE="20075";
    public static final String CHECK_VERIFICATIONCODE_FAIL_DESC="校验验证码失败，请重新输入验证码！";
    
    public static final String ERP_SYSTEM_INSTOCK_DELIVERY_FAIL_CODE = "20076";
    public static final String ERP_SYSTEM_INSTOCK_DELIVERY_FAIL_DESC = "连接ERP系统 在库提货流程失败！";

    public static final String ES_SYSTEM_MOVE_PRODUCT_NOT_FAIL_CODE = "20077";
    public static final String ES_SYSTEM_MOVE_PRODUCT_NOT_FAIL_DESC = "移库产品不存在！";
    
    public static final String CY_SYSTEM_DAILY_PRICE_FAIL_CODE = "20078";
    public static final String CY_SYSTEM_DAILY_PRICE_FAIL_DESC = "每日价格推送给仓押系统失败！";

    public static final String ES_SYSTEM_ADD_PRODUCT_FAIL_CODE = "20079";
    public static final String ES_SYSTEM_ADD_PRODUCT_FAIL_DESC = "入库产品存在重复质押！";
    
    public static final String ORDER_DATA_TO_ERP_FAIL_CODE="20079";
    public static final String ORDER_DATA_TO_ERP_FAIL_DESC="融资订单信息推送EPR失败！";
    
    public static final String ES_SYSTEM_ADD_PRODUCT_DONE_FAIL_CODE = "20080";
    public static final String ES_SYSTEM_ADD_PRODUCT_DONE_FAIL_DESC = "该合同下产品已出库！";
    
    public static final String UPDATE_ORDER_STATUS_FAILD_CODE="20081";
	public static final String UPDATE_ORDER_STATUS_FAILD_DESC="该融资单正在审核！";
	
    public static final String ORDER_ALREADY_APPROVED_CODE="20082";
    public static final String ORDER_ALREADY_APPROVED_DESC="该融资单已审核！";
    
    public static final String ORDER_APPROVING_CODE="20083";
    public static final String ORDER_APPROVING_DESC="该融资单正在审核中，不得重复审核！";
    
    public static final String ORDER_ALREADY_SENT_TO_BANK_CODE="20084";
    public static final String ORDER_ALREADY_SENT_TO_BANK_DESC="该融资单已发送银行！";
    
    public static final String ORDER_SENDING_TO_BANK_CODE="20085";
    public static final String ORDER_SENDING_TO_BANK_DESC="该融资单正在发送中，不得重复发送！";
    
    public static final String ORDER_ALREADY_PLEDGED_CODE="20086";
    public static final String ORDER_ALREADY_PLEDGED_DESC="该融资单已发送质押申请！";
    
    public static final String ORDER_APPLYING_PLEDGE_CODE="20087";
    public static final String ORDER_APPLYING_PLEDGE_DESC="该融资单正在发送中，不得重复发送！";
    
    public static final String USERID_NO_HAVE_CODE="20088";
    public static final String USERID_NO_HAVE_DESC="用户ID未传入";
    
    public static final String ORDERID_NO_HAVE_CODE="20089";
    public static final String ORDERID_NO_HAVE_DESC="订单ID未传入";
    
	public static final String CONTRACT_SIGN_CODE="20090";
	public static final String CONTRACT_SIGN_CODE_DESC="合同未签订!";
	
    public static final String ORDER_APPLYING_BANK_NULL_CODE="20091";
    public static final String ORDER_APPLYING_BANK_NULL_DESC="没有该融资银行的信息！";
    
    public static final String ORDER_APPLYING_ENDDATA_CODE="20092";
    public static final String ORDER_APPLYING_ENDDATA_DESC="当前融资银行额度不在有效期内，请重新申请额度后进行融资！";
    
    public static final String ACCOUNT_BANK_CODE_ISEXIST_CODE="20093";
	public static final String ACCOUNT_BANK_CODE_ISEXIST_DESC="添加重复";
	public static final String ACCOUNT_BANK_CODE_ISEXIST__CODE_DESC="该账户下已存在";
	

	
    public static final String BANK_NAME_EXISTS_CODE="20094";
    public static final String BANK_NAME_EXISTS_DESC="此银行名称已经存在！";
    
    public static final String BANK_CODE_EXISTS_CODE="20095";
    public static final String BANK_CODE_EXISTS_DESC="此银行编码已经存在！";
    
 
    public static final String CHECK_BANK_APPROVE_CODE="20096";
	public static final String CHECK_BANK_APPROVE_DESC="该用户的该银行账户已审核！";
	
	public static final String CHECK_BUSINESSUSER_NOT_APPROVE_CODE="20097";
	public static final String CHECK_BUSINESSUSER_NOT_APPROVE_DESC="该用户资料未复核或复核不通过！";
	
	public static final String CHECK_LOANAMOUNT_NOTEAUAL_QUOTA_CODE="20098";
	public static final String CHECK_LOANAMOUNT_NOTEAUAL_QUOTA_DESC="放款金额和实际融资金额不一致！";
	
	public static final String ORDER_NO_FAIL_CODE="20099";
	public static final String ORDER_NO_FAIL_CODE_DESC="订单号未传入";
	    
	public static final String REDEMPTIONID_NO_HAVE_CODE="20100";
	public static final String REDEMPTIONID_NO_HAVE_DESC="赎回申请单ID未传入";
	
    public static final String REPAYID_NO_HAVE_CODE="20101";
    public static final String REPAYID_NO_HAVE_DESC="还款ID未传入";

    public static final String REDEMPTION_NO_HAVE_CODE="20102";
    public static final String REDEMPTION_NO_HAVE_DESC="赎回申请单号未传入";
     
    public static final String BNAK_LOAN_AMOUNT_COMPARE_CODE="20103";
    public static final String BNAK_LOAN_AMOUNT_COMPARE_DESC="偿还本金应小于等于贷款总金额";
    
    public static final String REDEMPTION_TIP_CODE="20104";
    public static final String REDEMPTION_TIP_DESC="赎回商品总金额大于本次还款本金，请重新选择赎回商品后提交!";
    
    public static final String TAXID_ISEXIST_CODE="20105";
   	public static final String TAXID_ISEXIST_DESC="该税号已存在！";
    
    public static final String SUPERVISIONFEE_DATA_TO_ERP_FAIL_CODE="20106";
    public static final String SUPERVISIONFEE_DATA_TO_ERP_FAIL_DESC="解押通知书监管费推送EPR失败！";
    
	public static final String CHECK_BANK_LOAN_RECORD_PRIN_AMT_CODE="20107";
	public static final String CHECK_BANK_LOAN_RECORD_PRIN_AMT_DESC="更新借款表贷款余额失败！";
	
	public static final String REDEMPTION_HAS_AUDIT_CODE="20108";
	public static final String REDEMPTION_HAS_AUDIT_DESC="此笔赎回申请已经审核过！";
	
    public static final String UPDATE_BANKINFO_RULE_CODE="20109";
    public static final String UPDATE_BANKINFO_RULE_DESC="该银行属于复核未通过状态，不允许修改";
    

    public static final String BANK_CREDITQUOTA_LIMIT_CODE="20110";
    public static final String BANK_CREDITQUOTA_LIMIT_DESC="银行总额度不能小于可用总额度";
    
    public static final String REPAY_FILR_URL_CODE="20111";
    public static final String REPAY_FILR_URL_DESC="还款本金或还款利息不为0时，则还款凭证不能为空";
    
    public static final String AMOUNT_A_POSITIVE_NUMBER_CODE="20112"; 
    public static final String AMOUNT_A_POSITIVE_NUMBER_DESC="还款本金或还款利息不能为负数";
    
    public static final String GROUP_ID_NOT_CODE="20113"; 
    public static final String GROUP_ID_NOT_DESC="ID 未传入";

    public static final String UPDATE_CREDITQUOTA_RULE_CODE="20114";
    public static final String UPDATE_CREDITQUOTA_RULE_DESC="A类银行不允许修改授信额度";
    
    public static final String UPLOAD_IMAGE_RULE_CODE="20115";
    public static final String UPLOAD_IMAGE_RULE_DESC="图片上传不支持该格式";
    
    public static final String CHECK_BUSINESSUSER_REVIEW_CODE="20116";
	public static final String CHECK_BUSINESSUSER_REVIEW_DESC="该用户资料已复核！";
	
	public static final String CHECK_BANK_REVIREW_CODE="20117";
	public static final String CHECK_BANK_REVIREW_DESC="该用户的该银行账户已复核！";
    public static final String ORDER_ALREADY_MARGIN_CODE="20117";
    public static final String ORDER_ALREADY_MARGIN_DESC="监管费到账已确认！";
    
    public static final String UPDATE_ORDER_MARGIN_FAILD_CODE="20118";
	public static final String UPDATE_ORDER_MARGIN_FAILD_DESC="监管费到账正在确认中！";
	
    public static final String ORDER_MARGIN_CODE="20119";
    public static final String ORDER_MARGIN_DESC="监管费到账正在确认，不得重复确认！";
    
    public static final String BANK_CREDITQUOTA_ERROR_CODE="20120";
    public static final String BANK_CREDITQUOTA_ERROR_DESC="授信额度不能超过银行的可用授信额度！";

    public static final String CHECK_USERNAME_STATUS_CODE="20121";
    public static final String CHECK_USERNAME_STATUS_DESC="该用户属于认证未通过状态，不允许登录";
    
    public static final String MARKET_GROUP_NAME_ISEXIST_CODE="20122";
    public static final String MARKET_GROUP_NAME_ISEXIST_DESC="组名称已存在";
    
    public static final String ISISEXSITS="20123";
    public static final String ISISEXSITS_DESC="不能重复提交";
    
    public static final String MARKET_GROUP_MUST_SELECT_CODE="20124";
    public static final String MARKET_GROUP_MUST_SELECT_DESC="银行组信息必须选择";
    
    public static final String MARKET_GROUP_SELECT_ERROR_CODE="20125";
    public static final String MARKET_GROUP_SELECT_ERROR_DESC="银行组信息选择不正确";

    public static final String BANK_ACCOUNT_STATUS_ISNOT_DELETE_CODE="20126";
    public static final String BANK_ACCOUNT_DESC="银行卡号为 ";
    public static final String BANK_ACCOUNT_STATUS_ISNOT_DELETE_DESC="，正处于流程审核，不允许删除，";
    
    public static final String SEND_BANK_FAILE_CODE="20127";
    public static final String SEND_BANK_FAILE_DESC="发送银行获取授信额度失败";
    
	public static final String CONTRACT_CONFIRM_CODE="20128";
	public static final String CONTRACT_CONFIRM_CODE_DESC="合同已确认,请勿重复操作!";
	
    public static final String LOAD_CARD_NUMBER_ISEXIST_CODE="20129";
   	public static final String LOAD_CARD_NUMBER_ISEXIST_DESC="该贷款卡编号已存在！";
   	
   	public static final String MANAGER_PHONE_NOT_EXISTS_CODE="20130";
   	public static final String MANAGER_PHONE_NOT_EXISTS_DESC="没有查询到相关客户经理的联系方式！";
   	
   	public static final String SEND_MASSAGE_FAILE_CODE="20131";
   	public static final String SEND_MASSAGE_FAILE_DESC="短信发送失败！";
   	
   	public static final String ORDER_REVIEW_STATUS_ERR="20132";
   	public static final String ORDER_REVIEW_STATUS_ERR_DESC="该订单已经复核通过，不能重复操作！";
   	
   	public static final String ORDER_REVIEW_DOING="20133";
   	public static final String ORDER_REVIEW_DOING_DESC="订单正在复核中，请稍后重试！";
   	
    public static final String DEPOSIT_ALREADY_MARGIN_CODE="20134";
    public static final String DEPOSIT_ALREADY_MARGIN_DESC="定金已确认到账!";
    
    public static final String CONTRACT_PAY_RECEIPT_CODE="20135"; 
    public static final String CONTRACT_PAY_RECEIPT_DESC="付款回执已上传！";
     
    public static final String PRODUCT_ATTRIBUTE_EXISTS_CODE="20136"; 
    public static final String PRODUCT_ATTRIBUTE_EXISTS_DESC="商品名称已经存在！";
    
    public static final String APPLYNO_NOT_EXIST_CODE="20137"; 
    public static final String APPLYNO_NOT_EXIST_DESC="找不到对应的申请流水号！";
    
    public static final String PRODUCT_MODEL_REPEAT_CODE="20138"; 
    public static final String PRODUCT_MODEL_REPEAT_DESC="商品型号重复！";
    
    public static final String CHECK_FILE_TYPE_CODE = "20139";
	public static final String CHECK_FILE_TYPE_DESC = "文件类型不正确";
	
	public static final String CHECK_MANUFACTURER_NULL_CODE = "20140";
	public static final String CHECK_MANUFACTURER_NULL_DESC = "钢厂不能为空";
	
	public static final String CHECK_MANUFACTURER_TYPE_ERROR_CODE = "20141";
	public static final String CHECK_MANUFACTURER_TYPE_ERROR_DESC = "钢厂只能输入中文或数字，且不超过30个字符";
	
	public static final String CHECK_PRODUCT_NAME_NULL_CODE = "20142";
	public static final String CHECK_PRODUCT_NAME_NULL_DESC = "商品名称不能为空";
	
	public static final String CHECK_PRODUCT_NAME_TYPE_ERROR_CODE = "20143";
	public static final String CHECK_PRODUCT_NAME_TYPE_ERROR_DESC = "商品名称只能输入字符或数字，且不超过30个字符";
	
	public static final String CHECK_PRODUCT_MODEL_NULL_CODE = "20144";
	public static final String CHECK_PRODUCT_MODEL_NULL_DESC = "型号不能为空";
	
	public static final String CHECK_PRODUCT_MODEL_ERROR_CODE = "20145";
	public static final String CHECK_PRODUCT_MODEL_ERROR_DESC = "型号不能超过30个字符且不能包含空格";
	
	public static final String CHECK_SPECIFICATION_NULL_CODE = "20146";
	public static final String CHECK_SPECIFICATION_NULL_DESC = "规格不能为空";
	
	public static final String CHECK_SPECIFICATION_ERROR_CODE = "20147";
	public static final String CHECK_SPECIFICATION_ERROR_DESC = "规格不能超过30个字符";
	
	public static final String CHECK_UNIT_PRICE_NULL_CODE = "20148";
	public static final String CHECK_UNIT_PRICE_NULL_DESC = "单价不能为空";
	
	public static final String CHECK_UNIT_PRICE_ERROR_CODE = "20149";
	public static final String CHECK_UNIT_PRICE_ERROR_DESC = "单价输入不正确";
	
	public static final String CHECK_UNIT_PRICE_ZERO_ERROR_CODE = "20150";
	public static final String CHECK_UNIT_PRICE_ZERO_ERROR_DESC = "单价必须大于零";
	
	public static final String CHECK_WEIGHT_NULL_CODE = "20151";
	public static final String CHECK_WEIGHT_NULL_DESC = "重量不能为空";
	
	public static final String CHECK_WEIGHT_ZERO_ERROR_CODE = "20152";
	public static final String CHECK_WEIGHT_ZERO_ERROR_DESC = "重量必须大于零";
	
	public static final String CHECK_WEIGHT_ERROR_CODE = "20153";
	public static final String CHECK_WEIGHT_ERROR_DESC = "重量输入不正确";
	
	public static final String CHECK_QUANTITY_NULL_CODE = "20154";
	public static final String CHECK_QUANTITY_NULL_DESC = "数量不能为空";
	
	public static final String CHECK_QUANTITY_ZERO_ERROR_CODE = "20155";
	public static final String CHECK_QUANTITY_ZERO_ERROR_DESC = "数量必须为正整数";
	
	public static final String CHECK_QUANTITY_ERROR_CODE = "20156";
	public static final String CHECK_QUANTITY_ERROR_DESC = "数量输入不正确";
	
	public static final String CHECK_QUANTITY_MUST_ONE_CODE = "20157";
	public static final String CHECK_QUANTITY_MUST_ONE_DESC = "卷号不为空时数量必须为1";
	
	public static final String CHECK_WEIGHT_UNIT_ERROR_CODE = "20158";
	public static final String CHECK_WEIGHT_UNIT_ERROR_DESC = "重量单位必须为“吨”！";
	
	public static final String CHECK_QUANTITY_UNIT_ERROR_CODE = "20159";
	public static final String CHECK_QUANTITY_UNIT_ERROR_DESC = "数量单位只能为：“卷”、“件”、“箱”、“盒”、“捆”！";
	
	public static final String CHECK_PRODUCT_NO_BLANK_CODE = "20160";
	public static final String CHECK_PRODUCT_NO_BLANK_DESC = "卷号不能含有空格";
	
	public static final String CHECK_SPECIFICATION_BLANK_CODE = "20161";
	public static final String CHECK_SPECIFICATION_BLANK_DESC = "规格不能含有空格";
	
	public static final String CHECK_EXCEL_NO_DATA_CODE = "20162";
	public static final String CHECK_EXCEL_NO_DATA_DESC = "excel中没有获取数据";
	
	public static final String CHECK_TOTAL_CAPITAL_AMOUNT_CODE = "20163";
	public static final String CHECK_TOTAL_CAPITAL_AMOUNT_DESC = "查询贷款异常";
	
    public static final String ERP_SYSTEM_ONTHEWAY_DELIVERY_FAIL_CODE = "20164";
    public static final String ERP_SYSTEM_ONTHEWAY_DELIVERY_FAIL_DESC = "连接ERP系统 在途提货流程失败！";
    
    public static final String CHECK_BANK_CAPITAL_AMOUNT_CODE = "20165";
	public static final String CHECK_BANK_CAPITAL_AMOUNT_DESC = "银行查询贷款异常";
	
	public static final String PRODUCT_MODEL_QOUTA_ERROR_CODE = "20166";
	public static final String PRODUCT_MODEL_QOUTA_ERROR_DESC = "新设定的总额度不能小于已用额度";
	
	public static final String EXCEL_TEMPLATE_NOT_NEW_CODE = "20167";
	public static final String EXCEL_TEMPLATE_NOT_NEW_DESC = "不是最新的excel模板，请下载最新的模板!";
	
	public static final String CHECK_CATEGORY_NULL_CODE = "20168";
	public static final String CHECK_CATEGORY_NULL_DESC = "商品类型不能为空";
	
	public static final String CHECK_CATEGORY_ERROR_CODE = "20169";
	public static final String CHECK_CATEGORY_ERROR_DESC = "商品类型只能为“不锈钢”或“黑材”!";
	
	public static final String CHECK_CATEGORY_DISSIMILARITY_CODE = "200170";
	public static final String CHECK_CATEGORY_DISSIMILARITY_DESC = "同一笔订单，商品类型只能有一种!";
	
	public static final String SEND_BANK_CODE = "200171";
	public static final String SEND_BANK_DESC = "融资单已发送银行,不能关闭";
	
	public static final String BANK_AUDIT_DOING_CODE = "200172";
	public static final String BANK_AUDIT_DOING_DESC = "该融资单银行正在审核中,不能关闭";
	
	public static final String BANK_LOAN_DONE_CODE = "200173";
	public static final String BANK_LOAN_DONE_DESC = "该融资单银行已放款,不能关闭";
	
	public static final String ORDER_CLOSEING_CODE = "200174";
	public static final String ORDER_CLOSEING_DESC = "该融资单正在关闭，不能操作";
	
	public static final String ORDER_CLOSED_CODE = "200175";
	public static final String ORDER_CLOSED_DESC = "该融资单已关闭，不能操作";
	
	public static final String ORDER_CLOSE_DONE_CODE = "200176";
	public static final String ORDER_CLOSE_DONE_DESC = "该融资单关闭已处理，不能操作";
	
	/*行情相关的参数校验*/
	public static final String QUOTATION_DATEINTERVAL_EMPTY_CODE = "200177";
	public static final String QUOTATION_DATEINTERVAL_EMPTY_DESC = "未正确指定dateInterval字段";

	public static final String QUOTATION_PRODUCTMODEL_EMPTY_CODE = "200178";
	public static final String QUOTATION_PRODUCTMODEL_EMPTY_DESC = "产品型号不得为空";
	
	public static final String QUOTATION_SPECIFICATION_EMPTY_CODE = "200179";
	public static final String QUOTATION_SPECIFICATION_EMPTY_DESC = "产品规格不得为空";
	/*行情相关的参数校验*/
	
	public static final String MARKET_GROUPID_EMPTY_CODE = "200180";
	public static final String MARKET_GROUPID_EMPTY_DESC = "组信息未传入";
	
	public static final String UNREDEEMED_REDEMPTION_BY_ORDERNO_CODE = "200181";
	public static final String UNREDEEMED_REDEMPTION_BY_ORDERNO_DESC = "该融资单下存在银行未确认赎回单，请您等待银行确认之后再申请赎回";
	
	public static final String REDEMPTION_DEAL_CODE = "200182";
	public static final String REDEMPTION_DEAL_DESC = "已有赎回单在处理中";
	
	public static final String MODEL_QUOTA_OVER_LIMIT_CODE = "200183";
	public static final String MODEL_QUOTA_OVER_LIMIT_DESC = "型号商品当月剩余额度为";
	public static final String MODEL_QUOTA_OVER_LIMIT_DESC_CONNECT = "元，请修改商品信息后导入！";
	
	public static final String MODEL_QUOTA_NO_DATA_CODE = "200184";
	public static final String MODEL_QUOTA_NO_DATA_DESC = "商品型号在型号额度表没有查询到数据";
	
	public static final String REDEMPTION_HAVE_OTHER_PRODUCT_CODE = "200185";
	public static final String REDEMPTION_HAVE_OTHER_PRODUCT_DESC = "该赎回单的商品存在于其他的赎回单中";
	
	public static final String ORDER_FINANCE_RATIO_CODE = "200186";
	public static final String ORDER_FINANCE_RATIO_DESC = "该融资银行的融资比例不能为100%";
	
	public static final String PLEDGENO_NOT_EMPTY_CODE = "200187";
	public static final String PLEDGENO_NOT_EMPTY_DESC = "质押单号不能为空";
	
	public static final String UPDATE_ALARM_INFO_FAIL_CODE = "200188";
	public static final String UPDATE_ALARM_INFO_FAIL_DESC = "更新告警信息失败";
	
	public static final String ADD_ALARM_INFO_FAIL_CODE = "200189";
	public static final String ADD_ALARM_INFO_FAIL_DESC = "新增告警信息失败";
	
	public static final String SEND_ALARM_FAIL_CODE = "200190";
	public static final String SEND_ALARM_FAIL_DESC = "部分告警信息发送失败！";
	
	public static final String UPDATE_ALARM_SEND_STATUS_FAIL_CODE = "200191";
	public static final String UPDATE_ALARM_SEND_STATUS_FAIL_DESC = "更新告警信息的发送状态失败！告警号为：";
	
	public static final String BANK_QUOTA_TIP_CODE = "200192";
	public static final String BANK_QUOTA_TIP_DESC = "该客户已用额度已超过调整后的授信额度，额度更新失败，请与银行联系！！";
	
	public static final String REPAYMENT_AMOUNT_NOT_ENOUGH_CODE = "200193";
	public static final String REPAYMENT_AMOUNT_NOT_ENOUGH_DESC = "该笔订单的还款金额少于赎回商品的总金额，不允许解押提货！";
	
	public static final String REVIEW_MODEL_QUOTA_OVER_LIMIT_CODE = "200194";
	public static final String REVIEW_MODEL_QUOTA_OVER_LIMIT_DESC = "型号商品当月剩余额度为";
	public static final String REVIEW_MODEL_QUOTA_OVER_LIMIT_DESC_CONNECT = "元，该笔订单中此型号的商品已超过此额度！";
	
	public static final String CHECK_LOAN_AVALIABLE_ENOUGH_CODE="200195";
	public static final String CHECK_LOAN_AVALIABLE_ENOUGH_DESC="融资金额及审核通过金额不能大于可用授信额度";
	
	public static final String ERROR_CODE_RESPONSE_ERROR = "21001";
	public static final String ERROR_MSG_RESPONSE_ERROR = "获取响应异常";
	
	public static final String ERROR_CODE_RESPONSE_TIMEOUT = "21002";
	public static final String ERROR_MSG_RESPONSE_TIMEOUT = "获取响应超时";
	
	public static final String ERROR_CODE_FCG_PROCESS_ERROR = "21003";
	public static final String ERROR_MSG_FCG_PROCESS_ERROR = "网关处理异常";
	
	public static final String CHECK_ALL_REDEMPTION_CODE = "200196";
	public static final String ORDER_TOTAL_AMOUNT_DESC ="该订单货物总金额为： ";
	public static final String ORDER_REDEMPTIONA_MOUNT_DESC ="已经赎回的金额为： ";
    public static final String APPLICATION_REDEMPTION_AMOUNT_DESC =" 本次赎回的金额为： ";
    public static final String UNIT_DESC = "元";
	public static final String CHECK_ALL_REDEMPTION_DESC = "该合同借款将全部还清，请确认该合同商品是否全部入库，若未全部入库请先拒绝该赎回申请，否则该合同下后续入库的商品，将不能进行赎回！！！是否继续？？？";
	
	public static final String CHECK_SAME_DUEBILLNO_CODE = "200196";
	public static final String CHECK_SAME_DUEBILLNO_DESC = "该银行下已存在该借据号";
	
	public static final String CHECK_BANK_REPAY_RECORD_PRIN_AMT_CODE="200197";
	public static final String CHECK_BANK_RECORD_RECORD_PRIN_AMT_DESC="更新还款表贷款余额失败！";
	
	public static final String START_LOAN_CODE = "200198";
	public static final String START_LOAN_DESC = "融资客户已发起借款,不能关闭";
	
	public static final String ORDER_HAS_ENTERED_PROCUREMENT_STAGE_CODE="200199";
	public static final String ORDER_HAS_ENTERED_PROCUREMENT_STAGE_DESC="该融资申请已经进入采购阶段，不允许作废！";
	
	public static final String ORDER_APPROVE_NOT_PASS_CODE="200200";
	public static final String ORDER_APPROVE_NOT_PASS_DESC="该融资申请审核不通过，不允许作废！";
	
	public static final String ORDER_HAS_APPLY_CLOSE_CODE="200120";
	public static final String ORDER_HAS_APPLY_CLOSE_DESC="该融资申请已在运营平台进入关闭审核阶段，不允许作废！";

	public static final String CHECK_MANUFACTURER_USERING_CODE="200312";
	public static final String CHECK_MANUFACTURER_USERING_DESC="钢厂在使用中";

	public static final String CHECK_MANUFACTURER_NAME_IS_EXIST_CODE="200121";
	public static final String CHECK_MANUFACTURER_NAME_IS_EXIST_DESC="钢厂名称已存在";
	
	public static final String CHECK_MANUFACTURER_IS_NOT_EXIST_CODE="200122";
	public static final String CHECK_MANUFACTURER_IS_NOT_EXIST_DESC="该钢厂不存在，请您检查后重试";
	
	public static final String SUPPLEMENT_DEPOSIT_NO_ENOUGH_CODE="200123";
	public static final String SUPPLEMENT_DEPOSIT_NO_ENOUGH_DESC="需补定金至少要大于等于";
	
	public static final String ORDER_STATUS_NOT_USER_SUBMIT_CODE="200124";
	public static final String ORDER_STATUS_NOT_USER_SUBMIT_DESC="订单状态为：";
	public static final String ORDER_STATUS_NOT_USER_SUBMIT_CONNECT_DESC="，不能操作！";
	
	public static final String SUPPLEMENT_DEPOSIT_INSUFFICIENT_CODE="200125";
	public static final String SUPPLEMENT_DEPOSIT_INSUFFICIENT_DESC="已输入的需补定金不足，需补定金至少需要为：";
	
	public static final String BANK_PLEDGE_REQ_CODE = "9999";
	public static final String BANK_PLEDGE_REQ_DESC = "推送质押清单不全，将会列入平台可赎回商品列表";
	
	public static final String CREDITQUOTA_NOT_COMPLETE_CODE="200126";
	public static final String CREDITQUOTA_NOT_COMPLETE_DESC="授信额度未用完，不能以偿还方式还款"; 
	
	public static final String REPAY_QUOTA_ERROR_CODE="200127";
	public static final String REPAY_QUOTA_ERROR_DESC="偿还金额不能大于授信额度"; 
	
	public static final String DEPOSIT_GREATER_THAN_TOTAL_AMOUNT_ERROR_CODE="200128";
	public static final String DEPOSIT_GREATER_THAN_TOTAL_AMOUNT_ERROR_DESC="定金金额不能大于订单总金额";
	
	public static final String UPDATE_PASSWORD_FROM_UCC_ERROR_CODE = "200135";
	public static final String UPDATE_PASSWORD_FROM_UCC_ERROR_DESC = "从统一客户中心更新用户密码失败"; 
	
	public static final String BUSINESS_USER_ACCOUNT_NOT_EMPTY_ERROR_CODE = "200129";
	public static final String BUSINESS_USER_ACCOUNT_NOT_EMPTY_ERROR_DESC = "用户名不得为空"; 
	
	public static final String BUSINESS_USER_PASSWORD_NOT_EMPTY_ERROR_CODE = "200130";
	public static final String BUSINESS_USER_PASSWORD_NOT_EMPTY_ERROR_DESC = "密码不得为空"; 
	
	public static final String BUSINESS_USER_SALT_NOT_EMPTY_ERROR_CODE = "200131";
	public static final String BUSINESS_USER_SALT_NOT_EMPTY_ERROR_DESC = "加密Salt值不得为空"; 
	
	public static final String BUSINESS_USER_SALT_MAX_10_ERROR_CODE = "200132";
	public static final String BUSINESS_USER_SALT_MAX_10_ERROR_DESC = "加密Salt值最大10个字符"; 
	
	public static final String BUSINESS_USER_ACCOUNT_MAX_32_ERROR_CODE = "200133";
	public static final String BUSINESS_USER_ACCOUNT_MAX_32_ERROR_DESC = "用户名最大32个字符"; 
	
	public static final String BUSINESS_USER_PASSWORD_MAX_255_ERROR_CODE = "200134";
	public static final String BUSINESS_USER_PASSWORD_MAX_255_ERROR_DESC = "用户名最大255个字符"; 
	
	public static final String UCC_USERNAME_EXIST_FAIL_CODE = "20002";
	public static final String UCC_USERNAME_EXIST_FAIL_DESC = "用户名已存在";
	
	public static final String UCC_USERNAME_CHECK_SUCCESS_CODE = "0";
	public static final String UCC_USERNAME_CHECK_SUCCESS_DESC = "用户名已存在";
	
	
	public static final String SUPPLEMENTDEPOSIT_GREATER_THAN_TOTAL_AMOUNT_ERROR_CODE="200137";
	public static final String SUPPLEMENTDEPOSIT_GREATER_THAN_TOTAL_AMOUNT_ERROR_DESC="需补定金金额不能大于订单总金额";
	
	public static final String OUTOF_REDEMPTION_AMOUNT_CODE="200138";
	public static final String OUTOF_REDEMPTION_AMOUNT_DESC="赎回商品金额超过了当前您可赎回的商品额度"; 
	
	public static final String REDEMPTION_AVAILABLE_QUOTA_CODE = "200139";
	public static final String REDEMPTION_AVAILABLE_QUOTA_DESC ="可用授信额度为零时，才可以进行长还";
	
	public static final String REDEMPTION_QUOTA_TIP_CODE = "200140";
	public static final String REDEMPTION_QUOTA_TIP ="您偿还的金额已超过了当前授信额度";
	
	public static final String SUPPLEMENTDEPOSIT_NULL_CODE = "200141";
	public static final String SUPPLEMENTDEPOSIT_NULL_DESC = "请先输入需补定金，再进行审批";
	
	public static final String WAREHOUSE_POSITION_CONFIG_EXIST_CODE = "200142";
	public static final String WAREHOUSE_POSITION_CONFIG_EXIST_DESC = "已存在相关设定，请至编辑页面修改";
	
	public static final String WAREHOUSE_POSITION_EXIST_CODE = "200143";
	public static final String WAREHOUSE_POSITION_EXIST_DESC = "以下仓位号已被占用，不允许添加";
	
	public static final String WAREHOUSE_POSITION_PRODUCT_EXIST_CODE = "200144";
	public static final String WAREHOUSE_POSITION_PRODUCT_EXIST_DESC = "部分仓位已有板材在库未出库，不允许删除！";
	
	public static final String WAREHOUSE_POSITION_PRODUCT_ERROR_CODE = "200145";
	public static final String WAREHOUSE_POSITION_PRODUCT_ERROR_DESC = "仓位编辑失败";
	
	public static final String CY_MOVE_FACTORY_PRODUCT_WEIGHT_ERROR_CODE = "200146";
	public static final String CY_MOVE_FACTORY_PRODUCT_WEIGHT_ERROR_DESC = "移库重量大于商品原有重量";

    public static final String ES_SYSTEM_MOVE_PRODUCT_WAREHOUSE_FAIL_CODE = "200147";
    public static final String ES_SYSTEM_MOVE_PRODUCT_WAREHOUSE_FAIL_DESC = "移库产品移入仓位和移出仓位信息不在同一公司下";
    
	public static final String MODEL_CHART_CHINA_TAIMAN_EMPTY_CODE = "200148";
	public static final String MODEL_CHART_CHINA_TAIMAN_EMPTY_DESC = "中国台湾标类型的型号不能为空";
	
	public static final String MODEL_CHART_ISEXIST_CODE = "200149";
	public static final String MODEL_CHART_ISEXIST_DESC = "已存在该商品名称及对照标，不允许重复设置";
	
	public static final String SUPPLIER_REFERENCE_IS_DELETE_CODE = "200150";
	public static final String SUPPLIER_REFERENCE_IS_DELETE_DESC = "该供应商已被删除，更新操作无法执行";
	
	public static final String FACTORY_INWAREHOUSE_PRODUCT_AMOUNT_ERROR_CODE = "200151";
	public static final String FACTORY_INWAREHOUSE_PRODUCT_AMOUNT_ERROR_DESC = "存在未设定当日价格的商品";
	
	public static final String PRODUCT_MODEL_QUOTA_BANK_NOT_EXIST_CODE = "200152";
	public static final String PRODUCT_MODEL_QUOTA_BANK_NOT_EXIST_DESC = "您选择的融资银行不支持商品型号";
	
	public static final String PRODUCT_CATEGORY_ISEXIST_CODE = "200153";
	public static final String PRODUCT_CATEGORY_ISEXIST_DESC = "商品类型已存在";
	
	public static final String PRODUCT_CATEGORY_PRODUCT_ISEXIST_CODE = "200219";
	public static final String PRODUCT_CATEGORY_PRODUCT_ISEXIST_DESC = "该商品类型关联了商品名称，不允许删除";

	public static final String PRODUCT_IN_WAREHOUSE_DEL_CODE = "200155";
	public static final String PRODUCT_IN_WAREHOUSE_DEL_DESC = "有在途的商品已经入库，不允许删除";
	
	public static final String PRODUCT_IN_WAREHOUSE_SENDCY_CODE = "200156";
	public static final String PRODUCT_IN_WAREHOUSE_SENDCY_DESC = "有在途的商品已经入库，请刷新列表后再重新选择商推送仓押";
	
	public static final String PRODUCT_ATYPISM_CODE = "200157";
	public static final String PRODUCT_ATYPISM_DESC = "数据不一致，请刷新列表后再重新选择商品进行操作";
	
	public static final String PRODUCT_PLEDGE_CODE = "200158";
	public static final String PRODUCT_PLEDGE_DESC = "商品已生成质押单，不允许修改规格型号";
	
	public static final String PRODUCT_IN_REDEMPTION_DEL_CODE = "200159";
	public static final String PRODUCT_IN_REDEMPTION_DEL_DESC = "有在途的商品已经在赎回单中，不允许删除";
	
	public static final String PRODUCT_IN_REDEMPTION_SENDCY_CODE = "200160";
	public static final String PRODUCT_IN_REDEMPTION_SENDCY_DESC = "有在途的商品已经在赎回单中，请刷新列表后再重新选择商推送仓押";
	
	public static final String SVL_PRODUCT_IN_REDEMPTION_ZERO_CODE = "200161";
	public static final String SVL_PRODUCT_IN_REDEMPTION_ZERO_DESC = "商品在数据库中已经没有可赎回的重量了";
	
	public static final String SVL_PRODUCT_IN_REDEMPTION_OVER_CODE = "200162";
	public static final String SVL_PRODUCT_IN_REDEMPTION_OVER_DESC = "商品的赎回重量已经超过了数据库中可赎回的重量";
	
	public static final String SUPPLIER_CATEGORY_ISEXIST_CODE = "200210";
	public static final String SUPPLIER_CATEGORY_ISEXIST_DESC = "供应商类别已存在";
	
	public static final String SUPPLIER_CATEGORY_IS_DELETE_CODE = "200211";
	public static final String SUPPLIER_CATEGORY_IS_DELETE_DESC = "该供应商类别已被删除，更新操作无法执行";
	
	public static final String ORDER_AMOUNT_LESS_THAN_NOTSTORAGE_AMOUNT_CODE = "200212";
	public static final String ORDER_AMOUNT_LESS_THAN_NOTSTORAGE_AMOUNT_DESC = "在途货物限额应大于等于单笔订单限额";
	
	public static final String SUPPLIER_CATEGORY_ASSOCIATION_SUPPLIER_REFERENCE_CODE = "200213";
	public static final String SUPPLIER_CATEGORY_ASSOCIATION_SUPPLIER_REFERENCE_DESC = "供应商类型关联了供应商名称，无法删除";
	
	public static final String ORDERAMOUNTLIMIT_CODE = "200214";
	public static final String ORDERAMOUNTLIMIT_DESC = "所选供应商单笔订单金额不能超过";
	
	public static final String NOTSTORAGELIMIT_CODE = "200215";
	public static final String NOTSTORAGELIMIT_DESC = "所选供应商当前在途商品已超过限额";
	
	public static final String SVL_PRODUCT_IN_DELIVERY_ZERO_CODE = "200216";
	public static final String SVL_PRODUCT_IN_DELIVERY_ZERO_DESC = "商品在数据库中已经没有可提货的重量了";
	
	public static final String SVL_PRODUCT_IN_DELIVERY_OVER_CODE = "200217";
	public static final String SVL_PRODUCT_IN_DELIVERY_OVER_DESC = "商品的提货重量已经超过了数据库中可提货的重量";
	
	public static final String SVL_PRODUCT_HAS_NOT_PLEDGE_CODE = "200218";
	public static final String SVL_PRODUCT_HAS_NOT_PLEDGE_DESC = "商品中包含了不是质押状态的在库商品";


	// 从trunk合并过来，部分code冲突了。
	public static final String FINANCINGPRODUCTTYPE_CHANGE_ERROR_CODE = "200220";
	public static final String FINANCINGPRODUCTTYPE_CHANGE_ERROR_DESC = "当前模式下有订单尚未结清贷款，无法切换";

	public static final String HAVE_NEW_PRODUCT_CODE = "200221";
	public static final String HAVE_NEW_PRODUCT_DESC = "有新到货物，请去列表页重新质押";

	public static final String UPDATE_BANK_WAREHOUSE_STATUS_FAIL_CODE = "200222";
	public static final String UPDATE_BANK_WAREHOUSE_STATUS_FAIL_DESC = "银行更新商品库存状态失败";

	public static final String BANKLOANNO_NO_HAVE_CODE = "200154";
	public static final String BANKLOANNO_NO_HAVE_DESC = "银行贷款号未指定";

	public static final String REDEMPTION_PRODUCT_EXIST_CODE = "200223";
	public static final String REDEMPTION_PRODUCT_EXIST_DESC = "赎回商品不能为空，请打回！";
	
	public static final String JYRCB_BANK_NOT_PLEDGE_CODE = "200224";
	public static final String JYRCB_BANK_NOT_PLEDGE_DESC = "银行不允许解押！";
	
	public static final String JYRCB_BANK_EDIT_CONTRACT_ERROR_CODE = "200225";
	public static final String JYRCB_BANK_EDIT_CONTRACT_ERROR_DESC = "江阴银行必须缴纳定金后，才能编辑合同！";
	
	public static final String SVL_INTRAINST_PRODUCT_NO_REPEAT_CODE = "200226";
	public static final String SVL_INTRAINST_PRODUCT_NO_REPEAT_DESC = "卷号重复！";
	public static final String SVL_INTRAINST_PRODUCT_TO_CY_FAIL_DESC = "推送仓押失败！";
	
	public static final String CHECK_CATEGORY_ATYPISM_CODE = "200227";
	public static final String CHECK_CATEGORY_ATYPISM_DESC = "excel中的商品类型与选择的类型不一致!";
	
	public static final String CHECK_JYRCB_NOT_REDEMPTION_CODE = "200228";
	public static final String CHECK_JYRCB_NOT_REDEMPTION_DESC = "赎回商品中有不能赎回的，请刷新列表后重新选择!";
	
	public static final String PRODUCT_HAS_SEND_CY_NOT_DEL_CODE = "200229";
	public static final String PRODUCT_HAS_SEND_CY_NOT_DEL_DESC = "有在途商品已经推送仓押，不允许删除";
	
	public static final String PRODUCT_RECONCILIATION_FILE_CODE = "200230";
	public static final String PRODUCT_RECONCILIATION_FILE_DESC = "货物对账文件已存在";
	
	public static final String ORDER_RECONCILIATION_FILE_CODE = "200231";
	public static final String ORDER_RECONCILIATION_FILE_DESC = "订单对账文件已存在";
	
	public static final String CHECK_EXCEL_PRICE_CODE = "200241";
	public static final String CHECK_EXCEL_PRICE_DESC = "价格文件列数不正确";
	
	public static final String CHECK_EXCEL_PRICE_POINT_CODE = "200242";
	public static final String CHECK_EXCEL_PRICE_POINT_DESC = "上传文件中当日价格必须为最多2位小数的数字！";
	
	public static final String CHECK_EXCEL_PRICE_DISTINCT_CODE = "200243";
	public static final String CHECK_EXCEL_PRICE_DISTINCT_DESC = "上传文件中存在重复的型号+规格，不允许导入！";
	
	public static final String CHECK_FACTORY_UNITPRICE_CODE = "200244";
	public static final String CHECK_FACTORY_UNITPRICE_DESC = "价格规则重复，不允许新增！";
	
	public static final String CHECK_EXCEL_PRODUCT_NAME_NOT_EMPTY_CODE = "200245";
	public static final String CHECK_EXCEL_PRODUCT_NAME_NOT_EMPTY_DESC = "产品名称不得为空";
	
	public static final String CHECK_EXCEL_MODEL_CODE = "200246";
	public static final String CHECK_EXCEL_MODEL_DESC = "上传文件型号不能为空";
	
	public static final String CHECK_EXCEL_SPECIFICATION_CODE = "200247";
	public static final String CHECK_EXCEL_SPECIFICATION_DESC = "上传文件规格不能为空";
	
	public static final String SVL_INTRAINST_STATUS_CODE = "200248";
	public static final String SVL_INTRAINST_STATUS_DESC = "有在途的商品处于质押、申请解押或解押状态，不允许修改！";
	
	public static final String SVL_INTRAINST_STATUS_DELETE_CODE = "200249";
	public static final String SVL_INTRAINST_STATUS_DELETE_DESC = "有在途的商品处于质押、申请解押或解押状态，不允许删除";
	
	public static final String PRODUCT_STOCK_DOUBLE_CODE = "200250";
	public static final String PRODUCT_STOCK_DOUBLE_DESC = "同一流水号重复入库";
	
	public static final String SVL_OUT_WEIGHT_CODE = "200251";
	public static final String SVL_OUT_WEIGHT_DESC = "出库重量不足";
	
	public static final String SVL_OUT_PRODUCT_CODE = "200252";
	public static final String SVL_OUT_PRODUCT_DESC = "货物不存在";
	
	public static final String PRODUCT_OUT_DOUBLE_CODE = "200253";
	public static final String PRODUCT_OUT_DOUBLE_DESC = "同一流水号重复出库";
	
	public static final String PRODUCT_MOVE_DOUBLE_CODE = "200254";
	public static final String PRODUCT_MOVE_DOUBLE_DESC = "重复移库";
	
	public static final String CHECK_REDEMPTION_NO_NULL_CODE="200256";
	public static final String CHECK_REDEMPTION_NO_NULL_DESC="出库单号不能为空！";
	
	public static final String CHECK_PRODUCT_EXIST_CODE="200257";
	public static final String CHECK_PRODUCT_EXIST_DESC="商品未提货，不能出库";
	
	public static final String CHECK_REDEMPTION_PRODUCT_EXIST_CODE="200258";
	public static final String CHECK_REDEMPTION_PRODUCT_EXIST_DESC="出库单下没有该商品，不能出库";
	
	public static final String CHECK_SET_LOCATIONNO_EXIST_CODE="200259";
	public static final String CHECK_SET_LOCATIONNO_EXIST_DESC="仓库仓位号为设置存库质押模式！";
	
	public static final String PRODUCT_MOVE_WEIGHT_CODE = "200260";
	public static final String PRODUCT_MOVE_WEIGHT_DESC = "移库重量不足";
	
	public static final String TRANSIT_PRODUCT_ID_NOT_EMPTY_CODE = "200261";
	public static final String TRANSIT_PRODUCT_ID_NOT_EMPTY_DESC = "在途商品ID不得为空！";
	
	public static final String TRANSIT_PURCHASE_PRODUCT_ID_NOT_EMPTY_CODE = "200262";
	public static final String TRANSIT_PURCHASE_PRODUCT_ID_NOT_EMPTY_DESC = "在途商品purchaseProductId不得为空！";
	
	public static final String TRANSIT_PRODUCT_ID_NOT_EXIST_CODE = "200263";
	public static final String TRANSIT_PRODUCT_ID_NOT_EXIST_DESC = "在途商品ID不存在：";
	
	public static final String PURCHASE_PRODUCT_ID_NOT_EXIST_CODE = "200264";
	public static final String PURCHASE_PRODUCT_ID_NOT_EXIST_DESC = "商品表 jf_purchase_product 数据异常, 不存在主键id : ";
	
	public static final String TRANSIT_PRODUCT_LIST_NOT_EMPTY_CODE = "200265";
	public static final String TRANSIT_PRODUCT_LIST_NOT_EMPTY_DESC = "在途商品列表不得为空";
	
	public static final String SALE_CONTRACT_NO_NOT_EMPTY_CODE = "200266";
	public static final String SALE_CONTRACT_NO_NOT_EMPTY_DESC = "销售合同号不得为空";
	
	public static final String PRODUCT_ALREADY_INWAREHOUSE_CODE = "200267";
	public static final String PRODUCT_ALREADY_INWAREHOUSE_DESC = "该在途商品已推送过入库，不允许删除";
	
	public static final String SVL_INTRAINST_PRODUCT_STOCK_OUT_CODE = "200268";
	public static final String SVL_INTRAINST_PRODUCT_STOCK_OUT_DESC = "存在于已经出库的商品中不能再使用！";
	
	public static final String SVL_DATE_NOT_EXIST_CODE = "200269";
	public static final String SVL_DATE_NOT_EXIST_DESC = "数据已被删除！";
	
	public static final String LOAN_CONTRACT_ID_NOT_EMPTY_CODE = "200270";
	public static final String LOAN_CONTRACT_ID_NOT_EMPTY_DESC = "贷款合同ID不得为空！";
	
	public static final String LOAN_CONTRACT_ID_NOT_EXIST_CODE = "200272";
	public static final String LOAN_CONTRACT_ID_NOT_EXIST_DESC = "贷款合同ID不存在  ";
	
	public static final String LOAN_CONTRACT_ALRAEDY_FINISHED_CODE = "200273";
	public static final String LOAN_CONTRACT_ALRAEDY_FINISHED_DESC = "贷款合同已结清,不允许操作：  ";
	
	public static final String LOAN_CONTRACT_PLEDGE_RATE_NOT_EMPTY_CODE = "200274";
	public static final String LOAN_CONTRACT_PLEDGE_RATE_NOT_EMPTY_DESC = "贷款合同质押率不得为空！";
	
	public static final String LOAN_CONTRACT_SUPERVISON_RATE_NOT_EMPTY_CODE = "200275";
	public static final String LOAN_CONTRACT_SUPERVISON_RATE_NOT_EMPTY_DESC = "贷款合同监管费率不得为空！";
	
	public static final String LOAN_CONTRACT_PLEDGE_RATE_NOT_CORRECT_CODE = "200276";
	public static final String LOAN_CONTRACT_PLEDGE_RATE_NOT_CORRECT_DESC = "贷款合同质押率必须 大于等于0 或者小于 100 ！";
	
	public static final String LOAN_CONTRACT_SUPERVISON_RATE_NOT_CORRECT_CODE = "200277";
	public static final String LOAN_CONTRACT_SUPERVISON_RATE_NOT_CORRECT_DESC = "贷款合同监管费率必须 大于等于0 或者小于 100 ！";
	
	public static final String LOAN_CONTRACT_DUEBILLNO_NOT_EMPTY_CODE = "200278";
	public static final String LOAN_CONTRACT_DUEBILLNO_NOT_EMPTY_DESC = "贷款合同号不得为空！";
	
	public static final String LOAN_CONTRACT_NOT_EXIST_CODE = "200279";
	public static final String LOAN_CONTRACT_NOT_EXIST_DESC = "贷款合同号不存在：  ";
	
	public static final String LOAN_CONTRACT_PLEDGEAMOUNT_NOT_ZERO = "200280";
	
	public static final String WAREHOUSE_POSITION_NOT_EXIST_CODE = "200281";
	public static final String WAREHOUSE_POSITION_NOT_EXIST_DESC = "仓押未同步仓位信息";
	
	public static final String DUEBILLNO_SALECONTRACTNO_NOT_EMPTY_CODE = "200282";
	public static final String DUEBILLNO_SALECONTRACTNO_NOT_EMPTY_DESC = "销售合同号和贷款合同号不得同时为空！";
	
	public static final String REDEMPTIONNO_NOT_EMPTY_CODE = "200283";
	public static final String REDEMPTIONNO_NOT_EMPTY_DESC = "赎回单号不得为空！";
	
	public static final String REDEMPTION_ORDER_NOT_EXIST_CODE = "200283";
	public static final String REDEMPTION_ORDER_NOT_EXIST_DESC = "赎回单号不存在 ";
	
	public static final String CHECK_SVL_PLEDGE_CODE = "200284";
	public static final String CHECK_SVL_PLEDGE_DESC = "请核对合同项下监管货物全部入库后，确认发送质押明细给江苏银行";
	
	public static final String PRODUCT_NAME_NOT_EMPTY_CODE = "200285";
	public static final String PRODUCT_NAME_NOT_EMPTY_DESC = "商品名称不得为空！";
	
	public static final String PRODUCT_MODEL_NOT_EMPTY_CODE = "200286";
	public static final String PRODUCT_MODEL_NOT_EMPTY_DESC = "商品型号不得为空！";
	
	public static final String PRODUCT_NAME_NOT_EXIST_CODE = "200286";
	public static final String PRODUCT_NAME_NOT_EXIST_DESC = "商品名称不存在！";
	
	public static final String PRODUCT_MODEL_NOT_EXIST_CODE = "200287";
	public static final String PRODUCT_MODEL_NOT_EXIST_DESC = "商品型号不存在！";

	public static final String PRODUCT_NAME_MODEL_EXIST_CODE = "200288";
	public static final String PRODUCT_NAME_MODEL_EXIST_DESC = "该商品名称与商品型号的控制关系已存在！";
	
	public static final String AVAILABLE_QUOTA_NOT_CORRECT_CODE = "200289";
	public static final String AVAILABLE_QUOTA_NOT_CORRECT_DESC = "月总量额度必须是大于0";
	
	public static final String PRODUCT_NAME_MODEL_NOT_EXIST_CODE = "200290";
	public static final String PRODUCT_NAME_MODEL_NOT_EXIST_DESC = "该商品名称与商品型号的控制关系不存在！";
	
	public static final String PRODUCT_MODEL_NEW_NOT_EMPTY_CODE = "200291";
	public static final String PRODUCT_MODEL_NEW_NOT_EMPTY_DESC = "修改后的商品型号不得为空！";
	
	public static final String PRODUCT_MODEL_NEW_NOT_EXIST_CODE = "200292";
	public static final String PRODUCT_MODEL_NEW_NOT_EXIST_DESC = "修改后的商品型号不存在！";
	
	public static final String OPERATE_TYPE_NOT_NULL_CODE = "200293";
	public static final String OPERATE_TYPE_NOT_NULL_DESC = "操作类型不得为空！";
	
	public static final String PRODUCT_MODEL_QUOTA_NEW_NOT_EXIST_CODE = "200294";
	public static final String PRODUCT_MODEL_QUOTA_NEW_NOT_EXIST_DESC = "修改后的商品型号对应的额度记录不存在！";
	
	public static final String REPAY_ID_NOT_NULL_CODE = "200295";
	public static final String REPAY_ID_NOT_NULL_DESC = "还款记录ID不得为空！";
	
	public static final String REPAY_ID_NOT_EXIST_CODE = "200296";
	public static final String REPAY_ID_NOT_EXIST_DESC = "还款记录ID不存在！";
	
	public static final String SUPFEE_PAYMENT_NUMBER_NOT_EMPTY_CODE = "200297";
	public static final String SUPFEE_PAYMENT_NUMBER_NOT_EMPTY_DESC = "监管费付款流水号不得为空！";
	
	public static final String SUPFEE_FILE_NAME_NOT_EMPTY_CODE = "200298";
	public static final String SUPFEE_FILE_NAME_NOT_EMPTY_DESC = "监管费付款回单文件名称不得为空！";
	
	public static final String SUPFEE_FILE_URL_NOT_EMPTY_CODE = "200299";
	public static final String SUPFEE_FILE_URL_NOT_EMPTY_DESC = "监管费付款回单文件名称不得为空！";
	
	public static final String SUPFEE_FILE_URL_NOT_EXIST_CODE = "200300";
	public static final String SUPFEE_FILE_URL_NOT_EXIST_DESC = "监管费付款回单文件不存在！";
	
	public static final String SUPFEE_ALREADY_CONFIRMED_CODE = "200301";
	public static final String SUPFEE_ALREADY_CONFIRMED_DESC = "监管费状态已确认，不允许再操作！";
	
	public static final String SUPFEE_PAYMENT_NUMBER_EXIST_CODE = "200302";
	public static final String SUPFEE_PAYMENT_NUMBER_EXIST_DESC = "监管费付款流水号已存在，不得重复！";
	
	public static final String LOAN_HAS_NO_PAYMENT_FEE_CODE = "200303";
	public static final String LOAN_HAS_NO_PAYMENT_FEE_DESC = "存在未确认监管费的还款记录，请确认后点击此按钮";

	public static final String LOAN_CONTRACT_DUEBILLNO_IS_EXIST_CODE = "200304";
	public static final String LOAN_CONTRACT_DUEBILLNO_IS_EXIST_DESC = "贷款合同号已存在,请重新输入！";

	public static final String BANK_AVAILABLEQUOTA_ERROR_CODE="200305";
	public static final String BANK_AVAILABLEQUOTA_ERROR_DESC="贷款金额不能超过银行的可用授信额度！";
	
	public static final String IDENTITI_FLAG_ERROR_CODE="200307";
	public static final String IDENTITI_FLAG_ERROR_DESC="一张融资申请不能即包含有唯一标识的商品又包含没有唯一标识的商品！";

	public static final String FACTORY_PRODUCT_SUPERVISION_ERROR_CODE="200306";
	public static final String FACTORY_PRODUCT_SUPERVISION_ERROR_DESC="该贷款合同下，此商品名称的设定维度与现有的维度不一致！";
	
	public static final String PRODUCT_USE_MODIFY_IDENTITY_ERROR_CODE="200308";
	public static final String PRODUCT_USE_MODIFY_IDENTITY_ERROR_DESC="商品【商品名称={}】已被融资申请单【单号={}】使用,不允许修改【是否有唯一标识】";

	public static final String REDEMPTION_PRODUCT_NOT_EMPTY_CODE="200309";
	public static final String REDEMPTION_PRODUCT_NOT_EMPTY_DESC="赎回商品列表不得为空！";
	
	public static final String BLACK_LIST_COMPANY_EXIST_ERROR_CODE="200310";
	public static final String BLACK_LIST_COMPANY_EXIST_ERROR_DESC="该公司已在客户黑名单中，不允许重复添加！";
	
	public static final String BLACK_LIST_SUPPLIER_EXIST_ERROR_CODE="200311";
	public static final String BLACK_LIST_SUPPLIER_EXIST_ERROR_DESC="该公司已在供应商黑名单中，不允许重复添加！";
	
	public static final String BLACK_LIST_CUSTOMER_ERROR_CODE="200312";
	public static final String BLACK_LIST_CUSTOMER_ERROR_DESC="该订单融资客户为黑名单客户，不允许审核通过!";
	
	public static final String BLACK_LIST_SUPPLIER_ERROR_CODE="200313";
	public static final String BLACK_LIST_SUPPLIER_ERROR_DESC="该订单所选供应商为黑名单供应商，不允许审核通过!";
	
	public static final String ES_SYSTEM_OUT_PRODUCT_NOT_FAIL_CODE = "200313";
	public static final String ES_SYSTEM_OUT_PRODUCT_NOT_FAIL_DESC = "出库产品不存在！";
	
	public static final String PUSH_WEEIGHT_RISK_TO_CY_ERROR_CODE = "200314";
	public static final String PUSH_WEEIGHT_RISK_TO_CY_ERROR_DESC = "无风险货物重量，推送仓押失败!";

	public static final String INSERT_LOAN_CONTRACT_TO_CY_SUCCESS_DESC = "新增存货质押贷款合同成功";

	public static final String LOAN_CONTRACT_TO_CY_ERROR_CODE = "200315";
	public static final String LOAN_CONTRACT_TO_CY_ERROR_DESC = "仓押系统返回错误:";

	public static final String UPD_FACTORY_PRODUCT_ERROR_CODE = "200316";
	public static final String UPD_FACTORY_PRODUCT_ERROR_DESC = "更新存货质押表失败!";

	public static final String SET_PRICE_MODEL_MISMATCH_CODE = "200317";
	public static final String SET_PRICE_MODEL_MISMATCH_DESC = "设置价格的参数设置和定价方式中的参数类型不匹配!";

	public static final String HAS_IDENTITY_PRODUCT_NO_ERROR_CODE = "200318";
	public static final String HAS_IDENTITY_PRODUCT_NO_ERROR_DESC = "所选供应商也是融资客户，有唯一标识的商品必须输入卷号!";
	
	public static final String RELATED_PRODUCT_WEIGHT_LESS_CODE = "200319";
	public static final String RELATED_PRODUCT_WEIGHT_LESS_DESC = "关联的货物重量大于数据库中的重量!";
	
	public static final String INSERT_FACTORY_PRODUCT_ERROR_CODE = "200320";
	public static final String INSERT_FACTORY_PRODUCT_ERROR_DESC = "插入存货质押表失败!";
	
	public static final String PRODUCT_NO_EXIST_ERROR_CODE = "200321";
	public static final String PRODUCT_NO_EXIST_ERROR_DESC = "卷号已存在，不允许重复!";
	
	public static final String LOAN_CHANNEL_NOT_EMPTY_CODE = "200322";
	public static final String LOAN_CHANNEL_NOT_EMPTY_DESC = "放款渠道不得为空!";
	
	public static final String PRICE_MODEL_EXIST_ERROR_CODE = "200323";
	public static final String PRICE_MODEL_EXIST_ERROR_DESC = "设定的价格数据已经存在!";
	
	public static final String FINANCE_RATIO_EXCEED_ERROR_CODE = "200324";
	public static final String FINANCE_RATIO_EXCEED_ERROR_DESC = "输入的融资比例不允许高于最高融资比例，最高融资比例为：";

	public static final String CHECK_ORDER_LOAN_AVALIABLE_ENOUGH_CODE="200325";
	public static final String CHECK_ORDER_LOAN_AVALIABLE_ENOUGH_DESC="额度不足，不允许提交申请";
	
	public static final String DEPOSIT_LESS_THEN_MINDEPOSIT_ERROR_CODE = "200326";
	public static final String DEPOSIT_LESS_THEN_MINDEPOSIT_ERROR_DESC = "所输入的定金金额低于融资申请的最低定金金额，请重新输入定金金额!";
	
	public static final String CHECK_ORDER_APPROVE_AVALIABLE_ENOUGH_CODE="200327";
	public static final String CHECK_ORDER_APPROVE_AVALIABLE_ENOUGH_DESC="额度不足，不允许提交审核通过";
	
	public static final String CHECK_ORDER_LOAN_AVALIABLE_LOCK_ENOUGH_CODE="200328";
	public static final String CHECK_ORDER_LOAN_AVALIABLE_LOCK_ENOUGH_DESC="存在{}元锁定额度，不允许再次申请";

	public static final String CHECK_PRODUCT_NO_USER_COMMON_SUPPLIER_CODE="200329";
	public static final String CHECK_PRODUCT_NO_USER_COMMON_SUPPLIER_DESC="供应商也是融资客户时，必须录入捆包号";

	public static final String CHECK_PRODUCT_NO_USED_USER_COMMON_SUPPLIER_CODE="200330";
	public static final String CHECK_PRODUCT_NO_USED_USER_COMMON_SUPPLIER_DESC="捆包号{}重复质押，不允许审批通过";
	
	public static final String CHECK_INTRANSIT_PRODUCT_EMPTY_CODE="200331";
	public static final String CHECK_INTRANSIT_PRODUCT_EMPTY_DESC="在途导入商品，没有商品信息";
	
	public static final String MEASUREMENT_UNIT_NOT_NULL_CODE = "200332";
	public static final String MEASUREMENT_UNIT_NOT_NULL_DESC = "计量单位不得为空";
	
	public static final String MEASUREMENT_UNIT_NAME_NOT_EMPTY_CODE = "200333";
	public static final String MEASUREMENT_UNIT_NAME_NOT_EMPTY_DESC = "计量单位名称不得为空";
	
	public static final String MEASUREMENT_UNIT_LENGTH_TOO_LONG_CODE = "200334";
	public static final String MEASUREMENT_UNIT_LENGTH_TOO_LONG_DESC = "计量单位名称最大长度为8个字符";
	
	public static final String MEASUREMENT_UNIT_ID_NOT_NULL_CODE = "200335";
	public static final String MEASUREMENT_UNIT_ID_NOT_NULL_DESC = "计量单位ID不得为空";
	
	public static final String MEASUREMENT_UNIT_NAME_EXIST_CODE = "200336";
	public static final String MEASUREMENT_UNIT_NAME_EXIST_DESC = "计量单位名称已存在";
	
	public static final String MEASUREMENT_UNIT_NOT_EXIST_CODE = "200337";
	public static final String MEASUREMENT_UNIT_NOT_EXIST_DESC = "计量单位名称不存在";
	
	public static final String MEASUREMENT_UNIT_REMARK_LENGTH_TOO_LONG_CODE = "200338";
	public static final String MEASUREMENT_UNIT_REMARK_LENGTH_TOO_LONG_DESC = "计量单位备注最大长度为255个字符";
	
	public static final String MEASUREMENT_UNIT_NAME_CONTAINS_SPACE_CODE = "200339";
	public static final String MEASUREMENT_UNIT_NAME_CONTAINS_SPACE_DESC = "计量单位备名称不允许包含空格";
	
	public static final String MEASUREMENT_UNIT_NAME_ALREADY_USED_CODE = "200340";
	public static final String MEASUREMENT_UNIT_NAME_ALREADY_USED_DESC = "该计量单位已有商品使用，不允许删除";
	
	public static final String ORDER_STATUS_NOT_CAIWU_CONFIRM_ERROR_CODE="200341";
	public static final String ORDER_STATUS_NOT_CAIWU_CONFIRM_ERROR_DESC="订单状态不是财务确认状态！";
	
	public static final String CHECK_ORDER_STATUS_CODE="200342";
	public static final String CHECK_ORDER_STATUS_DESC="订单已审核通过，不允许修改销售合同信息";
	
	public static final String CHECK_CONTRACT_MUST_INFO_CODE="200343";
	public static final String CHECK_CONTRACT_MUST_INFO_DESC="销售合同必输项未填，不允许保存";
	
	public static final String CHECK_PARTYA_PURCHASE_AGENT_IS_NOT_CODE="200344";
	public static final String CHECK_PARTYA_PURCHASE_AGENT_IS_NOT_DESC="若是否代采标识为否，采购方默认为融资客户，不允许修改";
	
	public static final String CHECK_PARTYA_WSN_AGENT_IS_NOT_CODE="200345";
	public static final String CHECK_PARTYA_WSN_AGENT_IS_NOT_DESC="若是否代采标识为是，且是否感知代采标识为否，采购方名称应为代采商信息";
	
	public static final String CHECK_PARTYA_WSN_AGENT_IS_YES_CODE="200346";
	public static final String CHECK_PARTYA_WSN_AGENT_IS_YES_DESC="若是否代采标识为是，且是否感知代采标识为是，采购方默认为无锡感知金服物联网科技有限公司";

	public static final String CHECK_PARTYA_WSN_AGENT_IS_NOT_QUOTA_CODE="200347";
	public static final String CHECK_PARTYA_WSN_AGENT_IS_NOT_QUOTA_DESC="代采商代采余额{}大于代采商限额{}，请核对后提交";
	
	public static final String CHECK_IS_WSN_AGENT_ERROE_CODE="200348";
	public static final String CHECK_IS_WSN_AGENT_ERROE_DESC="若是否代采标识为否，是否感知代采标识默认为否，不允许修改";
	
	public static final String CHECK_HAS_DIFFERENT_IDENTITY_CODE="200349";
	public static final String CHECK_HAS_DIFFERENT_IDENTITY_DESC="不允许同时存在是否有唯一标识为是和否的商品，{}是否有唯一标识为是，{}是否有唯一标识为否！";

	public static final String CHECK_LESS_MIN_DEPOSIT_CODE="200350";
	public static final String CHECK_LESS_MIN_DEPOSIT_DESC="客户缴纳的保证金{}低于最低保证金{}，不允许通过";

	public static final String CHECK_AGENT_PURCHASER_NOT_EXIST_CODE="200351";
	public static final String CHECK_AGENT_PURCHASER_NOT_EXIST_DESC="代采商{}不存在";
	
	public static final String CHECK_MEASUREMENT_NULL_CODE = "200352";
	public static final String CHECK_MEASUREMENT_NULL_DESC = "货物计量不能为空";
	
	public static final String CHECK_MEASUREMENT_ZERO_ERROR_CODE = "200353";
	public static final String CHECK_MEASUREMENT_ZERO_ERROR_DESC = "货物计量必须大于零";
	
	public static final String CHECK_MEASUREMENT_ERROR_CODE = "200354";
	public static final String CHECK_MEASUREMENT_ERROR_DESC = "货物计量输入不正确";
	
	public static final String PRODUCT_NAME_NO_RELATION_MEASUREMENT_UNIT_CODE = "200355";
	public static final String PRODUCT_NAME_NO_RELATION_MEASUREMENT_UNIT_DESC = "商品productName={},没有关联计量单位!";
	
	public static final String PRODUCT_NAME_RELATION_MORE_MEASUREMENT_UNIT_CODE = "200356";
	public static final String PRODUCT_NAME_RELATION_MORE_MEASUREMENT_UNIT_DESC = "商品productName={},关联了多个计量单位!";

	public static final String CHECK_USER_QUOTA_NOT_ENOUGH_CODE="200357";
	public static final String CHECK_USER_QUOTA_NOT_ENOUGH_DESC="客户授信额度{}不足，不允许通过";
	
	public static final String CHECK_NOT_SVL_NOT_HAS_IDENTITY_CODE="200358";
	public static final String CHECK_NOT_SVL_NOT_HAS_IDENTITY_DESC="非黑材类商品，不允许存在唯一标识是否的商品";
	
	public static final String CHECK_BANK_SVL_NOT_HAS_IDENTITY_CODE="200359";
	public static final String CHECK_BANK_SVL_NOT_HAS_IDENTITY_DESC="融资渠道{}不允许存在是否有唯一标识为否的商品{}";

	public static final String CHECK_COMMON_PRODUCT_NO_COMMON_ORDER_CODE="200360";
	public static final String CHECK_COMMON_PRODUCT_NO_COMMON_ORDER_DESC="捆包号{}重复，不允许通过";

	public static final String PRTYA_HF_CODE="200361";
	public static final String PRTYA_HF_DESC="是否感知代采为：是，融资渠道为：感知惠风金服，采购方设置为：苏州感知惠风供应链管理有限公司";
	
	public static final String PRTYA_NOT_HF_CODE="200362";
	public static final String PRTYA_NOT_HF_DESC="是否感知代采为：是，融资渠道不为：感知惠风金服，采购方设置由前端决定默认值";
	
	public static final String BANK_PLEDGE_NOT_SUPPORT_CODE = "200363";
	public static final String BANK_PLEDGE_NOT_SUPPORT_DESC = "该融资渠道不支持质押操作！";
	
	public static final String PLEDGE_PRODUCT_NOT_FOUND_CODE = "200364";
	public static final String PLEDGE_PRODUCT_NOT_FOUND_DESC = "未找到改质押单下的押品，不允许质押！";
	
	public static final String PLEDGE_STATUS_NOT_ALLOWED_CODE = "200365";
	public static final String PLEDGE_STATUS_NOT_ALLOWED_DESC = "存在质押状态为非申请质押的商品，不允许质押!";
	
	public static final String EXISTING_RELEASE_PLEDGE_APPLY_PRODUCT_CODE = "200366";
	public static final String EXISTING_RELEASE_PLEDGE_APPLY_PRODUCT_DESC = "当前合同下存在申请解押的商品，不允许质押!";
	
	public static final String REPAYDAT_EAR_LOADAT_CODE = "200367";
	public static final String REPAYDAT_EAR_LOADAT_DESC = "还款日期{}早于放款日期{}，不允许提交!";
	
	public static final String REPAYDAT_LATER_CURDAT_CODE = "200368";
	public static final String REPAYDAT_LATER_CURDAT_DESC = "还款日期{}晚于当前日期{},不允许提交!";
	
	public static final String REPAYPRIN_GT_PRINAMT_CODE = "200369";
	public static final String REPAYPRIN_GT_PRINAMT_DESC = "还款本金{}大于贷款余额{}，不允许提交!";
	
	public static final String REPAYPRIN_WRONG_CODE = "200370";
	public static final String REPAYPRIN_WRONG_DESC = "还款本金{}不合法，不允许提交!";
	
	public static final String CG_CONTRACT_REPEAT_ERROR_CODE="200371";
	public static final String CG_CONTRACT_REPEAT_ERROR_DESC="采购合同{}在该融资申请单中已存在，不可重复添加";
	
	public static final String CG_CONTRACT_STATUS_YES_SETTLE_CODE="200372";
	public static final String CG_CONTRACT_STATUS_YES_SETTLE_DESC="采购合同{}已结清，请检查";
	
	public static final String CG_CONTRACT_SUPPLIER_NAME_NOT_EQUALS_CODE="200373";
	public static final String CG_CONTRACT_SUPPLIER_NAME_NOT_EQUALS_DESC="系统已存在采购合同{}的供应商{}和当前合同供应商{}不一致，请确认";
	
	public static final String CG_CONTRACT_PARTYA_NOT_EQUALS_CODE="200374";
	public static final String CG_CONTRACT_PARTYA_NOT_EQUALS_DESC="系统已存在采购合同{}的采购方{}和当前合同采购方{}不一致，请确认";
	
	public static final String CG_CONTRACT_IS_PURCHASE_AGENT_NOT_EQUALS_CODE="200375";
	public static final String CG_CONTRACT_IS_PURCHASE_AGENT_NOT_EQUALS_DESC="系统已存在采购合同{}的是否代采{}和当前合同是否代采{}不一致，请确认";
	
	public static final String CG_CONTRACT_IS_WSN_AGENT_NOT_EQUALS_CODE="200376";
	public static final String CG_CONTRACT_IS_WSN_AGENT_NOT_EQUALS_DESC="系统已存在采购合同{}的是否感知代采{}和当前合同是否感知代采{}不一致，请确认";

	public static final String CG_CONTRACT_NOT_PRODUCT_INFO_CODE="200377";
	public static final String CG_CONTRACT_NOT_PRODUCT_INFO_DESC="请关联采购合同商品";
	
	public static final String CG_CONTRACT_NOT_EQUALS_PRODUCT_INFO_CODE="200378";
	public static final String CG_CONTRACT_NOT_EQUALS_PRODUCT_INFO_DESC="采购商品明细金额{}和采购合同金额{}不一致，请调整后提交";
	
	public static final String CG_CONTRACT_PRODUCT_WILL_SEQ_REPEAT_CODE="200379";
	public static final String CG_CONTRACT_PRODUCT_WILL_SEQ_REPEAT_DESC="意向商品序号{}的商品已关联采购合同{},请调整后提交";
	
	public static final String CG_CONTRACT_PRODUCT_AMOUNT_MORE_CODE="200380";
	public static final String CG_CONTRACT_PRODUCT_AMOUNT_MORE_DESC="销售合同号{}意向商品序号{}关联采购合同的货物计量{}吨，已超过原有意向商品的货物计量{}吨，请调整后提交";

	public static final String CG_CONTRACT_NOT_FILE_INFO_CODE="200381";
	public static final String CG_CONTRACT_NOT_FILE_INFO_DESC="请上传采购合同文件";
	
	public static final String CG_CONTRACT_AMOUNT_NOT_EQUALS_CODE="200382";
	public static final String CG_CONTRACT_AMOUNT_NOT_EQUALS_DESC="销售合同总金额{}和采购合同总金额{}不一致，不允许通过";
	
	public static final String REPEAT_REQUEST_CODE = "200383";
	public static final String REPEAT_REQUEST_DESC = "不得发送重复请求，请稍后再试！";
	
	public static final String NO_USER_ACOUNT_CODE = "200384";
	public static final String NO_USER_ACOUNT_DESC = "未获取到用户信息！";
	
	public static final String WAREHOUSE_STATUS_NOT_CORRECT_CODE = "200385";
	public static final String WAREHOUSE_STATUS_NOT_CORRECT_DESC = "部分商品的在库状态为出库或申请出库，请检查是否在其他提货单中已存在！";
	
	public static final String USER_ACCOUNT_EMPTY_CODE = "200386";
	public static final String USER_ACCOUNT_EMPTY_DESC = "用户账号不得为空！";
	
	public static final String PRODUCT_LIST_EMPTY_CODE = "200386";
	public static final String PRODUCT_LIST_EMPTY_DESC = "提货商品列表不得为空！";
	
	public static final String DELIVERY_ORDER_EMPTY_CODE = "200387";
	public static final String DELIVERY_ORDER_EMPTY_DESC = "提货单不得为空！";
	
	public static final String DELIVERY_TYPE_EMPTY_CODE = "200388";
	public static final String DELIVERY_TYPE_EMPTY_DESC = "提货商品状态不得为空！";
	
	public static final String DELIVERY_DATE_EMPTY_CODE = "200389";
	public static final String DELIVERY_DATE_EMPTY_DESC = "提货日期不得为空！";
	
	public static final String DELIVERY_WAREHOUSE_ADDRESS_EMPTY_CODE = "200389";
	public static final String DELIVERY_WAREHOUSE_ADDRESS_EMPTY_DESC = "派送仓库地址不得为空！";
	
	public static final String DELIVERY_WAREHOUSE_NAME_EMPTY_CODE = "200390";
	public static final String DELIVERY_WAREHOUSE_NAME_EMPTY_DESC = "派送仓库名称不得为空！";
	
	public static final String DELIVERY_PERSON_EMPTY_CODE = "200391";
	public static final String DELIVERY_PERSON_EMPTY_DESC = "提货人列表不得为空！";
	
	public static final String DELIVERY_PERSON_NAME_EMPTY_CODE = "200392";
	public static final String DELIVERY_PERSON_NAME_EMPTY_DESC = "联系人不得为空！";
	
	public static final String DELIVERY_PERSON_CONTACT_NUMBER_EMPTY_CODE = "200393";
	public static final String DELIVERY_PERSON_CONTACT_NUMBER_EMPTY_DESC = "手机号码不得为空！";
	
	public static final String DELIVERY_PERSON_IDENTITY_NO_EMPTY_CODE = "200394";
	public static final String DELIVERY_PERSON_IDENTITY_NO_EMPTY_DESC = "身份证号不得为空！";
	
	public static final String DELIVERY_PERSON_LICENSE_PLATENUMBER_EMPTY_CODE = "200395";
	public static final String DELIVERY_PERSON_LICENSE_PLATENUMBER_EMPTY_DESC = "车牌信息不得为空！";
	
	public static final String EXPECTED_ARRIVAL_DATE_EMPTY_CODE = "200396";
	public static final String EXPECTED_ARRIVAL_DATE_EMPTY_DESC = "期望到货日期不得为空！";
	
	public static final String SUPPLIER_DEFAULT_RATE_YEAR_EMPTY_CODE = "200397";
	public static final String SUPPLIER_DEFAULT_RATE_YEAR_EMPTY_DESC = "查询年份不得为空！";
	
	public static final String CHECK_PRODUCT_REPEAT_FLAG_CODE = "200398";
	public static final String CHECK_PRODUCT_REPEAT_FLAG_DESC = "商品编号{}重复购买，请确认是否审核通过";

	public static final String MANAGE_ACCOUNT_NOT_ENOUGH_CODE = "200399";
	public static final String MANAGE_ACCOUNT_NOT_ENOUGH_DESC = "账户余额不足，无法扣减，请确认后再操作！";
	
    public static final String MANAGE_ACCOUNT_UPDATE_FAIL_CODE = "200400";
    /**更新版本错误 ，更新失败*/
    public static final String MANAGE_ACCOUNT_UPDATE_FAIL_DESC = "管理账户信息变更，请稍后再试！";
}


