package applicationU5.D2.entities;


import applicationU5.D2.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Component("pizza_component")
public  class Pizza  extends MenuElement {
    private String name;
    private String tomato;
    private String mozzarella;
    private List<Topping> ingrediens;



    public Pizza(String name , int calories ,  double price){
        super(calories , price);

        this.name = name;
    this.tomato = "tomato";
    this.mozzarella = "mozzarella";
    this.ingrediens = null;

    }

    public Pizza(List<Topping> ingrediens , String name ,  int calories , double price ){
        super(calories , price);
        this.name = name;
        this.tomato = "pomodoro";
        this.mozzarella = "mozzarella";
        this.ingrediens = ingrediens;
    }

    @Override
    public String toString() {
        return "Pizza " + name + "(" + tomato + " , " + mozzarella +  (this.ingrediens == null ? "" : " , " + ingrediens) + ")         " +super.toString();
    }
}
