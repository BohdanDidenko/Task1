package com.epam.task2.task2_1.model;

import com.epam.task2.task2_1.model.enity.Book;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс Books предоставляет данные и реагирует на команды контроллера,
 * изменяя своё состояние
 */

public class Books {

    /**
     * Поле хранящие массив объектов класса Book
     */
    private Book[] books;

    /**
     * Поле Comparator сортирующий объекты класс Book по их издательству
     * в алфавитном порядке
     */
    private Comparator<Book> comparatorByPublisher = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getPublisher().compareTo(o2.getPublisher());
        }
    };

    /**
     * Поле Comparator сортирующий объекты класс Book по их названию
     * в алфавитном порядке
     */
    private Comparator<Book> comparatorByTitle = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };

    /**
     * Поле Comparator сортирующий объекты класс Book по их автору
     * в алфавитном порядке
     */
    private Comparator<Book> comparatorByAuthor = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    };

    /**
     * Поле Comparator сортирующий объекты класс Book по их году издания
     */
    private Comparator<Book> comparatorByYear = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getYear() - (o2.getYear());
        }
    };

    /**
     * Метод возвращает ссылку на массив Book
     *
     * @return books - массив объектов класса Book
     */
    public Book[] getBooks() {
        return books;
    }

    /**
     * Метод устанавливает значение переменной Book
     *
     * @param books - массив объектов класса Book
     */
    public void setBooks(Book[] books) {
        this.books = books;
    }

    /**
     * Метод возвращает объект класса Comparator, который сортирующий объекты класс Book
     * по их издательству в алфавитном порядке
     *
     * @return comparatorByPublisher
     */
    public Comparator<Book> getComparatorByPublisher() {
        return comparatorByPublisher;
    }

    /**
     * Метод возвращает объект класса Comparator, который сортирующий объекты класс Book
     * по их названию в алфавитном порядке
     *
     * @return comparatorByTitle
     */
    public Comparator<Book> getComparatorByTitle() {
        return comparatorByTitle;
    }

    /**
     * Метод возвращает объект класса Comparator, который сортирующий объекты класс Book
     * по их автору в алфавитном порядке
     *
     * @return comparatorByAuthor
     */
    public Comparator<Book> getComparatorByAuthor() {
        return comparatorByAuthor;
    }

    /**
     * Метод возвращает объект класса Comparator, который сортирующий объекты класс Book
     * по их году издания
     *
     * @return comparatorByYear
     */
    public Comparator<Book> getComparatorByYear() {
        return comparatorByYear;
    }

    /**
     * Метод возвращает массив объектов класса Book, у которых название
     * соответствует полученному запросу от пользователя
     *
     * @param title - запрос пользователя
     * @return Book[] - список книг соответствующих запросу
     */
    public Book[] getByTitle (String title) {
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals(title)) {
                temp[counter++] = books[i];
            }
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
    public Book[] getByAuthor(String author) {
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthor().equals(author)) {
                temp[counter++] = books[i];
            }
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
    public Book[] getByPublisher(String publisher) {
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getPublisher().equals(publisher)) {
                temp[counter++] = books[i];
            }
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
    public Book[] getPublishedBeforeSelectedYearInclusive(int year){
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
    public Book[] getPublishedLaterThanSelectedYear(int year){
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if(books[i].getYear() > year)
                temp[counter++] = books[i];
        }

        return Arrays.copyOf(temp, counter);
    }

    /**
     * Метод отвечающий за сортировку данных в массиве books
     *
     * @param comparator - объект описывающий правила сортировки
     */
    public void sort(Comparator<Book> comparator){
        Arrays.sort(books, comparator);
    }
}