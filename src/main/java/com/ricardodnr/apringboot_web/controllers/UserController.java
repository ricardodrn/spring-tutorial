package com.ricardodnr.apringboot_web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ricardodnr.apringboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Ricardo", "Nain");

        model.addAttribute("title", "Hola Mundo Pichula");
        model.addAttribute("name", user.getName());
        model.addAttribute("lastname", user.getLastname());
        return "details";
    }

    @GetMapping(path = "/list")
    public String list(Model model) {
        model.addAttribute("title", "Listado de Usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        List<User> users = Arrays.asList(
            new User("Lalo", "Landa","Lalo@Landa.com"), 
            new User("Elber", "Galarga"),
            new User("Alan", "Brito","Alan@Brito.com"),
            new User("Rosamel", "Fierro"));
        return users;
    }
}
