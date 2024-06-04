package com.example.springBootLab.service.Implementation;

import com.example.springBootLab.model.Books;
import com.example.springBootLab.repository.BookRepository;
import com.example.springBootLab.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository booksRepository;

    @Override
    public String createBook(Books book){
        booksRepository.save(book);
        return "Customer Successfully Created";

    }

    @Override
    public List<Books> fetchAllBooks() {
        return (List<Books>) booksRepository.findAll();
    }



    @Override
    public Optional<Books>  getBookById(int id) {
        return booksRepository.findById(id);
    }

    @Override
    public String updateBook(Books bookDetails) {
        Optional<Books> tempBook = booksRepository.findById(bookDetails.getBookId());
        if (tempBook.isPresent()) {
            Books book1 = booksRepository.getById(bookDetails.getBookId());
            book1.setIsbn(bookDetails.getIsbn());
            book1.setTitle(bookDetails.getTitle());
            book1.setAuthorName(bookDetails.getAuthorName());
            booksRepository.save(book1);
            return "Customer information updated successfully!";
        } else {
            return "Customer not found!";
        }
    }

    @Override
    public void deleteBook(int id) {
        booksRepository.deleteById(id);
    }

}
