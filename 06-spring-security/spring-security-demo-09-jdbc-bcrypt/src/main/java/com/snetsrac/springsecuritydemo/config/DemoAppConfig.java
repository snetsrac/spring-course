package com.snetsrac.springsecuritydemo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.snetsrac.springsecuritydemo")
@PropertySource("classpath:persistence-postgresql.properties")
public class DemoAppConfig {

    // Define variable to hold properties
    @Autowired
    private Environment env;

    // Set up a logger for diagnostics
    private Logger logger = Logger.getLogger(getClass().getName());

    // Define a bean for view resolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    // Define a bean for security datasource
    @Bean
    public DataSource securityDataSource() {
        // Create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        try {
            // Set the jdbc driver class
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException exc) {
            exc.printStackTrace();
            throw new RuntimeException(exc);
        }

        // Log connection properties
        logger.warning("jdbc.url=" + env.getProperty("jdbc.url"));
        logger.warning("jdbc.user=" + env.getProperty("jdbc.user"));

        // Set database connection properties
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        // Set connection pool properties
        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    // Helper method to convern environment property to int
    private int getIntProperty(String propertyName) {
        return Integer.parseInt(env.getProperty(propertyName));
    }
}
