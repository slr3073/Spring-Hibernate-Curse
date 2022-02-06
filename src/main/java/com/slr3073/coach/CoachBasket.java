package com.slr3073.coach;

import com.slr3073.fortune.FortuneService;

public class CoachBasket implements Coach{

    private final FortuneService fortuneService;

    public CoachBasket(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyTraining() {
        return "40 m de dribles";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }
}
