package com.slr3073.repositories;

import com.slr3073.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
    private SessionFactory factory;
    public StudentDAO() {
        this.factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
    }

    public void create(Student student){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    public Student read(long id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student result = session.get(Student.class, id);
        session.getTransaction().commit();
        return result;
    }
}
