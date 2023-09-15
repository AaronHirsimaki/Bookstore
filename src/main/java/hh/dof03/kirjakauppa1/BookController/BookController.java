package hh.dof03.kirjakauppa1.BookController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


public class BookController {

    @RequestMapping("*")
    public String sayHello() {
        return "Hello Spring!";
    }

    @RequestMapping("/index")
    public String doHello() {
        return "Hello index";
    }

}
