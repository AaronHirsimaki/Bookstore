package hh.dof03.kirjakauppa1.BookController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.dof03.kirjakauppa1.model.Category;
import hh.dof03.kirjakauppa1.repository.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;

    @GetMapping("/categorylist")
    public String doCategoryList(Model model) {
    	model.addAttribute("categorylist",categoryRepository.findAll());
        return "categorylist";
    }
	
    @GetMapping("/addcategory")
    public String doAddCategory(Model model) {
    	Category category = new Category();
    	model.addAttribute("category", category);
        return "addcategory";
    }
    
    @PostMapping("/addcategory")
    public String doPostCategory(Model model, @ModelAttribute("category") Category category) {
    	categoryRepository.save(category);
    	model.addAttribute("categorylist",categoryRepository.findAll());
    	return "categorylist";
    }
}
