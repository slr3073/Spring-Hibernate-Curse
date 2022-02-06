package com.slr3073.apps;

import com.slr3073.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beansLifeCycleApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-lifecycle-appContext.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        //Les logs dans les fonctions de cycles de vie sont visibles
        context.close();
    }
}
