package com.example.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookControler {

    BookService bookService;

    private static final Logger log = LoggerFactory.getLogger(BookControler.class);

    public BookControler(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBook(){
        log.info("Запрос на получиние книг");
        return bookService.BookGet();
    }

    @GetMapping("/{id}")
    public Book getBookByIsbn(
           @PathVariable Long id
    ){
        log.info("Запрос на получение книги по ID");
        return bookService.BookGetByISBN(id);
    }

    @PostMapping()
    public void addBook(
          @RequestBody  Book book
    ){
        log.info("Запрос на добавление книги");
        bookService.AddBook(book);
    }

    @PostMapping("/list-book")
    public void addListBook(
            @RequestBody  List<Book> book
    ){
        log.info("Запрос на добавление масива книг");
        bookService.AddListBook(book);
    }
}
