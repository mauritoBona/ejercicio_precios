package mauro.bonanno.ejercicio.precios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({"mauro.bonanno.ejercicio.precios.domain.usecase.impl", "mauro.bonanno.ejercicio.precios.application.controller"})
@EnableJpaRepositories("mauro.bonanno.ejercicio.precios.domain.repository")
@EnableTransactionManagement
public class PreciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreciosApplication.class, args);
	}

}
