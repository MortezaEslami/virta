package com.devolon.virtaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VirtaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirtaConsumerApplication.class, args);
    }

}
