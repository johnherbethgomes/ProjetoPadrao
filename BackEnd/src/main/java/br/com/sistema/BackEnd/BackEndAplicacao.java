package br.com.sistema.BackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BackEndAplicacao {
	public static void main(String[] args) {
		SpringApplication.run(BackEndAplicacao.class, args);
		System.out.println("Aplicação Rodando Normal");
	}

}
