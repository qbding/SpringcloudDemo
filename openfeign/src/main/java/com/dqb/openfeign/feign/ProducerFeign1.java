package com.dqb.openfeign.feign;

import com.dqb.cloud_common.exception.NeiApiException;
import com.dqb.cloud_common.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "producer1")
public interface ProducerFeign1 {

    @RequestMapping("test/test1")
    String test();

    @PostMapping("test/test2")
    Result<String> testFeignResult()throws NeiApiException;
}
