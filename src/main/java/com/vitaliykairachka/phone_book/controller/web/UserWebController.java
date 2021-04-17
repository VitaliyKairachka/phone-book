package com.vitaliykairachka.phone_book.controller.web;

import com.vitaliykairachka.phone_book.entity.Contact;
import com.vitaliykairachka.phone_book.entity.User;
import com.vitaliykairachka.phone_book.service.ContactService;
import com.vitaliykairachka.phone_book.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserWebController {

    private final ContactService contactService;

    private final UserService userService;

    public UserWebController(ContactService contactService, UserService userService) {
        this.contactService = contactService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/usersList")
    public String UserList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "usersList";
    }

    @GetMapping("/userContacts/{id}")
    public String UserContact(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        List<Contact> contacts = contactService.getAllUserContacts(id);
        model.addAttribute("user", user);
        model.addAttribute("contacts", contacts);
        return "/userContacts";
    }

    @GetMapping("/newUser")
    public String showNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/usersList";
    }

    @PostMapping("/editUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/userContacts/" + user.getId();
    }

    @GetMapping("/editUser/{id}")
    public ModelAndView updateUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("updateUser");
        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/usersList";
    }
}
