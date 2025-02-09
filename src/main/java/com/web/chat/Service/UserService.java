package com.web.chat.service;

import com.web.chat.model.User;
import com.web.chat.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Get User by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    //Add New User
    public User addUser(User user) {
        return userRepository.save(user);
    }

    //Update User by ID
    public User updateUserById(Long id, User userDetails) {
        User user = getUserById(id); 

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setFriends(userDetails.getFriends());

        return userRepository.save(user);
    }

    //Delete User by ID
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    //Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Post add Friend by ID to User
    public User addFriend(Long userId, Long friendId) {
        User user = getUserById(userId);
        User friendUser = getUserById(friendId); 
        if (!user.getFriends().contains(friendId)) {
            user.getFriends().add(friendId);
            userRepository.save(user);
        }
        if(!friendUser.getFriends().contains(userId)){
            friendUser.getFriends().add(userId);
            userRepository.save(friendUser);
        }
        return user;
    }
}
