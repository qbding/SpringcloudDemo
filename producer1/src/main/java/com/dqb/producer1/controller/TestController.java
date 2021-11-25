package com.dqb.producer1.controller;

import com.dqb.cloud_common.config.NeiApi;
import com.dqb.cloud_common.exception.NeiApiException;
import com.dqb.cloud_common.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Ddescription
 * @Author 丁庆斌
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("test1")
    public String test1(){
        System.out.println("-------进入p1----------");
        return "aaaaa";
    }

    @PostMapping("test2")
    @NeiApi
    public Result<String> test2()  {
        try {
            System.out.println("-------进入p1-test2---------");
            if(true){
                throw new Exception("asdasdsa");
            }

            return Result.success("result 返回测试");
        }catch (Exception e){
            throw new NeiApiException(-1,e.getMessage());
//            throw (NeiApiException) e;
        }

    }
}
