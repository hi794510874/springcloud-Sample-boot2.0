package com.bob.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by huang_b on 2018/5/3.
 */

@RestController
public class BasicController {
    @Value("${PackageFH.AsyncQueue.CacheCtripHotelRequestQos}")
    private String CacheCtripHotelRequestQos;

    @GetMapping("/hello_world")
    public Mono<String> sayHelloWorld() {

        return Mono.just(CacheCtripHotelRequestQos);
    }
}
