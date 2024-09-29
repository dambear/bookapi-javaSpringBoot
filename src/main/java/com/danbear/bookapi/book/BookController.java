package com.danbear.bookapi.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/books")
public class BookController {

  private final BookRepository bookRepository;

  public BookController(BookRepository bookRepository){
    this.bookRepository = bookRepository;
  }

  @GetMapping(path = "")
  List<Book> findAll(){
    return bookRepository.findAll();
  }

  @GetMapping(path = "/{id}")
  Book findById(@PathVariable Integer id){

    Optional<Book> book = bookRepository.findById(id);

    if(book.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
    }
    return book.get();
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = "")
  void create(@RequestBody Book book){
    bookRepository.create(book);
  }


  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{id}")
  void update(@RequestBody Book book, @PathVariable Integer id) {
    bookRepository.update(book,id);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  void delete(@PathVariable Integer id) {
    bookRepository.delete(id);
  }

  @GetMapping(path = "/hello")
  public String createBooks() {
    return "Hello Danbear";
  }

}
