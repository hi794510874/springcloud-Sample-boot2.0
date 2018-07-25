package com.bob.controller;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by huang_b on 2018/5/3.
 */

@RestController
public class BasicController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${PackageFH.AsyncQueue.CacheCtripHotelRequestQos}")
    private String CacheCtripHotelRequestQos;

    @Value("${logging.level.com.bob.controller.BasicController}")
    private String logLevel;

    @Autowired
    private HikariDataSource dataSource;

    @GetMapping("/hello_world")
    public String sayHelloWorld() {
        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");
        return CacheCtripHotelRequestQos + "   " + logLevel +"  "+dataSource.getJdbcUrl();
    }
}
