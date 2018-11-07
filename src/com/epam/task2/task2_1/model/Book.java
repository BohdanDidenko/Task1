package com.epam.task2.task2_1.model;

/**
 * Класс описывающий строение книги
 */

public class Book {

    /**
     * Поле с названием книги
     */
    private String title;

    /**
     *Поле с именем автора
     */
    private String author;

    /**
     *Поле с названием издательства
     */
    private String publisher;

    /**
     * Поле с годом издания
     */
    private int year;

    /**
     * Поле с количеством страниц в книге
     */
    private int pages;

    /**
     * Поле с ценой книги
     */
    private double price;

    /**
     * Конструктор построения объекта по умолчанию
     */
    public Book() {
    }

    /**
     * Конструктор построения объекта инициализирующий
     * его поля значениями полученными в параметрах.
     *
     * @param title - название книги
     * @param author - имя автора
     * @param publisher - название издательства
     * @param year - год издания
     * @param pages - количество страниц
     * @param price - цена книги
     */
    public Book (String title, String author, String publisher, int year, int pages, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }

    /**
     * Метод возвращающий значение поля title
     *
     * @return title - название книги
     */
    public String getTitle() {
        return title;
    }

    /**
     * Метод устанавливающий значение поля title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Метод возвращающий значение поля author
     *
     * @return author - автор книги
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Метод устанавливающий значение поля author
     */

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Метод возвращающий значение поля publisher
     *
     * @return publisher - название издательства
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Метод устанавливающий значение поля publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Метод возвращающий значение поля year
     *
     * @return year - год издания
     */
    public int getYear() {
        return year;
    }

    /**
     * Метод устанавливающий значение поля year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Метод возвращающий значение поля pages
     *
     * @return pages - количества страниц
     */
    public int getPages() {
        return pages;
    }

    /**
     * Метод устанавливающий значение поля pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * Метод возвращающий значение поля price
     *
     * @return price - цена книги
     */
    public double getPrice() {
        return price;
    }

    /**
     * Метод устанавливающий значение поля price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Метод сравнения объектов
     *
     * @param o - объект для сравнения
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (pages != book.pages) return false;
        if (Double.compare(book.price, price) != 0) return false;
        if (!title.equals(book.title)) return false;
        if (!author.equals(book.author)) return false;
        return publisher.equals(book.publisher);
    }

    /**
     * Метод генерации hashCode
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + year;
        result = 31 * result + pages;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Метод отображения объекта в консоли
     *
     * @return result - имя объекта и значение всех его полей
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
}