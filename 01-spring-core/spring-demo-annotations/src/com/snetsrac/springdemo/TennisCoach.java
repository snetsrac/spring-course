package com.snetsrac.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // Singleton scope is the default, so this doesn't actually do anything
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

    @PostConstruct
    public void initMethod() {
        System.out.println("Doing init-type stuff.");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("Doing destroy-type stuff.");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
