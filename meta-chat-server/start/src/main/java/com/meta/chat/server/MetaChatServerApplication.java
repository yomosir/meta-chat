package com.meta.chat.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.meta.chat.server", "com.alibaba.cola" })
@MapperScan("com.meta.chat.server.gatewayimpl.database")
public class MetaChatServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetaChatServerApplication.class, args);
    }

}
