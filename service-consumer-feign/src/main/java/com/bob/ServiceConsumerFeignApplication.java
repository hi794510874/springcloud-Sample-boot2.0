package com.bob;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ServiceConsumerFeignApplication {

    public static void main(String[] args) {
//        final SpringApplication application = new SpringApplication(ServiceConsumerFeignApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.setWebApplicationType(WebApplicationType.SERVLET);
//        application.run(args);
        SpringApplication.run(ServiceConsumerFeignApplication.class, args);
    }
}
