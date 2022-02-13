package com.slr3073;

import com.slr3073.entities.Course;
import com.slr3073.entities.Instructor;
import com.slr3073.entities.InstructorDetail;
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
        Course course1 = new Course("Java tutorial", instructor);
        Course course2 = new Course("CSS tutorial", instructor);

        // Insertion des cours et de l'instructeur
        Session session = getCurrentSessionFromConfig();
        session.beginTransaction();
        session.save(instructor);
        session.save(course1);
        session.save(course2);
        session.getTransaction().commit();

        /* //Test lazy fetching (voir logs sql)
        session = getCurrentSessionFromConfig();
        session.beginTransaction();
        Instructor instructor1 = session.get(Instructor.class, 1L);
        System.out.println("-------");
        //la requête est faite seulement lorsque l'on demande les cours
        log.info("Courses : {}", instructor1.getCourses());
        session.getTransaction().commit();

        // ERROR : On ne peut pas lazy fetch si l'on n'est pas dans une session
        //log.info("Courses : {}", instructor1.getCourses()); */

        //Test eager fetching (voir logs sql)
        session = getCurrentSessionFromConfig();
        session.beginTransaction();
        Instructor instructor1 = session.get(Instructor.class, 1L);
        System.out.println("-------");
        //Aucune requête n'est faite ici : on a déjà récup les cours
        log.info("Courses : {}", instructor1.getCourses());
        session.getTransaction().commit();

        //Pas de problème pour log en dehors de la session : on a déjà récup les cours
        log.info("Courses : {}", instructor1.getCourses());
    }

    public static Session getCurrentSessionFromConfig() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}
