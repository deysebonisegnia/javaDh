package com.example.meuPrimeiroProjetoSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RestController
public class MeuPrimeiroProjetoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoSpringBootApplication.class, args);
	}
 			System.out.println("oa")
	public String ola(){
		return "ola mundo";
  }

}
