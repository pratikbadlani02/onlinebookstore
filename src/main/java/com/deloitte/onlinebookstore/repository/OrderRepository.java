package com.deloitte.onlinebookstore.repository;

import com.deloitte.onlinebookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserid(Long id);
}
