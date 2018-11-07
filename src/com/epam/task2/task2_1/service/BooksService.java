package com.epam.task2.task2_1.service;

import com.epam.task2.task2_1.model.Book;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс BooksService предоставляет данные и реагирует на команды контроллера,
 * изменяя своё состояние
 */

public class BooksService implements Service {

    /**
     * Поле хранящие массив объектов класса Book
     */
    private Book[] books;

    /**
     * Поле Comparator сортирующий объекты класс Book по их издательству
     * в алфавитном порядке
     */
    private Comparator<Book> comparatorByPublisher = (o1, o2) -> o1.getPublisher().compareTo(o2.getPublisher());

    /**
     * Поле Comparator сортирующий объекты класс Book по их названию
     * в алфавитном порядке
     */
    private Comparator<Book> comparatorByTitle = (o1, o2) -> o1.getTitle().compareTo(o2.getTitle());

    /**
     * Поле Comparator сортирующий объекты класс Book по их автору
     * в алфавитном порядке
     */
    private Comparator<Book> comparatorByAuthor = (o1, o2)-> o1.getAuthor().compareTo(o2.getAuthor());

    /**
     * Поле Comparator сортирующий объекты класс Book по их году издания
     */
    private Comparator<Book> comparatorByYear = (o1, o2)-> o1.getYear() - (o2.getYear());

    /**
     * Метод возвращает ссылку на массив Book
     *
     * @return books - массив объектов класса Book
     */
    @Override
    public Book[] getBooks() { return books; }

    /**
     * Метод устанавливает значение переменной Book
     *
     * @param books - массив объектов класса Book
     */
    @Override
    public void setBooks(Book[] books) { this.books = books; }

    /**
     * Метод возвращает массив объектов класса Book, у которых название
     * соответствует полученному запросу от пользователя
     *
     * @param title - запрос пользователя
     * @return Book[] - список книг соответствующих запросу
     */
    @Override
    public Book[] getBooksByTitle (String title) {
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals(title))
                temp[counter++] = books[i];
        }
        return Arrays.copyOf(temp, counter);
    }

    /**
     * Метод возвращает массив объектов класса Book, у которых автор
     * соответствует полученному запросу от пользователя
     *
     * @param author - запрос пользователя
     * @return Book[] - список книг соответствующих запросу
     */
    @Override
    public Book[] getBooksByAuthor(String author) {
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthor().equals(author))
                temp[counter++] = books[i];
        }
        return Arrays.copyOf(temp, counter);
    }

    /**
     * Метод возвращает массив объектов класса Book, у которых издательство
     * соответствует полученному запросу от пользователя
     *
     * @param publisher - запрос пользователя
     * @return Book[] - список книг соответствующих запросу
     */
    @Override
    public Book[] getBooksByPublisher(String publisher) {
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getPublisher().equals(publisher))
                temp[counter++] = books[i];
        }
        return Arrays.copyOf(temp, counter);
    }

    /**
     * Метод возвращает массив объектов класса Book, у которых год издания
     * раньше или равен полученному запросу от пользователя
     *
     * @param year - год издания
     * @return Book[] - список книг соответствующих запросу
     */
    @Override
    public Book[] getBooksPublishedBeforeSelectedYearInclusive(int year){
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if(books[i].getYear() <= year)
                temp[counter++] = books[i];
        }
        return Arrays.copyOf(temp, counter);
    }

    /**
     * Метод возвращает массив объектов класса Book, у которых год издания
     * позже полученного запроса от пользователя
     *
     * @param year - год издания
     * @return Book[] - список книг соответствующих запросу
     */
    @Override
    public Book[] getBooksPublishedLaterThanSelectedYear(int year){
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if(books[i].getYear() > year)
                temp[counter++] = books[i];
        }
        return Arrays.copyOf(temp, counter);
    }

    @Override
    public void sortByPublisher() {
        sort(comparatorByPublisher);
    }

    @Override
    public void sortByTitle() {
        sort(comparatorByTitle);
    }

    @Override
    public void sortByAuthor() {
        sort(comparatorByAuthor);
    }

    @Override
    public void sortByYear() {
        sort(comparatorByYear);
    }

    /**
     * Метод отвечающий за сортировку данных в массиве books
     *
     * @param comparator - объект описывающий правила сортировки
     */
    private void sort(Comparator<Book> comparator){ Arrays.sort(books, comparator); }
}