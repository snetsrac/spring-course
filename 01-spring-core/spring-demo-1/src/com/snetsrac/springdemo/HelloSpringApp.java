package com.snetsrac.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        // Load the Spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve bean from Spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        HockeyCoach hockeyCoach = context.getBean("myHockeyCoach", HockeyCoach.class);

        // Call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println();
        System.out.println(hockeyCoach.getDailyWorkout());
        System.out.println(hockeyCoach.getDailyFortune());
        System.out.println(hockeyCoach.getEmailAddress());
        System.out.println(hockeyCoach.getTeam());
        System.out.println("He's got " + hockeyCoach.getTeeth() + " teeth.");

        // Close the context
        context.close();
    }
}
