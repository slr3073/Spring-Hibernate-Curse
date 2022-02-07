package com.slr3073.coachs;

import com.slr3073.fortunes.Fortune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class CoachPetanque implements Coach {
    private Fortune fortune;

    // Injection de la dépendance dans le constructeur avec un qualifier
    @Autowired
    public CoachPetanque(@Qualifier("rdmFortune") Fortune fortune) {
        this.fortune = fortune;
    }

    @PostConstruct
    public void avantConstruct(){
        System.out.println("faire des choses juste après la construction du bean");
    }

    @PreDestroy
    public void avantDestruct(){
        System.out.println("faire des choses juste avant destruction du bean");
    }

    //Injection de dépendances par une méthode quelconque, c'est un setter sans le nom
    /*@Autowired
    @Qualifier("rdmFortune")
    public void jeNeSuisPasUnSetter(Fortune f){
        fortune = f;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Tu tires ou tu pointes ?";
    }

    @Override
    public String getFortune() {
        return fortune.getFortune();
    }
}
