package com.slr3073.coachs;

import com.slr3073.fortunes.Fortune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoachTennis implements Coach {
    private Fortune fortune;

    //On injecte la dépendance automatiquement par contructeur
    @Autowired
    public CoachTennis(Fortune fortune) {
        this.fortune = fortune;
    }

    @Override
    public String getDailyWorkout() {
        return "Jouer deux match avec Nathan";
    }

    @Override
    public String getFortune() {
        return fortune.getFortune();
    }
}
