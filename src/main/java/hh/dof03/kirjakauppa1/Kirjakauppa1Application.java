package hh.dof03.kirjakauppa1;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.dof03.kirjakauppa1.model.Book;
import hh.dof03.kirjakauppa1.model.User;
import hh.dof03.kirjakauppa1.model.Category;
import hh.dof03.kirjakauppa1.repository.BookRepository;
import hh.dof03.kirjakauppa1.repository.CategoryRepository;
import hh.dof03.kirjakauppa1.repository.UserRepository;

@SpringBootApplication
public class Kirjakauppa1Application {
	private static final Logger log = LoggerFactory.getLogger(Kirjakauppa1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Kirjakauppa1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
	return (args) -> {
	
	Category cat = 	new Category("Scifi");
		
	categoryRepository.save(cat);
	categoryRepository.save(new Category("Comedy"));
	categoryRepository.save(new Category("Fantasy"));	
		
	bookRepository.save(new Book("moi", "meikä", 2023, "620927", cat, 500000.0));
	bookRepository.save(new Book("hei", "meikä", 2023, "730967", cat, 800000.0));
	bookRepository.save(new Book("hehelol", "meikä", 2023, "126539", cat, 900000.0));
	
	User user1 = new User("user", "$2a$10$.CauDJ8bt1K5SD2U9w8FVejvkASHsetuT544c.nf4Erv2/ozzbsHy", "USER", "haha@jeemail.com");
	User user2 = new User("admin", "$2a$10$G.LlviNVH7u0UVQK1baf1eRrpJlQXFd6Bl.DGMRpLF2HYDNJnwdtu", "ADMIN", "hihi@jeemail.com");
	userRepository.save(user1);
	userRepository.save(user2);
	
	log.info("fetch");
	for(Category category : categoryRepository.findAll()) {
		log.info(category.toString());
	}
	
	};
	}

	
}
