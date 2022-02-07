package com.slr3073.coachs;

import com.slr3073.fortunes.Fortune;
import org.springframework.beans.factory.annotation.Value;

public class CoachPiscine implements Coach {
    private Fortune fortune;
    //Injection de valeurs depuis un fichier de propriété sans xml
    @Value("${mail}")
    private String mail;

    @Value("${age}")
    private int age;

    public CoachPiscine(Fortune fortune) {
        this.fortune = fortune;
    }

    public String getMail() {
        return mail;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getDailyWorkout() {
        return "Nage 1h puis passe sous la douche";
    }

    @Override
    public String getFortune() {
        return fortune.getFortune();
    }
}
