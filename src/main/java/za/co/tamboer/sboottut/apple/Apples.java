package za.co.tamboer.sboottut.apple;

import java.util.ArrayList;
import java.util.List;

public class Apples {

    private List<Apple> apples = new ArrayList<>();

    public Apples() {
    }

    public Apples(List<Apple> apples) {
        this.apples = apples;
    }

    public void addApple(Apple apple){
        apples.add(apple);
    }

    public List<Apple> getApples() {
        return apples;
    }

    public List<Apple> filterApples(String colour){
        List<Apple> filter = new ArrayList<>();
        for (Apple apple : this.getApples()) {
            if (colour.equals(apple.getColour())){
                filter.add(apple);
            }
        }

        return filter;
    }

    public List<Apple> filterApples(ApplePredicate predicate){
        List<Apple> filter = new ArrayList<>();
        for (Apple apple : this.getApples()) {
            if (predicate.test(apple)){
                filter.add(apple);
            }
        }

        return filter;
    }
}
