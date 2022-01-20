package com.snetsrac.hibernate.demo;

import com.snetsrac.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            
            // Create a student object
            Student tempStudent = new Student("Joe", "Schmoe", "joe@schmoe.com");

            // Start transaction
            session.beginTransaction();

            // Save the student
            session.save(tempStudent);

            // Commit the transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
