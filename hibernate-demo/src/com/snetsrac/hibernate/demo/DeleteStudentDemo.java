package com.snetsrac.hibernate.demo;

import java.util.List;

import com.snetsrac.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
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

            // Get a new session and start a new transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Delete extra Chucks
            List<Student> students = session
                .createQuery("from Student where email like '%knucklehead.com' and id > 5", Student.class)
                .getResultList();

            for (Student student : students) {
                System.out.println(student);
                session.delete(student);
            }
            
            students = session
                .createQuery("from Student", Student.class)
                .getResultList();

            // Commit the transaction
            session.getTransaction().commit();

            for (Student student : students) {
                System.out.println(student);
            }

        } finally {
            factory.close();
        }
    }
}
