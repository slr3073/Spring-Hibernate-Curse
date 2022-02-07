package com.slr3073.apps;

import com.slr3073.SLRConfig2;
import com.slr3073.coachs.CoachBowling;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigApp2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SLRConfig2.class);
        CoachBowling coach = context.getBean("coachBowling", CoachBowling.class);
        System.out.println(coach.getFortune());
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getProp1());
        System.out.println(coach.getProp2());
        context.close();
    }
}
