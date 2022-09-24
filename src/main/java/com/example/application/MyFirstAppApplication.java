package com.example.application;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.application.dao.CategoryRepository;
import com.example.application.dao.ProductRepository;
import com.example.application.entities.Category;
import com.example.application.entities.Product;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication

public class MyFirstAppApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository; 
	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MyFirstAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		categoryRepository.save(new Category(null, "Computers", null, null));
		categoryRepository.save(new Category(null, "Imprimantes", null, null));
		categoryRepository.save(new Category(null, "SmartPhones", null, null));
		Random rnd = new Random();
		
		categoryRepository.findAll().forEach(c->{
			for (int i=0; i<10 ; i++)
			{			Product p= new Product(); 
			p.setName(RandomString.make(18));
			p.setCurrentprice(100+rnd.nextInt(10000));
			p.setAvalaible(rnd.nextBoolean());
			p.setPromotion(rnd.nextBoolean());
			p.setCategory(c);
			productRepository.save(p);}
		});
		
	}

}
