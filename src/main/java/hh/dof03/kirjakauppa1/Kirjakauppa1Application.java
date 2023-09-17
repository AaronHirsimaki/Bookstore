package hh.dof03.kirjakauppa1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.dof03.kirjakauppa1.model.Book;
import hh.dof03.kirjakauppa1.repository.BookRepository;

@SpringBootApplication
public class Kirjakauppa1Application {

	public static void main(String[] args) {
		SpringApplication.run(Kirjakauppa1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
	repository.save(new Book("moi", "meikä", 2023, "620927", 500000.0));
	repository.save(new Book("hei", "meikä", 2023, "730967", 800000.0));
	repository.save(new Book("hehelol", "meikä", 2023, "126539", 900000.0));
	};
	}

}
