package za.co.tamboer.sboottut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.tamboer.sboottut.soundsystem.CompactDisc;
import za.co.tamboer.sboottut.soundsystem.cdplayer.CDPlayer;
import za.co.tamboer.sboottut.soundsystem.compactdisc.ProsAndConsOfHitchHiking;
import za.co.tamboer.sboottut.soundsystem.compactdisc.SgtPeppers;

@Configuration
//@ComponentScan(basePackages = "za.co.tamboer.sboottut.soundsystem")
public class CDPlayerConfig {

    @Bean(name = "cd")
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc cd){
        return new CDPlayer(cd);
    }

    @Bean(name = "randomCD")
    public CompactDisc randomBeatlesCD() {
        int choice = (int) Math.floor(Math.random() * 4);
        if (choice == 0) {
            return new SgtPeppers();
        } else if (choice == 1) {
            return new ProsAndConsOfHitchHiking();
        } else if (choice == 2) {
            return new SgtPeppers();
        } else {
            return new ProsAndConsOfHitchHiking();
        }
    }
}
