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
