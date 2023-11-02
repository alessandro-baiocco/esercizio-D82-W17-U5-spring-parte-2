package applicationU5.D2;


import applicationU5.D2.toppings.Topping;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Margerita extends MenuElement implements Pizza {
    private boolean xl;
    private List<Topping> toppings;
    private String name;










    public Margerita(int calories, double price, String name , List<Topping> toppings , boolean xl) {
        super(calories, price);
        this.name = name;
        this.xl = xl;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return name + " " + (xl ? "xl " : " ") + toppings + " " + super.toString();
    }









}



