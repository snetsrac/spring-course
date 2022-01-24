package com.snetsrac.springdemo;

public class SwimCoach implements Coach {
    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 10 laps medium, then 10 laps fast.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
