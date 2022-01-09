package com.snetsrac.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan; // Not needed for the NoXmlApp
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.snetsrac.springdemo") // Not needed for the NoXmlApp
public class SportConfig {
    @Bean
    public FortuneService databaseFortuneService() {
        return new DatabaseFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        SwimCoach swimCoach = new SwimCoach(databaseFortuneService());

        return swimCoach;
    }

    @Bean
    public Coach tennisCoach() {
        TennisCoach tennisCoach = new TennisCoach();

        return tennisCoach;
    }
}
