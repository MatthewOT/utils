package com.myutils.utils.model.enums;

public enum StatusEnum {
    OK(0, "OK"),
    ERR(-1, "ERR"),
    SERVER_ERR(500, "internel error"),

    ;

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    StatusEnum() {
    }

    StatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
