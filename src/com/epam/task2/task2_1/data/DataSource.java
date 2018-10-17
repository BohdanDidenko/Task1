package com.epam.task2.task2_1.data;

import com.epam.task2.task2_1.model.enity.Book;

/**
 * Класс предоставляет массив объектов типа Book
 */

public class DataSource {

    /**
     * Метод возвращает массив объектов типа Book инициализированных
     * данными по умолчанию
     *
     * @return Book[] - массив объектов типа Book
     */
    public static Book[] getBooks() {
        return new Book[] {
                new Book("Little Prince", "Saint-Exupery",
                        "Wordsworth", 2010, 112, 220.0),
                new Book("Alice in Wonderland & Through the Looking Glass", "Carroll L.",
                        "Wordsworth", 2000, 272, 250.0),
                new Book("Matilda", "Dahl R.",
                        "Penguin USA", 1999, 240, 550.0),
                new Book("Alice in Wonderland and Through the Looking Glass", "Carroll L.",
                        "Random House USA", 2016, 234, 380.5),
                new Book("Create Your Own Monster", "Chuck Whelon",
                        "Harper Collins UK", 2011, 50, 855.5),
                new Book("Fairy Tales", "Grimm",
                        "Wordsworth", 2001, 272, 300.0),
                new Book("Diary of a Wimpy Kid 08: Hard Luck", "Kinney J.",
                        "Hachette US", 2018, 254, 560.5),
                new Book("The Tales of Beedle the Bard", "Rowling, J.",
                        "Penguin USA", 2013, 144, 100.0),
        };
    }
}
