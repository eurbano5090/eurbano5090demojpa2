package com.openbootcamp.demojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.openbootcamp.demojpa.models.Laptop;
import com.openbootcamp.demojpa.repositories.LaptopRepository;

@SpringBootApplication
public class DemojpaApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(DemojpaApplication.class, args);
		LaptopRepository repository=context.getBean(LaptopRepository.class);
		
		Laptop laptop1= new Laptop(null,"Asus","Intel core i5",8,899.90,true);
		Laptop laptop2= new Laptop(null,"Hp","Intel core i5",8,899.90,true);
		
		repository.save(laptop1);
		repository.save(laptop2); 
		
		System.out.println("numero de laptop en base de datos " + repository.findAll().size());
		System.out.println(repository.findAll().toString());
	}

}
