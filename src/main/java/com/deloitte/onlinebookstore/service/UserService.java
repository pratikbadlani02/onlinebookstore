package com.deloitte.onlinebookstore.service;

import com.deloitte.onlinebookstore.model.User;
import com.deloitte.onlinebookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("passwordEncoder")
    PasswordEncoder passwordEncoder;

    public User findUser(String username, String email) {
        return userRepository.findByUsernameorEmail(username, email);
    }

    public User addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthority("user");
        user.setEnabled(1);
        return userRepository.save(user);
    }
    public User updateUserProfile(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updateUser = existingUser.get();
            updateUser.setAddress(user.getAddress());
            updateUser.setEmail(user.getEmail());
            updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(updateUser);
        } else
            return null;
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updateUser = existingUser.get();
            updateUser.setAddress(user.getAddress());
            updateUser.setEmail(user.getEmail());
            updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(updateUser);
        } else
            return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
