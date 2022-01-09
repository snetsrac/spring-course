package com.snetsrac.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
    private Random random;
    
    public RandomFortuneService() {
        random = new Random();
    }

    @Override
    public String getFortune() {
        return "Cloudy with a " + random.nextInt(101) + "% chance of meatballs.";
    }
}
