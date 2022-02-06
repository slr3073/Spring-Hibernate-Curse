package com.slr3073.apps;

import com.slr3073.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("appContext.xml");
        Coach coach = context.getBean("myCoachBoxe", Coach.class);

        System.out.println(coach.getDailyTraining());
        System.out.println(coach.getFortune());

        context.close();
    }
}
