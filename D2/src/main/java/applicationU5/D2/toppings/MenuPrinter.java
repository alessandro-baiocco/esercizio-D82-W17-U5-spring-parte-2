package applicationU5.D2.toppings;

import applicationU5.D2.D2Application;
import applicationU5.D2.entities.MenuElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@Order(1)
public class MenuPrinter implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(D2Application.class);



        System.out.println("--------------ordini-------------------");
        log.info("\n" + ctx.getBean("order1"));



        ctx.close();
    }
}
