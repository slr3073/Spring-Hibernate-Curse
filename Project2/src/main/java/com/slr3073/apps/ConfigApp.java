package com.slr3073.apps;

import com.slr3073.SLRConfig;
import com.slr3073.coachs.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigApp {
    public static void main(String[] args) {
        //Configuration sans XML seulement avec les annotations
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SLRConfig.class);

        Coach coach = context.getBean("coachPiscine", Coach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getFortune());
        context.close();
    }
}
