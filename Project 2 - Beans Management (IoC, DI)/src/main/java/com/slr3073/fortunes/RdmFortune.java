package com.slr3073.fortunes;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RdmFortune implements Fortune {
    private final static String[] FORTUNES = {"Jours de merde", "Jours de chance", "Jour de l'amour"};

    @Override
    public String getFortune() {
        Random rdm = new Random();
        return FORTUNES[rdm.nextInt(FORTUNES.length)];
    }
}
