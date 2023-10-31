package applicationU5.D2;

import applicationU5.D2.entities.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MenuRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(D2Application.class);

        log.info("\n" + ctx.getBean("getMenu"));
        log.info("--------------ordini-------------------");
        log.info("\n" + ctx.getBean("order1"));



            ctx.close();
        }
    }



