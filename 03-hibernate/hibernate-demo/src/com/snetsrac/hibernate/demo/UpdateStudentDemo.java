package com.snetsrac.hibernate.demo;

import com.snetsrac.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            
            // Create a student object
            Student tempStudent = new Student("Chuck", "Knucklehead", "chuck@knucklehead.com");
            System.out.println(tempStudent);

            // Start transaction
            session.beginTransaction();

            // Save the student
            session.save(tempStudent);

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println(tempStudent);

            // Get a new session and start a new transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Get a student using the id
            Student aStudent = session.get(Student.class, tempStudent.getId());
            aStudent.setFirstName("Charles");

            // Commit the transaction
            session.getTransaction().commit();

            // Get a new session and start a new transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Get a student using the id
            session.createQuery("update Student set email='charles@knucklehead.com' where email like '%@knucklehead.com'").executeUpdate();

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println(aStudent);

        } finally {
            factory.close();
        }
    }
}
