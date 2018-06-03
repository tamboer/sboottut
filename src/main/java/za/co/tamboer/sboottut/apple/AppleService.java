package za.co.tamboer.sboottut.apple;

import java.util.List;
import java.util.function.Predicate;

public interface AppleService {


    public void addToInventory(List<Apple> apples);
    public void sortApples(Predicate predicate);
    public Apples getInventory();



}
