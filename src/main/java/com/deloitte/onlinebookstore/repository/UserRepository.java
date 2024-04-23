package com.deloitte.onlinebookstore.repository;

import com.deloitte.onlinebookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where username=?1 or email=?2")
    User findByUsernameorEmail(String username, String email);
}
