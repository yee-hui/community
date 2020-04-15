package learn.yee.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Yee
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String hello(Model model){

        return "index";
    }
}
