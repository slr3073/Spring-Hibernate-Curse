package com.slr3073.fortunes;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements Fortune {

    @Override
    public String getFortune() {
        return "Jour de chance !";
    }
}
