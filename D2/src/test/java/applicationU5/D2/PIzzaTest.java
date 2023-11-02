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

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PIzzaTest {
    Random rnd = new Random();



        OrderStatus returnInCorso(){
            return OrderStatus.INCORSO;
        }


        TableStatus returnOccupato(){
            return TableStatus.OCCUPATO;
        }


        int returnTablePosts(){
            return rnd.nextInt(4 , 20);
        }



        @Value("true")
        boolean returnTrue(){
            return true;
        }


        @Value("false")
        boolean returnFalse(){
            return false;
        }



        @Value("false")
        Margerita margherita(boolean xl) {
            List<Topping> toppings = new ArrayList<>();
            toppings.add(new Mozzarella("mozzarella"));
            toppings.add(new Pomodoro("pomodoro"));
            double price = xl ? 7.00 : 6.00;

            return new Margerita(1000 , price ,"margerita", toppings ,  xl);
        }


        @Value("true")
        Margerita margheritaXL(boolean xl) {
            List<Topping> toppings = new ArrayList<>();
            toppings.add(new Mozzarella("mozzarella"));
            toppings.add(new Pomodoro("pomodoro"));
            double price = xl ? 7.00 : 6.00;

            return new Margerita(1000 , price ,"margerita", toppings ,  xl);
        }


        PizzaSalami pizzasalami() {
            List<Topping> toppings = new ArrayList<>();
            toppings.add(new Mozzarella("mozzarella"));
            toppings.add(new Pomodoro("pomodoro"));
            toppings.add(new Salame("salame"));

            return new PizzaSalami(1050 , 7.00 ,"salame", toppings ,false );
        }


        @Value("false")
        Lemonade lemonade(boolean big){
            double price = big ? 3.00 : 2.00;
            double quantity = big ? 1.25 : 0.75;
            return new Lemonade(200 , price , "lemonade" ,  quantity);


        }

        @Value("true")
        Lemonade lemonadeBig(boolean big){
            double price = big ? 3.00 : 2.00;
            double quantity = big ? 1.25 : 0.75;
            int calories = big? 250 : 200;
            return new Lemonade(calories , price , "lemonade" ,  quantity);


        }




        List<MenuElement> getMenu(){
            List<MenuElement> menu = new ArrayList<>();
            menu.add(margherita(returnFalse()));
            menu.add(margheritaXL(returnTrue()));
            menu.add(pizzasalami());
            menu.add(lemonade(returnFalse()));
            menu.add(lemonadeBig(returnTrue()));
            return menu;

        }




    Table getTable10(){
        return new Table(10 , TableStatus.OCCUPATO , 20);
    }


    List<MenuElement> order1(){
        List<MenuElement> ordine1 = new ArrayList<>();
        ordine1.add(margheritaXL(returnTrue()));
        ordine1.add(lemonade(returnFalse()));
        return ordine1;
    }



 double total = order1().stream().mapToDouble(MenuElement::getPrice).sum();



    Order getOrder1(){


        return new Order(order1(), getTable10() , OrderStatus.INCORSO , total);
    }

    @ParameterizedTest
    @CsvSource({"5.5 , true"})
    void eMaggioreDiZero(double total , boolean expectedPippo){
        boolean result = total > 0;
        assertEquals(result ,expectedPippo);


    }



}
