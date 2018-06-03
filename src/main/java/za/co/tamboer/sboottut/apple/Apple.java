package za.co.tamboer.sboottut.apple;

public class Apple {

    private String colour;
    private Float weight;

    public Apple(String colour) {
        this.colour = colour;
    }

    public Apple(String colour, Float weight) {
        this.colour = colour;
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "colour='" + colour + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
