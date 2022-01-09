package com.snetsrac.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    // Field injection
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    // Constructor injection
    // @Autowired
    // public TennisCoach(FortuneService fortuneService) {
    //     this.fortuneService = fortuneService;
    // }

    // Setter injection
    // @Autowired
    // public void setFortuneService(FortuneService fortuneService) {
    //     this.fortuneService = fortuneService;
    // }

    // Method injection
    // @Autowired
    // public void doSomething(FortuneService fortuneService) {
    //     System.out.println(fortuneService);
    // }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
