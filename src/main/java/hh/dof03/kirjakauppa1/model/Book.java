package hh.dof03.kirjakauppa1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne; 

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
    private String title;
    private String author;
    @Column(name = "release_year")
    private int year;
    private String isbn;
    
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    

	@Override
	public String toString() {
		if(category != null) {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn="
				+ isbn + ", category=" + category.getCategoryName() + ", price=" + price + "]";
		}else {
			return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn="
					+ isbn + ", price=" + price + "]";
		}
	}

	public Book(String title, String author, int year, String isbn, Category category, double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.category = category;
		this.price = price;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private double price;

    // Constructor
    public Book(String title, String author, int year, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }
    
    public Book() {
    	
    }
    
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
