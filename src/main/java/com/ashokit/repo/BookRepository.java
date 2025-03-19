package com.ashokit.repo;
import com.ashokit.entity.Book;
import org.springframework.data.repository.CrudRepository;
public interface BookRepository extends CrudRepository<Book,Integer>{
}
