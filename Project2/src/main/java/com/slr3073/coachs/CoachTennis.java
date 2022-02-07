package com.slr3073.coachs;

import org.springframework.stereotype.Component;

//On aura un bean avec une id="myCoachTennis"
@Component("myCoachTennis")
public class CoachTennis implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Jouer deux match avec Nathan";
    }
}
