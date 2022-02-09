package com.slr3073;

import com.slr3073.entities.Student;
import com.slr3073.repositories.StudentDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CRUDApp {

    public static void main(String[] args) {
        SpringApplication.run(CRUDApp.class, args);

        StudentDAO studentDAO = new StudentDAO();

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Romain", "SALVAN", "romain.salvan@g-mail.fr"));
        students.add(new Student("Mehdi", "HAZM", "mehdi.hazm@g-mail.fr"));
        students.add(new Student("Alex", "AMSIF", "alex.amsif@g-mail.fr"));

        //Create
        for(Student student : students) studentDAO.create(student);

        //Read
        System.out.println(studentDAO.read(2));
        displayObjects(studentDAO.readAll());
        displayObjects(studentDAO.readAll("SALVAN"));
        displayObjects(studentDAO.readAll("SALVAN","Mehdi"));

        //Update
        studentDAO.updateFirstName(1,"Rom");
        System.out.println(studentDAO.read(1));

    }

    public static void displayObjects(List objects){
        for (Object o: objects) System.out.println(o);
    }




}
