package za.co.tamboer.sboottut.apple;

public class RedApplesPredicate implements ApplePredicate {

    @Override
    public Boolean test(Apple apple) {
        return "red".equals(apple.getColour());
    }

}
