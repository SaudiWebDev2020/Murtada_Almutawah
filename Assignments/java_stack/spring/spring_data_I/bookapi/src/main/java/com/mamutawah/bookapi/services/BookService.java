package com.mamutawah.bookapi.services;

import java.util.List;

import com.mamutawah.bookapi.repositories.BookRepository;
import com.mamutawah.bookapi.models.Book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  // return all the books
  public List<Book> allBooks() {
    return bookRepository.findAll();
  }

  // create a book
  public Book createBook(Book newBook) {
    return bookRepository.save(newBook);
  }

  // View a book
  public Book findBook(long id) {
    if (bookRepository.findById(id).isPresent()) {
      return bookRepository.findById(id).get();
    }

    return null;
  }

  public Book updateBook(Long id, String title, String description, String language, int numOfPages) {
    // save is used both to create new entries and update existing
    if (bookRepository.findById(id).isPresent()) {
      Book book = bookRepository.findById(id).get();
      book.setTitle(title);
      book.setDescription(description);
      book.setLanguage(language);
      book.setNumberOfPages(numOfPages);
      return bookRepository.save(book);
    }

    return null;
  }

  public Book updateBook(Book book) {
    // save is used both to create new entries and update existing
    return this.updateBook(book.getId(), book.getTitle(), book.getDescription(), book.getLanguage(),
        book.getNumberOfPages());
  }

  public String deleteBook(Long id) {
    if (bookRepository.findById(id).isPresent()) {
      bookRepository.deleteById(id);
      return "Success";
    }

    return "No data is found to be deleted";
  }
}
