package za.co.tamboer.sboottut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.tamboer.sboottut.soundsystem.CompactDisc;
import za.co.tamboer.sboottut.soundsystem.cdplayer.CDPlayer;
import za.co.tamboer.sboottut.soundsystem.compactdisc.SgtPeppers;

@Configuration
//@ComponentScan(basePackages = "za.co.tamboer.sboottut.soundsystem")
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc cd){
        return new CDPlayer(cd);
    }
}
