package com.slr3073.coachs;

import org.springframework.stereotype.Component;

@Component
public class CoachPetanque implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Tu tires ou tu pointes ?";
    }
}
