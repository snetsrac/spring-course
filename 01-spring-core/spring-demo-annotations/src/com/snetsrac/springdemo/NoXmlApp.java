package com.snetsrac.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoXmlApp {
    public static void main(String[] args) {
        // Create the application context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.snetsrac.springdemo");

        // Get a bean from the container
        Coach theCoach = context.getBean("swimCoach", Coach.class);

        // Call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // Close the context
        context.close();
    }
}
