package com.dqb.cloud_common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Ddescription
 * @Author 丁庆斌
 **/
@Data
@AllArgsConstructor
public class NeiApiException extends RuntimeException{

    private Integer code;

    private String message;


}
