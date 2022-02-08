package com.slr3073.apps;

import com.slr3073.coach.Coach;
import com.slr3073.coach.CoachBoxe;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("appContext.xml");
        CoachBoxe coach = context.getBean("myCoachBoxe", CoachBoxe.class);

        System.out.println(coach.getDailyTraining());
        System.out.println(coach.getFortune());

        // Injection de valeurs littérales
        System.out.println(coach.getMail());
        System.out.println(coach.getAge());

        context.close();
    }
}
