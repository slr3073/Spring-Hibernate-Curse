package com.slr3073;

import com.slr3073.coachs.Coach;
import com.slr3073.coachs.CoachBowling;
import com.slr3073.fortunes.CrazyFortune;
import com.slr3073.fortunes.Fortune;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:slr2.properties")
public class SLRConfig2 {
    @Bean
    public Fortune crazyFortune(){
        return new CrazyFortune();
    }

    @Bean
    public Coach coachBowling(){
        return new CoachBowling(crazyFortune());
    }
}
