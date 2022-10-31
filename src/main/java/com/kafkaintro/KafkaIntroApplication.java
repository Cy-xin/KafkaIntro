package com.kafkaintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(scanBasePackages={"com.kafkaintro"})
public class KafkaIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaIntroApplication.class, args);
    }

}
