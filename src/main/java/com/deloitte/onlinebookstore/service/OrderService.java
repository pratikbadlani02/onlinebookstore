package com.deloitte.onlinebookstore.service;

import com.deloitte.onlinebookstore.model.Order;
import com.deloitte.onlinebookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getUserOrders(Long id) {
        return orderRepository.findByUserid(id);
    }

    public Order addOrder(Order order) {
        order.setOrderDate(LocalDate.now());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long Id) {
        orderRepository.deleteById(Id);
    }
}
