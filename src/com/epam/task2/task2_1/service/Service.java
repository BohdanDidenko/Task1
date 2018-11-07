package com.epam.task2.task2_1.service;

import com.epam.task2.task2_1.model.Book;

public interface Service {
    Book[] getBooks();
    void setBooks(Book[] books);
    Book[] getBooksByTitle (String title);
    Book[] getBooksByAuthor(String author);
    Book[] getBooksByPublisher(String publisher);
    Book[] getBooksPublishedBeforeSelectedYearInclusive(int year);
    Book[] getBooksPublishedLaterThanSelectedYear(int year);
    void sortByPublisher();
    void sortByTitle();
    void sortByAuthor();
    void sortByYear();
}
