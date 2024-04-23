package com.deloitte.onlinebookstore.controller;

import com.deloitte.onlinebookstore.model.Book;
import com.deloitte.onlinebookstore.service.ShoppingCartService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @Operation(summary = "fetch list of books in cart", description = "accessible to users")
    @GetMapping("/api/cart")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<Book>> getCart() {
        return (ResponseEntity<List<Book>>) ResponseEntity.ok(shoppingCartService.getCart());
    }

    @Operation(summary = "empty cart", description = "accessible to users")
    @GetMapping("/api/cart/empty")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> emptyCart() {
        shoppingCartService.emptyCart();
        return ResponseEntity.ok("Cart deleted successfully");
    }

    @Operation(summary = "add a book to cart by book id", description = "accessible to users")
    @GetMapping("/api/cart/add/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> addToCart(@PathVariable Long id) {
        shoppingCartService.addToCart(id);
        return ResponseEntity.ok("Book added to cart successfully.");
    }

    @Operation(summary = "remove a book from cart by book id", description = "accessible to users")
    @GetMapping("/api/cart/remove/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> removeFromCart(@PathVariable Long id) {
        shoppingCartService.removeFromCart(id);
        return ResponseEntity.ok("Book removed from cart successfully");
    }
}
