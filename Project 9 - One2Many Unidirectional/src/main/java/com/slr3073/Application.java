package com.slr3073;

import com.slr3073.entities.Course;
import com.slr3073.entities.Instructor;
import com.slr3073.entities.InstructorDetail;
import com.slr3073.entities.Review;
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
        Course course = new Course("Java Spring Tutorial", instructor);
        Review review1 = new Review("Super cour !");
        Review review2 = new Review("Nul à chier");
        Review review3 = new Review("Trop bien !");
        course.getReviews().add(review1);
        course.getReviews().add(review2);
        course.getReviews().add(review3);

        //Ajout du cours, de l'instructeur et des reviews
        Session session = getCurrentSessionFromConfig();
        session.beginTransaction();
        session.save(instructor);
        session.save(course);
        session.getTransaction().commit();

        //On vérifie que les reviews sont bien accessible depuis le cours
        session = getCurrentSessionFromConfig();
        session.beginTransaction();
        log.info("Reviews : {}", session.get(Course.class, 1L).getReviews());
        session.getTransaction().commit();

        //On supprime le cours, qui supprime toute les reviews en cascade
        session = getCurrentSessionFromConfig();
        session.beginTransaction();
        session.delete(session.get(Course.class, 1L));
        session.getTransaction().commit();

    }

    public static Session getCurrentSessionFromConfig() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}
