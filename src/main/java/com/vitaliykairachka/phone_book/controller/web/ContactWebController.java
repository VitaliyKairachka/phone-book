package com.vitaliykairachka.phone_book.controller.web;

import com.vitaliykairachka.phone_book.entity.Contact;
import com.vitaliykairachka.phone_book.entity.User;
import com.vitaliykairachka.phone_book.service.ContactService;
import com.vitaliykairachka.phone_book.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactWebController {

    private final ContactService contactService;

    private final UserService userService;

    public ContactWebController(ContactService contactService, UserService userService) {
        this.contactService = contactService;
        this.userService = userService;
    }

    @GetMapping("/newContact/{id}")
    public String showNewContact(@PathVariable("id") int id, Model model) {
        Contact contact = new Contact();
        contact.setUser(userService.getUserById(id));
        model.addAttribute("contact", contact);
        model.addAttribute("user", userService.getUserById(id));
        return "/newContact";
    }

    @PostMapping("/saveContact/{id}")
    public String saveContact(@ModelAttribute("contact") Contact contact, @PathVariable("id") int id) {
        User user = userService.getUserById(id);
        user.addContactToUser(contact);
        userService.saveUser(user);
        return "redirect:/userContacts/" + userService.getUserById(id).getId();
    }

    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.updateContact(contact);
        return "redirect:" + contact.getUser().getId();
    }

    @GetMapping("/editContact/{idUser}/{idContact}")
    public ModelAndView updateUser(@PathVariable("idUser") int idUser, @PathVariable("idContact") int idContact,
                                   Model model) {
        ModelAndView modelAndView = new ModelAndView("/updateContact");
        Contact contact = contactService.getContactById(idContact);
        modelAndView.addObject("contact", contact);
        model.addAttribute(idUser);
        return modelAndView;
    }

    @GetMapping("/deleteContact/{id}")
    public String deleteUser(@PathVariable("id") int id, HttpServletRequest request) {
        contactService.deleteContact(id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
}
