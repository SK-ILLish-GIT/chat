package com.web.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.chat.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
