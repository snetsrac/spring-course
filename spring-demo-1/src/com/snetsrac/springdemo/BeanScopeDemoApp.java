package com.snetsrac.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        // Load the Spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // Retrieve beans from Spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // Check if they are the same
        boolean result = (theCoach == alphaCoach);

        // Display the result
        System.out.println("\nReferences are " + (result ? "" : "not ") + "equal.");
        System.out.println("\nMemory location for theCoach: " + theCoach);
        System.out.println("Memory location for alphaCoach: " + alphaCoach + "\n");

        // Close the context
        context.close();
    }
}