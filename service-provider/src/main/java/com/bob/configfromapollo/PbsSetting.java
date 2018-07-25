package com.bob.configfromapollo;


import org.springframework.beans.factory.annotation.Value;

public class PbsSetting {

    public String getCacheCtripHotelRequestQos() {
        return cacheCtripHotelRequestQos;
    }

    @Value("${PackageFH.AsyncQueue.CacheCtripHotelRequestQos}")
    private String cacheCtripHotelRequestQos;


}
