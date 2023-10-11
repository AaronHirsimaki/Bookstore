package hh.dof03.kirjakauppa1.repository;

import org.springframework.data.repository.CrudRepository;

import hh.dof03.kirjakauppa1.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
	
