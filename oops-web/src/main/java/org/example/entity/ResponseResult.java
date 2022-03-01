package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.example.exception.ErrorCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jingwen.li
 * @date 2022/2/28
 */
@Data
public class ResponseResult <T> implements Serializable {

    private static final long serialVersionUID = 955446145503727049L;
    private Integer code;

    private String msg;

    private String path;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date timestamp = new Date();

    private T data;

    public static  <T> ResponseResult<T> success(T data){
        ResponseResult<T> result = new ResponseResult<>();
        result.setData(data);
        result.setMsg("success");
        result.setCode(200);
        return result;
    }
    /**
     * 失败
     */
    public static <T> ResponseResult<T> error(Integer code, String message) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMsg(message);
        result.setData(null);
        return result;
    }

    /**
     * 失败
     */
    public static <T> ResponseResult<T> error(ErrorCode err) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(err.getCode());
        result.setMsg(err.getMsg());
        result.setData(null);
        return result;
    }
}
