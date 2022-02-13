package com.slr3073.fortunes;

import org.springframework.stereotype.Component;

@Component
public class RESTFortune implements Fortune {
    @Override
    public String getFortune() {
        return "la fortune restful";
    }
}
