package za.co.tamboer.sboottut.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.tamboer.sboottut.soundsystem.compactdisc.CompactDisc;

import static org.junit.Assert.assertNotNull;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {
    @Autowired
    private CompactDisc cd;
    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }
}