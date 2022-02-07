package com.slr3073.coachs;

import com.slr3073.fortunes.Fortune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoachPetanque implements Coach {
    private Fortune fortune;

    // Injection de la dépendance dans le constructeur
    @Autowired
    public CoachPetanque(Fortune fortune) {
        this.fortune = fortune;
    }

    @Override
    public String getDailyWorkout() {
        return "Tu tires ou tu pointes ?";
    }

    @Override
    public String getFortune() {
        return fortune.getFortune();
    }
}
