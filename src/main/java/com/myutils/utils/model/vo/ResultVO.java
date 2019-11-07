package com.myutils.utils.model.vo;

import com.myutils.utils.model.enums.ResultVOEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: utils
 * @description: 接口返回对象, 格式同ResponseUtils
 * @author:
 * @create: 2019-10-21 17:40
 **/
@Data
public class ResultVO {
    private Integer code;
    private Object data;
    private String message;

    //这个构造器
    public ResultVO(Integer code, Object data, String message) {
    }

    public static ResultVO success(Object data,String message){
        return new ResultVO(ResultVOEnum.SUCCESS.getCode(),data,message);
    }
    public static ResultVO success(Object data){
        return success(data,null);
    }
    public static ResultVO success(String message){
        return success(null,message);
    }
    public static ResultVO success(){
        return success(null);
    }
}
