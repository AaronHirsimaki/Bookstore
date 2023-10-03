package hh.dof03.kirjakauppa1.BookController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.dof03.kirjakauppa1.model.Book;
import hh.dof03.kirjakauppa1.repository.BookRepository;

@RestController
public class BookRestController {
	
	@Autowired
	BookRepository bookrepository;
	
	@GetMapping("/book/list")
	public @ResponseBody List<Book> getBooksRest(){
		return (List<Book>) bookrepository.findAll();
		
	}
	
	@GetMapping("/book/{id}")
	public @ResponseBody Book getBooksByIdRest(@PathVariable String id){
		return bookrepository.findById(Integer.parseInt(id));
	}
	
}
