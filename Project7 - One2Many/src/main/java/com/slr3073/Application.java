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

        InstructorDetail instructorDetail1 = new InstructorDetail("slr3073Gaming", "Gaming");
        Instructor instructor1 = new Instructor("Romain", "SALVAN", "romain.salvan@g-mail.fr", instructorDetail1);
        Course c1 = new Course("Java Spring Tutorial", instructor1);
        Course c2 = new Course(".NET Tutorial", instructor1);
        Course c3 = new Course("Laravel Tutorial", instructor1);

        //Append des cours et de l'instructeur1
        Session session = getCurrentSessionFromConfig();
        session.beginTransaction();
        session.save(instructor1);
        session.save(c1);
        session.save(c2);
        session.save(c3);
        session.getTransaction().commit();

        //Vérification
        session = getCurrentSessionFromConfig();
        session.beginTransaction();
        Instructor inst = session.get(Instructor.class, instructor1.getId());
        log.info("Courses : {}", inst.getCourses());
        session.getTransaction().commit();
        session.close();
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
