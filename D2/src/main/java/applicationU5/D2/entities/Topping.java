package applicationU5.D2.entities;

import applicationU5.D2.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Topping extends MenuElement {
    private String name;
    private double price = 0.50;

    @Override
    public String toString() {
        return " " + name + " " ;
    }

    public Topping(String name , int calories , double price) {
        super(calories, price);
        this.name = name;
    }
}
