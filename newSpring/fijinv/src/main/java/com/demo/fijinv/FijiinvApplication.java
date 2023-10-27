package com.demo.fijinv;

import com.demo.fijinv.Repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FijiinvApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(com.demo.fijinv.FijiinvApplication.class, args);
	}

	@Autowired
	public ItemsRepository itemsRepository;

	@Override
	public void run(String... args) throws Exception {

	}
}
