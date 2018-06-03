package za.co.tamboer.sboottut.apple;

import java.util.List;
import java.util.function.Predicate;

public class AppleServiceImpl implements AppleService {

    Apples inventory = new Apples();

    @Override
    public void addToInventory(List<Apple> apples) {
        inventory = new Apples(apples);
    }

    @Override
    public void sortApples(Predicate predicate) {

    }

    @Override
    public Apples getInventory() {
        return inventory;
    }
}
