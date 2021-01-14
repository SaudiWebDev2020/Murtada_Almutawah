package com.mamutawah.bookapi.controllers;

import java.util.List;

import com.mamutawah.bookapi.services.BookService;
import com.mamutawah.bookapi.models.Book;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("")
  public List<Book> index() {
    return bookService.allBooks();
  }

  @PostMapping("")
  public Book create(@RequestParam(value = "title") String title,
      @RequestParam(value = "description") String description, @RequestParam(value = "language") String language,
      @RequestParam(value = "numOfPages") int numOfPages) {
    Book newBook = new Book(title, description, language, numOfPages);

    return this.bookService.createBook(newBook);
  }

  @GetMapping("/{id}")
  public Book view(@PathVariable("id") Long id) {
    Book book = bookService.findBook(id);
    return book;
  }

  @PutMapping("/{id}")
  public Book update(@PathVariable("id") Long id, @RequestParam(value = "title") String title,
      @RequestParam(value = "description") String description, @RequestParam(value = "language") String language,
      @RequestParam(value = "numOfPages") int numOfPages) {
    Book updatedBook = bookService.updateBook(id, title, description, language, numOfPages);
    return updatedBook;
  }

  @DeleteMapping("/{id}")
  public void remove(@PathVariable("id") Long id) {
    bookService.deleteBook(id);
  }

}
