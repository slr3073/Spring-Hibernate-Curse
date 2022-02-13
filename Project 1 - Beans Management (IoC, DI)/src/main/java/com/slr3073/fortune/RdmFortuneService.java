package com.slr3073.fortune;

import java.util.Random;

public class RdmFortuneService implements FortuneService{
    private final static String[] FORTUNES = {"Jour de merde", "Jour de chance", "Jour de l'amour", "Jour de la haine"};

    @Override
    public String getFortune() {
        Random rdm = new Random();
        return FORTUNES[rdm.nextInt(FORTUNES.length)];
    }
}
