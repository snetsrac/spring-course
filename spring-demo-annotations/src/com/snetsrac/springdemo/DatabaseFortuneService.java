package com.snetsrac.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Database says: error, crystal_ball is null.";
    }
}
