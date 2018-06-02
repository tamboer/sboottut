package za.co.tamboer.sboottut.soundsystem.compactdisc;

import org.springframework.stereotype.Component;
import za.co.tamboer.sboottut.soundsystem.CompactDisc;

@Component
public class ProsAndConsOfHitchHiking implements CompactDisc {
    private String title = "Pros And Cons Of HitchHiking";
    private String artist = "Roger Waters";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}