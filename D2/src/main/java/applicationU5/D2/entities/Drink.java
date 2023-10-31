package applicationU5.D2.entities;


import applicationU5.D2.Menu;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Setter
@Getter
@Component
public class Drink  extends MenuElement {
    private String name;
    private double quantity;


    public Drink(String name, double quantity, int calories , double price) {
        super(calories , price);
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "bevanda " + name + " " + quantity + "L " + super.toString();
    }
}
