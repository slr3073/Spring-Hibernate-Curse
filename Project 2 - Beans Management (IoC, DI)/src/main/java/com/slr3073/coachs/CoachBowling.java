package com.slr3073.coachs;

import com.slr3073.fortunes.Fortune;
import org.springframework.beans.factory.annotation.Value;

public class CoachBowling implements Coach{
    private Fortune fortune;

    @Value("${prop1}")
    private String prop1;

    @Value("${prop2}")
    private String prop2;

    public CoachBowling(Fortune fortune) {
        this.fortune = fortune;
    }

    public String getProp1() {
        return prop1;
    }

    public String getProp2() {
        return prop2;
    }

    @Override
    public String getDailyWorkout() {
        return "Lancer 30 boulasses !";
    }

    @Override
    public String getFortune() {
        return fortune.getFortune();
    }
}
