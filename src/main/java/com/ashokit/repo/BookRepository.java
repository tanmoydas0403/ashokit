package com.ashokit.repo;
import com.ashokit.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Integer>{
    public List<Book> findByBookPriceGreaterThan(Double price);
    public List<Book> findByBookPriceLessThan(Double price);
    public List<Book>findByBookPrice(Double price);
    public List<Book>findByBookName(String bookName);

    //Native SQL query
    @Query(value = "SELECT * FROM book", nativeQuery = true)
    public List<Book> getAllBooks();

    //HQL query
    @Query("from Book")
    public List<Book>getBooks();

    //HQL query in projection

    @Query("select bookName from Book")
    public List<String>getOnlyBookName();
}
