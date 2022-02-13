package com.slr3073.apps;

import com.slr3073.SLRConfig;
import com.slr3073.coachs.Coach;
import com.slr3073.coachs.CoachPiscine;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigApp {
    public static void main(String[] args) {
        //Configuration sans XML seulement avec les annotations
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SLRConfig.class);

        CoachPiscine coachPiscine = context.getBean("coachPiscine", CoachPiscine.class);

        System.out.println(coachPiscine.getDailyWorkout());
        System.out.println(coachPiscine.getFortune());
        //Injection de valeurs depuis un fichier de propriété
        System.out.println("age : " + coachPiscine.getAge());
        System.out.println("mail : " + coachPiscine.getMail());
        context.close();
    }
}
