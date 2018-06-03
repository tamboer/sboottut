package za.co.tamboer.sboottut.apple;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class AppleServiceImpl implements AppleService {

    private Apples inventory;

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
