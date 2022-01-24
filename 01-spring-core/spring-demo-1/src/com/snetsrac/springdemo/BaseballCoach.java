package com.snetsrac.springdemo;

public class BaseballCoach implements Coach {
    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Do the batting cage thing.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
