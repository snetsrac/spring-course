package com.snetsrac.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Give it a rest, will ya? Today will be fine.";
    }
}
