package com.snetsrac.hibernate.demo;

import com.snetsrac.hibernate.demo.entity.Course;
import com.snetsrac.hibernate.demo.entity.Instructor;
import com.snetsrac.hibernate.demo.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure()
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // Create objects
            // Instructor instructor = new Instructor("Yosemite", "Sam", "yosemite.sam@acme.com");
            // InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/c/rootinesttootinest", "killing rabbits");
            // Course rootin = new Course("Rootin'");
            // Course tootin = new Course("Tootin'");

            // Associate objects
            // instructor.setInstructorDetail(instructorDetail);
            // instructor.addCourse(rootin);
            // instructor.addCourse(tootin);

            // Start a transaction
            session.beginTransaction();

            // Save the instructor
            // session.save(rootin);
            // session.save(tootin);
            // session.save(instructor);

            System.out.println(session.createQuery("from Instructor i").getResultList());

            // Commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
