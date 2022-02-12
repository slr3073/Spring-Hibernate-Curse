package com.slr3073;

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
        InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/luv2code", "Kayak");
        Instructor instructor = new Instructor("Romain", "SALVAN", "romain.salvan@g-mail.fr", instructorDetail);

        //Insertion en cascade du détail
        Session session = getCurrentSessionFromConfig();
        session.beginTransaction();
        session.save(instructor);
        session.getTransaction().commit();

        //On peut maintenant récup l'instructeur depuis le détail
        session = getCurrentSessionFromConfig();
        session.beginTransaction();
        InstructorDetail detail = session.get(InstructorDetail.class, instructorDetail.getId());
        Instructor instructor1 = detail.getInstructor();
        System.out.println(instructor1.getEmail());
        session.getTransaction().commit();

        //Suppression en cascade depuis le détail
        session = getCurrentSessionFromConfig();
        session.beginTransaction();
        detail = session.get(InstructorDetail.class, instructorDetail.getId());
        session.delete(detail);
        session.getTransaction().commit();
    }

    public static Session getCurrentSessionFromConfig() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}
