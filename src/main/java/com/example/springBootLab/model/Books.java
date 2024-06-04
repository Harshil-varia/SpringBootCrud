package com.example.springBootLab.model;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;


import java.util.List;

@Component
@Entity
public class Books {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column
    private String title;

    @Column
    private String authorName;

    @Column
    private String isbn;

    public Books() {
    }


    public Books(int bookId, String title, String authorName, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
    }

    public Books(String title, String authorName, String isbn) {
        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
