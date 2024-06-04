package com.example.springBootLab.controller;

import com.example.springBootLab.model.Books;
import com.example.springBootLab.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;




    @PostMapping(path = "/addBook")
    public String createBook(@RequestBody Books Book) {
        return bookService.createBook(Book);

    }

    @GetMapping(path="allBook")
    public ResponseEntity<List<Books>> getAllBooks() {
        List<Books> books = bookService.fetchAllBooks();
        return ResponseEntity.ok(books);
    }


    @GetMapping(path="reqId/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable("id") int id) {
        Books books = bookService.getBookById(id).orElse(null);
        return ResponseEntity.ok(books);
    }

    @PutMapping(path="/update")
    public String updateBook(@RequestBody Books book) {
        return  bookService.updateBook(book);
    }

    @DeleteMapping (path="/delete/{id}")
    public void deleteBook(@PathVariable("id") int id) {
         bookService.deleteBook(id);
    }

}
