package com.snetsrac.springdemo;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "You're going to have a great time.";
    }
}
