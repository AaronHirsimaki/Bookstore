package hh.dof03.kirjakauppa1.BookController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.dof03.kirjakauppa1.model.Book;
import hh.dof03.kirjakauppa1.repository.BookRepository;
import hh.dof03.kirjakauppa1.repository.CategoryRepository;

@Controller
public class BookController {
	
	
    @GetMapping("/addbook")
    public String doAddBook(Model model) {
    	Book book = new Book();
    	model.addAttribute("book", book);
    	model.addAttribute("categorylist",categoryRepository.findAll());
        return "addBook";
    }
    
    @PostMapping("/addbook")
    public String doPostBook(Model model, @ModelAttribute("book") Book book) {
    	bookRepository.save(book);
    	model.addAttribute("booklist",bookRepository.findAll());
    	return "booklist";
    }
    
    @GetMapping("/deletebook/{id}")
    public String deleteBookById(@PathVariable String id, Model model) {
    	Book deleteBook = bookRepository.findById(Integer.parseInt(id));
    	bookRepository.delete(deleteBook);
    	model.addAttribute("booklist",bookRepository.findAll());
    	return "booklist";
    }
    
    @GetMapping("/editbook/{id}")
    public String editBookById(@PathVariable String id, Model model) {
    	Book editBook = bookRepository.findById(Integer.parseInt(id));
    	model.addAttribute("categorylist",categoryRepository.findAll());
    	model.addAttribute("book",editBook);
    	return "editBook";
    }
    
    @PostMapping("/editbook")
    public String doPostEditBook(Model model, @ModelAttribute("book") Book book) {
    	bookRepository.save(book);
    	model.addAttribute("booklist",bookRepository.findAll());
    	return "booklist";
    }
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

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
    	model.addAttribute("booklist",bookRepository.findAll());
        return "booklist";
    }
    
    
}
