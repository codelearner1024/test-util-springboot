package com.wwg.common;

/**
 * Defines WSN exceptions.
 *
 */
public class FinanceException extends Exception{

    private static final long serialVersionUID = -7182841244041932933L;
    /**
     * 统一错误码表，全局唯一，不可冲突。
     */
    protected String errorCode;

    public FinanceException(){
    }

    public FinanceException(String message){
        super(message);
    }

    public FinanceException(String message, Throwable cause){
        super(message, cause);
    }

    public FinanceException(Throwable cause){
        super(cause);
    }

    public FinanceException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public FinanceException(Throwable cause, String errorCode){
        super(cause);
        this.errorCode = errorCode;
    }

    public FinanceException(String message,Throwable cause, String errorCode){
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
