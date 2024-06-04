package com.example.springBootLab.service;

import com.example.springBootLab.model.Books;

import java.util.List;
import java.util.Optional;

public interface BookService {

    String createBook(Books book);

    List<Books> fetchAllBooks();



    Optional<Books> getBookById(int id);


    String updateBook(Books book);

    void deleteBook(int id);
}
