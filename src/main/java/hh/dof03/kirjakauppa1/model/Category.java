package hh.dof03.kirjakauppa1.model;

import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
public class Category {
	
	public Category() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	private String categoryName;
	private String book;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	

	public int getCategoryId() {
		return categoryId;
	}
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public List<Book> getBook() {
		return books;
	}

	public void setBook(List<Book> books) {
		this.books = books;
	}

}
