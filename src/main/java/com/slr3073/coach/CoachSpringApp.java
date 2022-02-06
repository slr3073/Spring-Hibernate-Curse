package com.slr3073.coach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoachSpringApp {
    public static void main(String[] args) {
        //Chargement du contexte
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

        //On récupère le bean qu'on a configuré dans le xml de contexte
        Coach coach = context.getBean("myCoach", Coach.class);
        System.out.println(coach.getDailyTraining());

        context.close();
    }
}
