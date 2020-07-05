package com.neusoft.bsp.common.exception;

public class BusinessException extends RuntimeException {
    public static final BusinessException USERNAME_NOT_EXISTS = new BusinessException(504, "user doesn't exist", new Object[0]);
    public static final BusinessException PASSWORD_WRONG = new BusinessException(504, "password is wrong", new Object[0]);
    public static final BusinessException INSERT_FAIL = new BusinessException(504, "add operation failed", new Object[0]);
    public static final BusinessException USERID_NOT_EXISTS = new BusinessException(504, "user id doesn't exist", new Object[0]);
    public static final BusinessException MANID_NOT_EXISTS = new BusinessException(504, "manufacturer id doesn't exist", new Object[0]);
    public static final BusinessException UPDATE_FAIL = new BusinessException(504, "update operation failed", new Object[0]);
    public static final BusinessException USERID_NULL_ERROR = new BusinessException(504, "user id shouldn't be null", new Object[0]);
    public static final BusinessException BRDID_NULL_ERROR = new BusinessException(504, "brand id shouldn't be null", new Object[0]);
    public static final BusinessException MANID_NULL_ERROR = new BusinessException(504, "manufacturer id shouldn't be null", new Object[0]);
    public static final BusinessException PROID_NULL_ERROR = new BusinessException(504, "product id shouldn't be null", new Object[0]);
    public static final BusinessException PDNID_NULL_ERROR = new BusinessException(504, "product description id shouldn't be null", new Object[0]);
    public static final BusinessException PRCID_NULL_ERROR = new BusinessException(504, "product category id shouldn't be null", new Object[0]);
    public static final BusinessException OFPID_NULL_ERROR = new BusinessException(504, "offer price id shouldn't be null", new Object[0]);
    public static final BusinessException PCKID_NULL_ERROR = new BusinessException(504, "package info id shouldn't be null", new Object[0]);
    public static final BusinessException SPAID_NULL_ERROR = new BusinessException(504, "specific attribute id shouldn't be null", new Object[0]);
    public static final BusinessException SPVID_NULL_ERROR = new BusinessException(504, "specific attribute value id shouldn't be null", new Object[0]);
    public static final Exception DELETE_FAIL = new BusinessException(504, "delete operation failed", new Object[0]);;


    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BusinessException() {
    }

    public BusinessException(int code, String msg, Object... args) {
        super(String.format(msg, args));
        this.code = code;
        this.msg = String.format(msg, args);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException newInstance(String msg, Object... args) {
        return new BusinessException(this.code, msg, args);
    }

}
