package hh.dof03.kirjakauppa1.repository;

import org.springframework.data.repository.CrudRepository;

import hh.dof03.kirjakauppa1.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	Book findById(int id);
}
