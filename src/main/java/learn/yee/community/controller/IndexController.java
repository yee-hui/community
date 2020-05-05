package learn.yee.community.controller;

import learn.yee.community.dto.PaginationDTO;
import learn.yee.community.dto.QuestionDTO;
import learn.yee.community.mapper.UserMapper;
import learn.yee.community.model.User;
import learn.yee.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Yee
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String hello(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "2")Integer size){

        User user = (User) request.getSession().getAttribute("user");
        PaginationDTO pagination= questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
