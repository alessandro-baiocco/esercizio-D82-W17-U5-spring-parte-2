package applicationU5.D2;

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
@Order(0)
public class MenuCompilater implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(D2Application.class);

        List<MenuElement> menu = new ArrayList<>();
        menu.add((MenuElement) ctx.getBean("margherita"));
        menu.add((MenuElement) ctx.getBean("margheritaXL"));
        menu.add((MenuElement) ctx.getBean("pizzasalami"));
        menu.add((MenuElement) ctx.getBean("lemonade"));
        menu.add((MenuElement) ctx.getBean("lemonadeBig"));


        System.out.println(menu);

        System.out.println("--------------ordini-------------------");
        log.info("\n" + ctx.getBean("order1"));



            ctx.close();
        }
    }




