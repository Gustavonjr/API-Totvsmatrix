package com.integracao.totvsmatrix;


import com.integracao.totvsmatrix.service.ConsultaPedidosService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TotvsmatrixApplication {

	@Bean
	public ConsultaPedidosService consultaPedidosService() {
		return new ConsultaPedidosService();
	}


	public static void main(String[] args) {
		// SpringApplication.run(TotvsmatrixApplication.class, args); // Comentado para evitar que a aplicação seja iniciada duas vezes

		ApplicationContext applicationContext = SpringApplication.run(TotvsmatrixApplication.class, args);
		ConsultaPedidosService consultaPedidosService = applicationContext.getBean(ConsultaPedidosService.class);


		consultaPedidosService.saveAll();


	}

}