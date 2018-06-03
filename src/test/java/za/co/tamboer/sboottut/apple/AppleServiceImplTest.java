package za.co.tamboer.sboottut.apple;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AppleServiceImplTest {


    private AppleService appleService;

    @Before
    public void before(){
        appleService = new AppleServiceImpl();
        List<Apple> apples = AppleFixtures.createAppleList();
        appleService.addToInventory(apples);
    }

    @Test
    public void addToInventory() {
    }

    @Test
    public void sortApples() {
    }

    @Test
    public void getInventory() {

        Apples apples = appleService.getInventory();
        assertThat(apples).isNotNull();
    }
}