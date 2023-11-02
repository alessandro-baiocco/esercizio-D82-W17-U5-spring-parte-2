package applicationU5.D2;


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
public class Menu {
    Random rnd = new Random();


    @Bean
    OrderStatus returnInCorso(){
        return OrderStatus.INCORSO;
    }

    @Bean
    TableStatus returnOccupato(){
        return TableStatus.OCCUPATO;
    }

@Bean
int returnTablePosts(){
    return rnd.nextInt(4 , 20);
}


    @Bean
    @Value("true")
    boolean returnTrue(){
        return true;
    }

    @Bean
    @Value("false")
    boolean returnFalse(){
        return false;
    }


    @Bean
    @Value("false")
    Margerita margherita(boolean xl) {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Mozzarella("mozzarella"));
        toppings.add(new Pomodoro("pomodoro"));
        double price = xl ? 7.00 : 6.00;

        return new Margerita(1000 , price ,"margerita", toppings ,  xl);
    }

    @Bean
    @Value("true")
    Margerita margheritaXL(boolean xl) {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Mozzarella("mozzarella"));
        toppings.add(new Pomodoro("pomodoro"));
        double price = xl ? 7.00 : 6.00;

        return new Margerita(1000 , price ,"margerita", toppings ,  xl);
    }

    @Bean
    PizzaSalami pizzasalami() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Mozzarella("mozzarella"));
        toppings.add(new Pomodoro("pomodoro"));
        toppings.add(new Salame("salame"));

        return new PizzaSalami(1050 , 7.00 ,"salame", toppings ,false );
    }

    @Bean
    @Value("false")
    Lemonade lemonade(boolean big){
        double price = big ? 3.00 : 2.00;
        double quantity = big ? 1.25 : 0.75;
        return new Lemonade(200 , price , "lemonade" ,  quantity);


    }
    @Bean
    @Value("true")
    Lemonade lemonadeBig(boolean big){
        double price = big ? 3.00 : 2.00;
        double quantity = big ? 1.25 : 0.75;
        int calories = big? 250 : 200;
        return new Lemonade(calories , price , "lemonade" ,  quantity);


    }



    @Bean(name = "getMenu")
    List<MenuElement> getMenu(){
        List<MenuElement> menu = new ArrayList<>();
        menu.add(margherita(returnFalse()));
        menu.add(margheritaXL(returnTrue()));
        menu.add(pizzasalami());
        menu.add(lemonade(returnFalse()));
        menu.add(lemonadeBig(returnTrue()));
        return menu;

    }


    @Bean(name = "table10")
    Table getTable10(){
        return new Table(10 , TableStatus.OCCUPATO , 20);
    }

    @Bean
    List<MenuElement> order1(){
        List<MenuElement> ordine1 = new ArrayList<>();
        ordine1.add(margheritaXL(returnTrue()));
        ordine1.add(lemonade(returnFalse()));
        return ordine1;
    }


    @Bean(name = "totalOrder1")
    double orderTotal(){
       return order1().stream().mapToDouble(MenuElement::getPrice).sum();
    }

    @Bean(name = "order1")
    Order getOrder1(){


        return new Order(order1(), getTable10() , OrderStatus.INCORSO , orderTotal());
    }











}
