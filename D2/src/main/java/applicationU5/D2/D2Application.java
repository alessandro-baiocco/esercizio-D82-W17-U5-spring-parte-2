package applicationU5.D2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class D2Application {

	public static void main(String[] args) {
		SpringApplication.run(D2Application.class, args);


//		configMenu();

	}



	public static void configMenu(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(D2Application.class);

		log.info("\n" + ctx.getBean("getMenu"));



		ctx.close();
	}

}
