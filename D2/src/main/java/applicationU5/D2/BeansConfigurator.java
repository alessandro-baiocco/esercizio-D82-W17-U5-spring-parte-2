package applicationU5.D2;


import applicationU5.D2.drinks.Lemonade;
import applicationU5.D2.entities.MenuElement;
import applicationU5.D2.entities.Order;
import applicationU5.D2.entities.Table;
import applicationU5.D2.enums.OrderStatus;
import applicationU5.D2.enums.TableStatus;
import applicationU5.D2.pizzas.Margerita;
import applicationU5.D2.pizzas.PizzaSalami;
import applicationU5.D2.toppings.Mozzarella;
import applicationU5.D2.toppings.Pomodoro;
import applicationU5.D2.toppings.Salame;
import applicationU5.D2.toppings.Topping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Configuration
public class BeansConfigurator {
    Random rnd = new Random();


    @Bean
    public OrderStatus returnInCorso(){
        return OrderStatus.INCORSO;
    }

    @Bean
    public TableStatus returnOccupato(){
        return TableStatus.OCCUPATO;
    }

@Bean
public int returnTablePosts(){
    return rnd.nextInt(4 , 20);
}


    @Bean
    @Value("true")
    public boolean returnTrue(){
        return true;
    }

    @Bean
    @Value("false")
   public boolean returnFalse(){
        return false;
    }


    @Bean
    @Value("false")
  public  Margerita margherita(boolean xl) {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Mozzarella("mozzarella"));
        toppings.add(new Pomodoro("pomodoro"));
        double price = xl ? 7.00 : 6.00;

        return new Margerita(1000 , price ,"margerita", toppings ,  xl);
    }


    @Bean
    @Value("true")
    public Margerita margheritaXL(boolean xl) {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Mozzarella("mozzarella"));
        toppings.add(new Pomodoro("pomodoro"));
        double price = xl ? 7.00 : 6.00;

        return new Margerita(1000 , price ,"margerita", toppings ,  xl);
    }

    @Bean
    public  PizzaSalami pizzasalami() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Mozzarella("mozzarella"));
        toppings.add(new Pomodoro("pomodoro"));
        toppings.add(new Salame("salame"));

        return new PizzaSalami(1050 , 7.00 ,"salame", toppings ,false );
    }

    @Bean
    @Value("false")
    public Lemonade lemonade(boolean big){
        double price = big ? 3.00 : 2.00;
        double quantity = big ? 1.25 : 0.75;
        return new Lemonade(200 , price , "lemonade" ,  quantity);


    }
    @Bean
    @Value("true")
    public Lemonade lemonadeBig(boolean big){
        double price = big ? 3.00 : 2.00;
        double quantity = big ? 1.25 : 0.75;
        int calories = big? 250 : 200;
        return new Lemonade(calories , price , "lemonade" ,  quantity);


    }



    @Bean(name = "getMenu")
    public List<MenuElement> getMenu(){
        List<MenuElement> menu = new ArrayList<>();
        menu.add(margherita(returnFalse()));
        menu.add(margheritaXL(returnTrue()));
        menu.add(pizzasalami());
        menu.add(lemonade(returnFalse()));
        menu.add(lemonadeBig(returnTrue()));
        return menu;
    }


    @Bean(name = "table10")
    public Table getTable10(){
        return new Table(10 , TableStatus.OCCUPATO , 20);
    }

    @Bean
    public List<MenuElement> order1(){
        List<MenuElement> ordine1 = new ArrayList<>();
        ordine1.add(margheritaXL(returnTrue()));
        ordine1.add(lemonade(returnFalse()));
        return ordine1;
    }


    @Bean(name = "totalOrder1")
    public double orderTotal(){
       return order1().stream().mapToDouble(MenuElement::getPrice).sum();
    }

    @Bean(name = "order1")
    public Order getOrder1(){


        return new Order(order1(), getTable10() , OrderStatus.INCORSO , orderTotal());
    }











}
