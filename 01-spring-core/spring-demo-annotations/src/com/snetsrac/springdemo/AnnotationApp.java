package com.snetsrac.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {
    public static void main(String[] args) {
        // Read the Spring configuration file
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // Get the bean from the Spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // Call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // Close the context
        context.close();
    }
}
