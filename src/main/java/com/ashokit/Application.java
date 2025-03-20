package com.ashokit;

import com.ashokit.entity.Book;
import com.ashokit.repo.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctxt = SpringApplication.run(Application.class, args);
		BookRepository repo = ctxt.getBean(BookRepository.class);
		Book b1=new Book();
		b1.setBookId(101);
		b1.setBookName("Java");
		b1.setBookPrice(100.00);

		Book b2=new Book();
		b2.setBookId(102);
		b2.setBookName("Python");
		b2.setBookPrice(200.00);

		repo.saveAll(Arrays.asList(b1, b2));

		Book b3=new Book();
		b3.setBookId(103);
		b3.setBookName("C++");
		b3.setBookPrice(300.00);

		Book b4=new Book();
		b4.setBookId(104);
		b4.setBookName("JavaScript");
		b4.setBookPrice(400.00);

        repo.saveAll(Arrays.asList(b3, b4));

		Book b5=new Book();
		b5.setBookId(105);
		b5.setBookName("GoLang");
		b5.setBookPrice(400.00);
		repo.save(b5);

//		boolean check = repo.existsById(101);
//		System.out.println("Book is Present? "+check);
//		long count = repo.count();
//		System.out.println("How Many book is present:: "+count);
//
//		Optional<Book> findById = repo.findById(101);
//		if(findById.isPresent()){
//			System.out.println("FindById"+findById);
//		}
//
//		System.out.println("Find All By Id: ");
//		Iterable<Book> findAllById = repo.findAllById(Arrays.asList(102, 103, 104));
//		findAllById.forEach(System.out::println);
//
//		System.out.println("Find All: ");
//		Iterable<Book> findAll = repo.findAll();
//		findAll.forEach(System.out::println);

//		Book b1=new Book();
//		b1.setBookId(101);
//		repo.delete(b1);
//
//		Book b2=new Book();
//		b2.setBookId(102);
//		Book b3=new Book();
//		b3.setBookId(103);
//		repo.deleteAll(Arrays.asList(b2,b3));
//
//		if(repo.existsById(102)){
//			repo.deleteById(102);
//		}else{
//			System.out.println("Record not found");
//		}
//
//		repo.deleteAllById(Arrays.asList(102,103));
//		repo.deleteAll();


//		System.out.println("-----------Greater Than-------------------");
//		List<Book> byBookPriceGreaterThan = repo.findByBookPriceGreaterThan(200.00);
//		byBookPriceGreaterThan.forEach(System.out::println);
//
//		System.out.println("-----------Less Than----------------");
//		List<Book> byBookPriceLessThan = repo.findByBookPriceLessThan(300.00);
//		byBookPriceLessThan.forEach(System.out::println);
//
//		System.out.println("-----------Equal To------------------------");
//		List<Book> byBookPrice = repo.findByBookPrice(400.00);
//		if(!byBookPrice.isEmpty()){
//			byBookPrice.forEach(System.out::println);
//		}else {
//			System.out.println("No books found with given price");
//		}
//
//		System.out.println("-----------Book Name----------------");
//		List<Book> findByBookName = repo.findByBookName("Java");
//		if(!findByBookName.isEmpty()){
//			findByBookName.forEach(System.out::println);
//		}else{
//			System.out.println("No books found with given name");
//		}


		System.out.println("-----------Use custom Query------------------------");
		System.out.println("-----------Native SQL Query---------------------");
		List<Book> allBooks = repo.getAllBooks();
		allBooks.forEach(System.out::println);

		System.out.println("-----------HQL Query-----------------");
		List<Book> getBooks = repo.getBooks();
		getBooks.forEach(System.out::println);

		System.out.println("-----------HQL Query Projection concept-----------------");
		List<String> bookNames = repo.getOnlyBookName();
		bookNames.forEach(System.out::println);


	}

}
