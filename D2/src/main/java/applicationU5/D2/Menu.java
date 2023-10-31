package applicationU5.D2;

import applicationU5.D2.entities.*;
import applicationU5.D2.enums.OrderStatus;
import applicationU5.D2.enums.TableStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Configuration
public class Menu {
    Random rnd = new Random();
    @Bean
    Topping getBacon() {
        return new Topping("bacon" , toppingCal() , toppingPrice());
    }

    @Bean
    Topping getHam() {
        return new Topping("prosciutto"  , toppingCal() , toppingPrice());
    }

    @Bean
    Topping getSalami() {
        return new Topping("salame"  , toppingCal() , toppingPrice());
    }

    @Bean
    Double media(){
        return 0.75;
    }

    @Bean
    Double grande(){
        return 1.50;
    }
    @Bean
    String cocaName(){
        return "cocaCola";
    }

    @Bean
    Double getPizzaPrice(){
        return rnd.nextDouble(6 , 9);
    }

    @Bean
    @Primary
    int getPizzaCalories(){
        return rnd.nextInt(1000 , 1200);
    }

    @Bean
    int getDrinkCalories(){
        return rnd.nextInt(20 , 200);
    }

    @Bean
    TableStatus occupato(){
        return TableStatus.OCCUPATO;
    }
    @Bean
    OrderStatus servito(){
        return OrderStatus.SERVITO;
    }

    @Bean
    @Primary
    double getDrinkPrice(){
       return rnd.nextDouble(1 , 3);
    }

    @Bean
    double toppingPrice(){
        return  rnd.nextDouble(0.1 , 2);
    }

    @Bean
    int toppingCal(){
        return  rnd.nextInt(1 , 30);
    }

    @Bean
    Drink cocaColaMedia(){
       return new Drink("coca cola media" , media() , getDrinkCalories(), getDrinkPrice() );
    }
    @Bean
    Drink cocaColaGrande(){
        return new Drink("coca cola grande" , grande() , getDrinkCalories() , getDrinkPrice());
    }

    @Bean
    Pizza getReMaiale() {
        List<Topping> reMai = new ArrayList<>();
        reMai.add(getBacon());
        reMai.add(getHam());
        reMai.add(getSalami());
        return new Pizza(reMai ,"re maiale" ,getPizzaCalories(), getPizzaPrice());
    }
    @Bean
    Pizza margherita() {
        return new Pizza("margherita" ,getPizzaCalories(), 6.00);
    }

@Bean
    Pizza getPizzaSalami(){
        List<Topping> salam = new ArrayList<>();
        salam.add(getSalami());
        return new Pizza(salam ,"salame" , getPizzaCalories() , getPizzaPrice());
    }








    @Bean(name = "getMenu")
    List<MenuElement> getMenu(){
        List<MenuElement> menu = new ArrayList<>();
        menu.add(getReMaiale());
        menu.add(margherita());
        menu.add(getPizzaSalami());
        menu.add(cocaColaMedia());
        menu.add(cocaColaGrande());
        menu.add(getSalami());
        menu.add(getHam());
        menu.add(getBacon());

        return menu;

    }

    @Bean(name = "defaultUser")
    Table createDefault(){
        return new Table(10 , TableStatus.OCCUPATO);
    }


    @Bean(name="order1")
    Order creaOrdinePrimo(){
        List<MenuElement> uno = new ArrayList<>();
        double total = 0;
        uno.add(getPizzaSalami());
        total += getPizzaSalami().getPrice();
        uno.add(cocaColaGrande());
        total += cocaColaGrande().getPrice();

        return new Order(uno , createDefault() , servito() , total );

    }




}
