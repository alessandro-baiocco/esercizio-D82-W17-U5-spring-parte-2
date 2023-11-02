package applicationU5.D2.toppings;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Topping  {
    private String name;
    private double price = 0.50;

    @Override
    public String toString() {
        return " " + name + " ";
    }

    public Topping(String name) {
        this.name = name;
    }
}
