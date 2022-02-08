package com.slr3073.apps;

import com.slr3073.coachs.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Coach coach1 = context.getBean("coachTennis",Coach.class);
        Coach coach2 = context.getBean("coachTennis",Coach.class);
        //c'est bien un prototype si faux
        System.out.println(coach1 == coach2);
        context.close();
    }
}
