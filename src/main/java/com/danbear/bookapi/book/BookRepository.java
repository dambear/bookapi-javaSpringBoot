package com.danbear.bookapi.book;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class BookRepository {
  private List<Book> books = new ArrayList<Book>();

  List<Book> findAll(){
    return books;
  }

  Optional <Book> findById(Integer id){
    return books.stream()
        .filter(book -> book.id() == id)
        .findFirst();
  }

void create (Book book){
    books.add(book);
}

void update (Book book, Integer id) {
    Optional <Book> existingbook = findById(id);
    if (existingbook.isPresent()) {

      int index = books.indexOf(existingbook.get());
      books.set(index, book);
    }
}

void delete (Integer id) {
    books.removeIf(book -> book.id() == id);
}

  @PostConstruct
  public void init(){
    books.add(new Book(
        1,
        "Danbear 101 Book",
        "Danbear",
        "Tech",
        "2024"
        ));

    books.add(new Book(
        2,
        "Danbear 102 Book",
        "Danbear",
        "Tech",
        "2025"
    ));
  }
}
