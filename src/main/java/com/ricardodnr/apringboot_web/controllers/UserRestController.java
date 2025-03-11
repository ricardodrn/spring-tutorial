package com.ricardodnr.apringboot_web.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// import java.util.HashMap;
// import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardodnr.apringboot_web.models.User;
import com.ricardodnr.apringboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {

    
    @GetMapping("/user")
    public UserDto getUser() {
        User user = new User("Ricardo", "Nain");

        UserDto userDto = new UserDto();
        userDto.setTitle("Hola Mundo Pichula");
        userDto.setUser(user);

       
        return userDto;
    }

    @GetMapping("/list")
    public List<User> getUserList(){
        User user = new User("Ricardo", "Nariz");
        User user2 = new User("Glorita", "Zetas");
        User user3 = new User("Amalia", "Gato");

        // List<User> users = List.of(user, user2, user3);
        List<User> users = Arrays.asList(user, user2, user3);

        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;

    }
}
