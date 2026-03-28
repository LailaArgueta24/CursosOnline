package com.example.cursos.controllers;
import com.example.cursos.services.UserService;
import org.springframework.web.bind.annotation.*;
import com.example.cursos.models.User;
import java.util.List;
@RestController
@RequestMapping("/courses/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
