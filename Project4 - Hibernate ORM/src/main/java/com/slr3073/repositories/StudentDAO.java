package com.slr3073.repositories;

import com.slr3073.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private SessionFactory factory;

    public StudentDAO() {
        this.factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
    }

    public void create(Student student) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    public Student read(long id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student result = session.get(Student.class, id);
        session.getTransaction().commit();
        return result;
    }

    public List<Student> readAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Student> result = session.createQuery("from Student").getResultList();
        session.getTransaction().commit();
        return result;
    }

    public List<Student> readAll(String lastName) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Student> result = session.createQuery("from Student s where s.lastName = '" + lastName + "'").getResultList();
        session.getTransaction().commit();
        return result;
    }

    public List<Student> readAll(String lastName, String firstName) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String request = String.format("from Student s where s.lastName = '%s' or s.firstName = '%s'",lastName,firstName);
        List<Student> result = session.createQuery(request).getResultList();
        session.getTransaction().commit();
        return result;
    }

    public void updateFirstName(long id, String firstName){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        student.setFirstName(firstName);
        session.getTransaction().commit();
    }

    public void updateAllEmails(String email){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("update Student set email = '"+ email +"'").executeUpdate();
        session.getTransaction().commit();
    }

    public void delete(long id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
    }
}
