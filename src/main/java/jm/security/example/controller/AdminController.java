package jm.security.example.controller;


import jm.security.example.model.User;
import jm.security.example.service.RoleService;
import jm.security.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("allUs",userService.allUsers());
        return "admin-page";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "user-info";
    }
    @PostMapping("/new")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "edit-user";
    }
    @PatchMapping("/edit/{id}")
    public String editUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
