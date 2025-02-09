package com.web.chat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "users") 
@Data
@AllArgsConstructor
@NoArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long user_id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection  
    @CollectionTable(name = "user_friends", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "friend_id")
    private List<Long> friends;
}
