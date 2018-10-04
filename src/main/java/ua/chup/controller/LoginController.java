package ua.chup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.chup.Application;
import ua.chup.model.CustomUser;
import ua.chup.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String loginPage(Model model) {
        String login = null;

        Object sc = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(sc instanceof User){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            login = user.getUsername();
        }
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }
       // model.addAttribute("agt", Application.menu.get("agt"));
        model.addAttribute("login", login);

        return "first";
    }


}
