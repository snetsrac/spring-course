package com.snetsrac.springdemo;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run 5 miles.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
