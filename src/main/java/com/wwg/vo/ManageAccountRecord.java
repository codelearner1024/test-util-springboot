package com.wwg.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author wuwei
 * 管理账户操作流水表
 */
public class ManageAccountRecord extends BaseModel implements Serializable {

    private static final long serialVersionUID = -6526090831829572187L;

    @NotNull(message = "记账信息对应的账户id异常,请核实后再请求！！！")
    @Min(value = 1 ,message = "记账信息对应的账户id异常,请核实后再请求！！！")
    private Long manageAccountId;

    @NotBlank(message = "记账方向为未指定！！！")
    @Pattern(regexp = "^0|1$" , message = "记账方向为未指定！！！")
    private String accountingDirection;

    @NotNull(message = "记账金额异常,请核实后再请求！！！")
    @Min(value = 0 ,message = "记账金额异常,请核实后再请求！！！")
    private BigDecimal accountingAmount;

    private BigDecimal remainingAmount;

    @NotBlank(message = "记账类型错误!")
    @Pattern(regexp = "^0|1$" ,message = "记账类型错误!")
    private String accountingType;

    private String targetAccount;

    private String targetAccountName;

    private String saleContractNo;

    private String purchaseContractNo;

    private Date tradingDate;

    @NotBlank(message = "操作流水号必传!")
    private String tradingNo;

    @NotBlank(message = "操作人必传!")
    private String operator;

    @NotBlank(message = "文件名必传!")
    private String fileName;
    
    @NotBlank(message = "文件路径必传！")
    private String fileUrl;

    @NotBlank(message = "摘要必传！")
    private String type;

    private String remark;

    /**记账方式  0：手工记账 1：系统扣减*/
    @NotBlank(message = "记账方法未指定！！！")
    @Pattern(regexp = "^0|1$" , message = "记账方法未指定！！！")
    private String accountingMethod;
    
    public String getAccountingMethod() {
    
        return accountingMethod;
    }

    public void setAccountingMethod(String accountingMethod) {
        this.accountingMethod = accountingMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.manage_account_id
     *
     * @return the value of jf_manage_account_record.manage_account_id
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public Long getManageAccountId() {
        return manageAccountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.manage_account_id
     *
     * @param manageAccountId the value for jf_manage_account_record.manage_account_id
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setManageAccountId(Long manageAccountId) {
        this.manageAccountId = manageAccountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.accounting_direction
     *
     * @return the value of jf_manage_account_record.accounting_direction
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getAccountingDirection() {
        return accountingDirection;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.accounting_direction
     *
     * @param accountingDirection the value for jf_manage_account_record.accounting_direction
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setAccountingDirection(String accountingDirection) {
        this.accountingDirection = accountingDirection == null ? null : accountingDirection.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.accounting_amount
     *
     * @return the value of jf_manage_account_record.accounting_amount
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public BigDecimal getAccountingAmount() {
        return accountingAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.accounting_amount
     *
     * @param accountingAmount the value for jf_manage_account_record.accounting_amount
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setAccountingAmount(BigDecimal accountingAmount) {
        this.accountingAmount = accountingAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.remaining_amount
     *
     * @return the value of jf_manage_account_record.remaining_amount
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public BigDecimal getRemainingAmount() {
        return remainingAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.remaining_amount
     *
     * @param remainingAmount the value for jf_manage_account_record.remaining_amount
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setRemainingAmount(BigDecimal remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.accounting_type
     *
     * @return the value of jf_manage_account_record.accounting_type
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getAccountingType() {
        return accountingType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.accounting_type
     *
     * @param accountingType the value for jf_manage_account_record.accounting_type
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setAccountingType(String accountingType) {
        this.accountingType = accountingType == null ? null : accountingType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.target_account
     *
     * @return the value of jf_manage_account_record.target_account
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getTargetAccount() {
        return targetAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.target_account
     *
     * @param targetAccount the value for jf_manage_account_record.target_account
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setTargetAccount(String targetAccount) {
        this.targetAccount = targetAccount == null ? null : targetAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.target_account_name
     *
     * @return the value of jf_manage_account_record.target_account_name
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getTargetAccountName() {
        return targetAccountName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.target_account_name
     *
     * @param targetAccountName the value for jf_manage_account_record.target_account_name
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setTargetAccountName(String targetAccountName) {
        this.targetAccountName = targetAccountName == null ? null : targetAccountName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.sale_contract_no
     *
     * @return the value of jf_manage_account_record.sale_contract_no
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getSaleContractNo() {
        return saleContractNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.sale_contract_no
     *
     * @param saleContractNo the value for jf_manage_account_record.sale_contract_no
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setSaleContractNo(String saleContractNo) {
        this.saleContractNo = saleContractNo == null ? null : saleContractNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.purchase_contract_no
     *
     * @return the value of jf_manage_account_record.purchase_contract_no
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getPurchaseContractNo() {
        return purchaseContractNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.purchase_contract_no
     *
     * @param purchaseContractNo the value for jf_manage_account_record.purchase_contract_no
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setPurchaseContractNo(String purchaseContractNo) {
        this.purchaseContractNo = purchaseContractNo == null ? null : purchaseContractNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.trading_date
     *
     * @return the value of jf_manage_account_record.trading_date
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public Date getTradingDate() {
        return tradingDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.trading_date
     *
     * @param tradingDate the value for jf_manage_account_record.trading_date
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setTradingDate(Date tradingDate) {
        this.tradingDate = tradingDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.trading_no
     *
     * @return the value of jf_manage_account_record.trading_no
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getTradingNo() {
        return tradingNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.trading_no
     *
     * @param tradingNo the value for jf_manage_account_record.trading_no
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setTradingNo(String tradingNo) {
        this.tradingNo = tradingNo == null ? null : tradingNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.operator
     *
     * @return the value of jf_manage_account_record.operator
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.operator
     *
     * @param operator the value for jf_manage_account_record.operator
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.file_name
     *
     * @return the value of jf_manage_account_record.file_name
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.file_name
     *
     * @param fileName the value for jf_manage_account_record.file_name
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.file_url
     *
     * @return the value of jf_manage_account_record.file_url
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.file_url
     *
     * @param fileUrl the value for jf_manage_account_record.file_url
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.type
     *
     * @return the value of jf_manage_account_record.type
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.type
     *
     * @param type the value for jf_manage_account_record.type
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jf_manage_account_record.remark
     *
     * @return the value of jf_manage_account_record.remark
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jf_manage_account_record.remark
     *
     * @param remark the value for jf_manage_account_record.remark
     *
     * @mbggenerated Tue Aug 27 10:37:08 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

}