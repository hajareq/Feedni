package ma.feedni.springproject.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value = "/")
    public String homePage(Model model){
        return "login";
    }

    @GetMapping(value = "/client/compte")
    public String compte(Model model){
        return "compte";
    }
}
