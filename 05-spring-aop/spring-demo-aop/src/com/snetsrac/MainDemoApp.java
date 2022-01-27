package com.snetsrac;

import com.snetsrac.aopdemo.DemoConfig;
import com.snetsrac.aopdemo.dao.AccountDAO;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        // Create a Spring application context using the config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // Get the DAO bean
        AccountDAO accountDAO = context.getBean(AccountDAO.class);

        // Call the addAccount method on the DAO
        System.out.println();
        accountDAO.addAccount();
        System.out.println();

        System.out.println();
        accountDAO.addAccount("Ding dong, yo.", true);
        System.out.println();

        // Close the context
        context.close();
    }
}
