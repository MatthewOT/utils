package com.myutils.utils.model.enums;

public enum ResultVOEnum {
    /**
     *成功
     */
    SUCCESS(0,"succeed"),

    /**
     * 参数不全或参数错误
     */
    PARAM_ERROR(400,"参数不全或参数错误"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR_CODE(40000,"发生未知错误");

    private Integer code;
    private String message;

    ResultVOEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
