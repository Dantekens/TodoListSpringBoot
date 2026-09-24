package com.example.start;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> bookList;

    public BookService(){
        bookList = new ArrayList<>();
    }

    public Book BookGetByISBN(Long id){
        Optional<Book> tempBook = bookList.stream().filter((Book book)-> {return book.Id() == id;}).findAny();
        if(tempBook.isEmpty()){
            throw new IllegalArgumentException("Dont book is ID: "+id);
        }
        return tempBook.get();
    }
    public List<Book> BookGet(){
        return bookList;
    }

    public void AddBook(
            Book book
    ){
        ;
        if(!bookList.stream().filter((Book booktemp) -> {return  booktemp.Id() == book.Id();}).findAny().isEmpty()){
            throw new IllegalArgumentException("Книга с ID "+ book.Id()+" Существует");
        }
        bookList.add(book);
    }

    public void AddListBook(List<Book> books){

        if(!bookList.stream().filter(
                book1 -> {return books.stream().anyMatch(
                        book2 -> { return  book1.Id().equals(book2.Id());});}).findAny().isEmpty())

        bookList.addAll(books);
    }

    public void UpdateBook(Book bookByClient){

    }
}
