package com.slr3073.fortune;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "C'est votre jour de chance !";
    }
}
