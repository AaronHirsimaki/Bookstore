package hh.dof03.kirjakauppa1.repository;

import org.springframework.data.repository.CrudRepository;

import hh.dof03.kirjakauppa1.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	Category findById(int id);
}