package com.dqb.producer1_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.dqb.**"})
@EnableDiscoveryClient
public class Producer12Application {

    public static void main(String[] args) {
        SpringApplication.run(Producer12Application.class, args);
    }

}
