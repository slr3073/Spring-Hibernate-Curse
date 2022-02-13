package com.slr3073;

import com.slr3073.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Instructor instructor = new Instructor("Romain", "SALVAN", "romain.salvan@g-mail.fr", null);
        Course course1 = new Course("Java Spring Tutorial", instructor);
        Course course2 = new Course(".NET Tutorial", instructor);
        Course course3 = new Course("C# Tutorial", instructor);
        Student student1 = new Student("Bernard", "Lermite", "blerm@sfr.fr");
        Student student2 = new Student("Edward", "Clement", "edoooo@gmail.com");
        Student student3 = new Student("Lola", "Clark", "lola@hotmail.fr");

        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student1.getCourses().add(course3);
        student2.getCourses().add(course3);
        student3.getCourses().add(course3);

        //Ajout du cours, de l'instructeur et des reviews
        Session session = getCurrentSessionFromConfig();
        session.beginTransaction();
        session.save(instructor);
        session.save(course1);
        session.save(course2);
        session.save(course3);
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.getTransaction().commit();

        session = getCurrentSessionFromConfig();
        session.beginTransaction();
        course1 = session.get(Course.class, 1L);
        log.info("Students in c1 : {}", course1.getStudents());
        session.getTransaction().commit();
    }

    public static Session getCurrentSessionFromConfig() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}
