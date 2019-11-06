package com.myutils.utils.model.vo;

import com.myutils.utils.model.enums.StatusEnum;

import java.io.Serializable;

/**
 * @program: utils
 * @description: http响应基类
 * @author:
 * @create: 2019-10-21 18:44
 **/
public class BaseResponseVO<D> implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int success = 0;
    private static final int fail = -1;

    /**
     * 返回码
     */
    protected int code;

    /**
     * 错误信息
     */
    protected String message;

    /**
     * 消息对象
     */
    protected D data;

    public static int getSuccess() {
        return success;
    }

    public static int getFail() {
        return fail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message.isEmpty()?"":message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SuppressWarnings("unchecked")
    public D getData() {
        if (data == null){
            data = (D)new String();
        }
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public BaseResponseVO(StatusEnum status) {
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseResponseVO(D data) {
        this(StatusEnum.OK);
        this.data = data;
    }
}
