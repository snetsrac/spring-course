package com.snetsrac.springdemo;

import java.util.Random;

public class SadFortuneService implements FortuneService {
    String[] fortunes;

    public SadFortuneService() {
        fortunes = new String[] { "You're gonna have a bad time.", "Sources say no.", "We're all out of maple syrup!" };
    }

    @Override
    public String getFortune() {
        Random random = new Random();
        return fortunes[random.nextInt(3)];
    }
}
