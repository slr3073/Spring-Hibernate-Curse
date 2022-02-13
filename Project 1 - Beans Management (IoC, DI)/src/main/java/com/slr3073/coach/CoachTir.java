package com.slr3073.coach;

import com.slr3073.fortune.FortuneService;

public class CoachTir implements Coach{
    private final FortuneService fortuneService;

    public CoachTir(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyTraining() {
        return "Tir à la carabine : 3 chargeurs";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }
}
