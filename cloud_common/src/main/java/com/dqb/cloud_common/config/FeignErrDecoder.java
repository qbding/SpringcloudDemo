package com.dqb.cloud_common.config;

import com.alibaba.fastjson.JSON;
import com.dqb.cloud_common.exception.NeiApiException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * @Ddescription
 * @Author 丁庆斌
 **/
@Configuration
public class FeignErrDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        System.out.println("------------进入FeignErrDecoder----------------");
        if (response.status() != HttpStatus.OK.value()) {
            if (response.status() == -100) {
                String errorContent;
                try {
                    errorContent = Util.toString(response.body().asReader());
                    NeiApiException internalApiException = JSON.parseObject(errorContent, NeiApiException.class);
                    return internalApiException;
                } catch (IOException e) {
                    return new NeiApiException(-1, "unknown error");
                }
            }
        }
        return new NeiApiException(-1, "unknown error");
    }
}
