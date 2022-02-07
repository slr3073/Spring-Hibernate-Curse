package com.slr3073.coachs;

import com.slr3073.fortunes.Fortune;

public class CoachPiscine implements Coach {
    private Fortune fortune;

    public CoachPiscine(Fortune fortune) {
        this.fortune = fortune;
    }

    @Override
    public String getDailyWorkout() {
        return "Nage 1h puis passe sous la douche";
    }

    @Override
    public String getFortune() {
        return fortune.getFortune();
    }
}
