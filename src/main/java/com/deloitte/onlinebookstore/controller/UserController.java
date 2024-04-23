package com.deloitte.onlinebookstore.controller;

import com.deloitte.onlinebookstore.model.User;
import com.deloitte.onlinebookstore.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Operation(summary="find user by username or email", description = "accessible to admins")
    @GetMapping("/api/admin/user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<User> findUser(@RequestParam(required = false) String username,
                                         @RequestParam(required = false) String email) {
        return ResponseEntity.ok(userService.findUser(username, email));
    }

    @Operation(summary="create a new user", description="accessible by admin")
    @PostMapping("/api/admin/user")
    @PreAuthorize(("hasRole('ROLE_ADMIN')"))
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @Operation(summary = "update user by id", description = "accessible admins")
    @PutMapping("/api/admin/user/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN)")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @Operation(summary = "update user's profile", description = "accessible users")
    @PutMapping("/api/user/{id}")
    @PreAuthorize("hasRole('ROLE_USER)")
    public ResponseEntity<User> updateUserProfile(@PathVariable Long id,
                                           @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUserProfile(id, user));
    }

    @Operation(summary = "delete user by id", description = "accessible to admins")
    @DeleteMapping("/api/admin/user/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN)")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
