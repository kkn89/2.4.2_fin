package jm.security.example.controller;

import jm.security.example.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class 	UserController {

    @GetMapping
    public String userInfo(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("roles",user.getRoles());
        return "user-page";
    }

}