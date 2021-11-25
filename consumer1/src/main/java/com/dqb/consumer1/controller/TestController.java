package com.dqb.consumer1.controller;

import com.dqb.cloud_common.response.Result;
import com.dqb.openfeign.feign.ProducerFeign1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Ddescription
 * @Author 丁庆斌
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProducerFeign1 producerFeign1;


    @RequestMapping("test1")
    public String test1(){
        System.out.println("-------进入c1----------");
        String s = restTemplate.getForObject("http://producer1/test/test1", String.class);
        return s;
    }

    @RequestMapping("feign")
    public String feign(){
        System.out.println("-------测试openfeign  进入c1----------");
        String s = producerFeign1.test();
        return s;
    }

    @PostMapping("feignResult")
    public Result<String> feignResult(){
        System.out.println("-------测试openfeign  进入c1----------");
        try {
            Result<String> s = producerFeign1.testFeignResult();
            System.out.println("FeignErrDecoder  之后");
            return s;
        }catch (Exception e){
            System.out.println("进入catch异常处理");
            return Result.fail(-1,"asdasdasdasd",null);
        }
    }
}
