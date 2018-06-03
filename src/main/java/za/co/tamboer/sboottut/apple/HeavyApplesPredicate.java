package za.co.tamboer.sboottut.apple;

public class HeavyApplesPredicate implements ApplePredicate {

    @Override
    public Boolean test(Apple apple) {
        if (apple.getWeight() != null){

            return 150 < apple.getWeight();
        }else {
            return false;
        }


    }

}
