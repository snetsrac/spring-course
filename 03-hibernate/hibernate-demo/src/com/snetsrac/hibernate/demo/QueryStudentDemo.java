package com.snetsrac.hibernate.demo;

import java.util.List;

import com.snetsrac.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // Start transaction
            session.beginTransaction();

            // Query students
            System.out.println("\n\nStudents:");
            List<Student> students = session.createQuery("from Student", Student.class).getResultList();
            for (Student student : students) {
                System.out.println(student);
            }

            // Query students: lastName='Doe'
            System.out.println("\n\nDoes:");
            students = session
                    .createQuery("from Student s where s.lastName='Doe'", Student.class)
                    .getResultList();
            for (Student student : students) {
                System.out.println(student);
            }

            // Query students: lastName='Doe' OR firstName='Donald'
            System.out.println("\n\nDoes/Donalds:");
            students = session
                    .createQuery("from Student s where s.lastName='Doe' OR firstName='Donald'", Student.class)
                    .getResultList();
            for (Student student : students) {
                System.out.println(student);
            }

            // Query students: email LIKE '%e.com'
            System.out.println("\n\ne.coms:");
            students = session
                    .createQuery("from Student s where s.email like '%e.com'", Student.class)
                    .getResultList();
            for (Student student : students) {
                System.out.println(student);
            }

            System.out.println("\n");

            // Commit the transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
