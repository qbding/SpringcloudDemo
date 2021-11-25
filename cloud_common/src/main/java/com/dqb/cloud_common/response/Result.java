package com.dqb.cloud_common.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Result<T>  implements Serializable {

    public static final  int SUCCESS= 0;
    public static  final String  DEFAULT_SUCCESS_MESSAGE="success";
    private static final long serialVersionUID = -4879176164351146738L;
    private int code;
    private String message;
    private T data;


    /**
     * 禁止外部实例化，默认成功
     */
    protected Result()
    {
        code=SUCCESS;
        message=DEFAULT_SUCCESS_MESSAGE;
    }

    /**
     * 禁止外部实例化，默认成功 带数据
     * @param data
     */
    protected Result(T data)
    {
        this();
        this.data=data;
    }


    /**
     * 返回成功的数据
     * @return
     */
    public static Result success()
    {
        return new Result();
    }

    /**
     * 返回成功的数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T>  Result success(T data)
    {
        return new Result(data);
    }








    /**
     * 自定义返回dto
     * @param code  自定义code
     * @param message  自定义message
     * @param data  返回的数据
     * @param <T>
     * @return
     */
    public  static <T> Result fail(int code,String message,T data)
    {
        Result result = new Result();
        result.code=code;
        result.message=message;
        result.data=data;
       return result;
    }

    /**
     * 操作失败返回dto
     * @param message  自定义的错误
     * @param
     * @return
     */
    public  static   Result  fail(String message)
    {
        return new Result(message);
    }

}
