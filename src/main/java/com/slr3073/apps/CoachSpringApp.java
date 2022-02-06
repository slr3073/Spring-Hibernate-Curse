package com.slr3073.apps;

import com.slr3073.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoachSpringApp {
    public static void main(String[] args) {
        //Chargement du contexte
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

        //On récupère le bean qu'on a configuré dans le xml de contexte
        Coach coach = context.getBean("myCoach", Coach.class);

        // Le bean est déjà entièrement construit toutes les dépendances sont injectées
        System.out.println(coach.getDailyTraining());
        System.out.println(coach.getFortune());

        context.close();
    }
}
