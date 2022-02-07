package com.slr3073.coachs;

import com.slr3073.fortunes.Fortune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoachTennis implements Coach {
    //Injection de dépendances par champs (fields)
    @Autowired
    private Fortune fortune;

    @Override
    public String getDailyWorkout() {
        return "Jouer deux match avec Nathan";
    }

    @Override
    public String getFortune() {
        return fortune.getFortune();
    }
}
