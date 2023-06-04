package com.example.lr3.repo;

import com.example.lr3.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders, Integer> {
}
