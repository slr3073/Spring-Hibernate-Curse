package com.slr3073.coachs;

import com.slr3073.fortunes.Fortune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // On peut rajouter une scope
public class CoachTennis implements Coach {
    //Injection de dépendances par champs (fields)
    @Autowired
    @Qualifier("happyFortune") // On spécifie explicitement quel bean on choisit, car il y a plusieurs implémentations de fortune
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
