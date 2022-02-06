package com.slr3073.apps;

import com.slr3073.coach.Coach;
import com.slr3073.coach.CoachFoot;

public class Application {

    public static void main(String[] args) {
        Coach coach = new CoachFoot(null); //null pour ne pas casser avec l'ex 2
        System.out.println(coach.getDailyTraining());
    }
}
