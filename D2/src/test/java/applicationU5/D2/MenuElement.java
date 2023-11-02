package applicationU5.D2;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public abstract class MenuElement {
    private int calories;
    private double price;


    public MenuElement(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

    @Override
    public String toString() {
        return " " + calories + "cal    " + price+ "$\n";
    }
}
