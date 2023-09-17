package hh.dof03.kirjakauppa1.model;

public class Book {
    private String title;
    private String author;
    private int year;
    private String isbn;
    private double price;

    // Constructor
    public Book(String title, String author, int year, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }
}