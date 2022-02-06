package com.slr3073.apps;

import com.slr3073.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beansScopeApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-scope-appContext.xml");
        Coach coach1 = context.getBean("myCoach", Coach.class);
        Coach coach2 = context.getBean("myCoach", Coach.class);

        //C'est le même entraîneur, lorsque le beans scope est singleton sinon c'est une instance différente
        System.out.println(coach1 == coach2);
        System.out.println("adresse coach1 : " + coach1);
        System.out.println("adresse coach2 : " + coach2);
        context.close();
    }
}
