package hh.dof03.kirjakauppa1;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.dof03.kirjakauppa1.model.Book;
import hh.dof03.kirjakauppa1.model.Category;
import hh.dof03.kirjakauppa1.repository.BookRepository;
import hh.dof03.kirjakauppa1.repository.CategoryRepository;

@SpringBootApplication
public class Kirjakauppa1Application {
	private static final Logger log = LoggerFactory.getLogger(Kirjakauppa1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Kirjakauppa1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
	return (args) -> {
	
	Category cat = 	new Category("Scifi");
		
	categoryRepository.save(cat);
	categoryRepository.save(new Category("Comedy"));
	categoryRepository.save(new Category("Fantasy"));	
		
	bookRepository.save(new Book("moi", "meikä", 2023, "620927", cat, 500000.0));
	bookRepository.save(new Book("hei", "meikä", 2023, "730967", cat, 800000.0));
	bookRepository.save(new Book("hehelol", "meikä", 2023, "126539", cat, 900000.0));
	
	log.info("fetch");
	for(Category category : categoryRepository.findAll()) {
		log.info(category.toString());
	}
	
	};
	}

	
}
