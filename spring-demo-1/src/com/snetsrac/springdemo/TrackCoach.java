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

    // custom init method
    public void initMethod() {
        System.out.println("TrackCoach: inside init method");
    }

    // custom destroy method
    public void destroyMethod() {
        System.out.println("TrackCoach: inside destroy method");
    }
}
