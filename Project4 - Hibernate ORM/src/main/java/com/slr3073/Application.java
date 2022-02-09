package com.slr3073;

import com.slr3073.entities.Student;
import com.slr3073.repositories.StudentDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        StudentDAO studentDAO = new StudentDAO();

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Romain", "SALVAN", "romain.salvan@g-mail.fr"));
        students.add(new Student("Mehdi", "HAZM", "mehdi.hazm@g-mail.fr"));
        students.add(new Student("Alex", "AMSIF", "alex.amsif@g-mail.fr"));
        for(Student student : students) studentDAO.create(student);

        System.out.println(studentDAO.read(2));
        displayObjects(studentDAO.readAll());
        displayObjects(studentDAO.readAll("SALVAN"));


    }

    public static void displayObjects(List objects){
        for (Object o: objects) System.out.println(o);
    }




}
