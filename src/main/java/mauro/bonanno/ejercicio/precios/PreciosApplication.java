package mauro.bonanno.ejercicio.precios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"mauro.bonanno.ejercicio.precios.domain.usecase.impl", "mauro.bonanno.ejercicio.precios.application.controller"})
@EntityScan("mauro.bonanno.ejercicio.precios.domain.model")
public class PreciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreciosApplication.class, args);
	}

}
