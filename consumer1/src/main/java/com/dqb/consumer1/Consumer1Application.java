package com.dqb.consumer1;

import com.dqb.cloud_common.config.FeignErrDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.dqb.**"})//指定feign接口所在的包

public class Consumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer1Application.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    FeignErrDecoder feignErrDecoder(){
        return new FeignErrDecoder();
    }
}
