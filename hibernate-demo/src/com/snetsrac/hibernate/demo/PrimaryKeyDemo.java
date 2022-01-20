package com.snetsrac.hibernate.demo;

import com.snetsrac.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            
            // Create 3 student objects
            Student tempStudent1 = new Student("Gary", "Chess", "gary@chess.com");
            Student tempStudent2 = new Student("John", "Doe", "john@doe.com");
            Student tempStudent3 = new Student("Jerry", "Seinfeld", "jerry@seinfeld.com");

            // Start transaction
            session.beginTransaction();

            // Save the student
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // Commit the transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
