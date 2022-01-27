package com.snetsrac.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount() {
        System.out.println(getClass() + ": inside addAccount()");
    }

    public void addAccount(String string, boolean bool) {
        System.out.println(getClass() + ": inside addAccount(String, boolean)");
    }
} 
