package com.deloitte.onlinebookstore.controller;

import com.deloitte.onlinebookstore.model.Order;
import com.deloitte.onlinebookstore.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Operation(summary = "fetch all orders", description = "accessible to admins")
    @GetMapping("/api/admin/orders")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @Operation(summary = "fetch all orders of a user by user id", description = "accessible to users and admins")
    @GetMapping("/api/orders/user/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getUserOrders(id));
    }

    @Operation(summary = "create a new order", description = "accessible to users")
    @PostMapping("/api/order")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.addOrder(order));
    }

//    @DeleteMapping("/api/order/{id}")
//    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
//        orderService.deleteOrder(id);
//        return ResponseEntity.ok("Record deleted successfully");
//    }
}
