package za.co.tamboer.sboottut.apple;

import java.util.Arrays;
import java.util.List;

public class AppleFixtures {

    public List<Apple> createAppleList() {
        Apple redApple = new Apple("red");
        Apple greenApple = new Apple("green");
        greenApple.setWeight(151.0f);
        Apple yellowApple = new Apple("yellow");
        Apple toffeeApple = new Apple("brown");

        return Arrays.asList(redApple,greenApple,yellowApple,toffeeApple);
    }


}
