package hh.dof03.kirjakauppa1.BookController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import hh.dof03.kirjakauppa1.model.Book;
import hh.dof03.kirjakauppa1.repository.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;

    @RequestMapping("/")
    public String sayHello() {
        return "Hello Spring!";
    }

    @GetMapping("/index")
    public String doHello() {
        return "Hello index";
    }

    @GetMapping("/booklist")
    public String doBooklist(Model model) {
    	//Iterable<Book> booklist = repository.findAll();
    	
    	model.addAttribute("booklist",bookRepository.findAll());
        return "booklist";
    }
    
    
}
