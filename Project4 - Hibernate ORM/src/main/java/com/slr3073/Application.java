package com.slr3073;

import com.slr3073.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            Student s = new Student("Romain", "SALVAN", "romain.salvan@g-mail.fr");
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
        }


    }


}
