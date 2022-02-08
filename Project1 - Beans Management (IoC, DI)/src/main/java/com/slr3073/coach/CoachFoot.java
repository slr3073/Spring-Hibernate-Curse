package com.slr3073.coach;

import com.slr3073.fortune.FortuneService;
import com.slr3073.fortune.HappyFortuneService;

public class CoachFoot implements Coach {

    private final FortuneService fortuneService;

    public CoachFoot(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyTraining() {
        return "1h de tir au but";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }

    public void onStartBeans(){
        System.out.println("Inside start lifecycle");
    }

    public void onDestroyBeans(){
        System.out.println("Inside destroy lifecycle");
    }
}
