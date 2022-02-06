package com.slr3073.coach;

import com.slr3073.fortune.FortuneService;

public class CoachBoxe implements Coach {
    private FortuneService fortuneService;

    private String mail;
    private int age;

    // Pour l'injection de valeurs littérales
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // Pour l'injection par setter
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyTraining() {
        return "Cogner le sac pendant 30 minutes";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }
}
