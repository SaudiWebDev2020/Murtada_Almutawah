package com.mamutawah.bookapi.controllers;

import java.util.List;

import javax.validation.Valid;

import com.mamutawah.bookapi.models.Book;
import com.mamutawah.bookapi.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BooksController {
  private final BookService bookService;

  public BooksController(BookService bookService) {
    this.bookService = bookService;
  }

  @RequestMapping("/books")
  public String index(Model model) {
    List<Book> books = bookService.allBooks();
    model.addAttribute("books", books);
    return "/books/index.jsp";
  }

  @RequestMapping("/books/new")
  public String newBook(@ModelAttribute("book") Book book) {
    return "/books/new.jsp";
  }

  @RequestMapping(value = "/books", method = RequestMethod.POST)
  public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    if (result.hasErrors()) {
      return "/books/new.jsp";
    } else {
      bookService.createBook(book);
      return "redirect:/books";
    }
  }

  @RequestMapping("/books/{id}")
  public String view(Model model, @PathVariable("id") Long id) {
    if (bookService.findBook(id) == null) {
      return "redirect:/books";
    }
    Book book = bookService.findBook(id);
    model.addAttribute("book", book);
    return "/books/show.jsp";
  }

  @RequestMapping("/books/{id}/edit")
  public String edit(Model model, @PathVariable("id") Long id) {
    if (bookService.findBook(id) == null) {
      return "redirect:/books";
    }
    Book book = bookService.findBook(id);
    model.addAttribute("book", book);
    return "/books/edit.jsp";
  }

  @RequestMapping(value = "/books/{id}/edit", method = RequestMethod.PUT)
  public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
    System.out.println(book);
    System.out.println(book.getId());
    if (result.hasErrors()) {
      return "/books/edit.jsp";
    } else {
      bookService.updateBook(book);
      return "redirect:/books";
    }
  }

  @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
  public String delete(@PathVariable("id") Long id) {
    bookService.deleteBook(id);
    return "redirect:/books";
  }

}
