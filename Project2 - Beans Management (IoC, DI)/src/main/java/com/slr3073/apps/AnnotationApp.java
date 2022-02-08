package com.slr3073.apps;

import com.slr3073.coachs.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        //On récupère bien l'entraîneur avec l'annotation @Component
        Coach coach = context.getBean("coachPetanque", Coach.class);
        System.out.println(coach.getDailyWorkout());

        // Maintenant qu'il y a plusieurs implémentations de fortune nous avons un problème si on ne dit pas
        // explicitement à spring laquelle choisir, on rajoute donc un @Qualifier("le bean id de celui que je veux")
        System.out.println(coach.getFortune());
        context.close();
    }

}
