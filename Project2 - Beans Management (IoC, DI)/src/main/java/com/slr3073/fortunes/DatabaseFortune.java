package com.slr3073.fortunes;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortune implements Fortune {
    @Override
    public String getFortune() {
        return "ça sort de la bdd";
    }
}
