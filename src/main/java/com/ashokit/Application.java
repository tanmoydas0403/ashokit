package com.ashokit;

import com.ashokit.entity.Book;
import com.ashokit.repo.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctxt = SpringApplication.run(Application.class, args);
		System.out.println(ctxt.getClass().getName());
		BookRepository repo = ctxt.getBean(BookRepository.class);
		System.out.println(repo.getClass().getName());
//
//		Book b=new Book();
//		b.setBookId(101);
//		b.setBookName("Java");
//		b.setBookPrice(100.25);
//		repo.save(b);
		Optional<Book> details = repo.findById(101);
		System.out.println(details.get());
	}

}
