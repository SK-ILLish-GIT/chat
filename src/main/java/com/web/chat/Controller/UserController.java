package com.web.chat.controller;

import com.web.chat.model.User;
import com.web.chat.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Get User by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    //Add New User
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    //Update User by ID
    @PutMapping("/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUserById(id, userDetails);
    }

    //Delete User by ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully!";
    }

    //Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //Post add Friend by ID to User
    @PutMapping("/{userId}/addFriend")
    public User addFriend(@PathVariable Long userId, @RequestParam Long friendId) {
        return userService.addFriend(userId, friendId);
    }
}
