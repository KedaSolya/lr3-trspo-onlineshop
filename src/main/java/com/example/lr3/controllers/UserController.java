package com.example.lr3.controllers;

import com.example.lr3.models.Goods;
import com.example.lr3.models.Orders;
import com.example.lr3.repo.GoodsRepo;
import com.example.lr3.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private GoodsRepo goodsRepo;
    @Autowired
    private OrdersRepo ordersRepo;

    @GetMapping("/user/goods")
    public List<Goods> getGoods(){
        return goodsRepo.findAll();
    }

    // Get a list of all goods
    @GetMapping("/user/orders")
    public List<Orders> getOrders(){
        return ordersRepo.findAll();
    }

    // Create an order
    @PostMapping("/user/create-order")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order){
        Orders createdOrder = ordersRepo.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    // Pay for the order
    @PutMapping("/user/orders/{id}/payment")
    public ResponseEntity<Orders> updatePaymentStatus(@PathVariable int id) {
        Optional<Orders> optionalOrder = ordersRepo.findById(id);
        if (optionalOrder.isPresent()) {
            Orders existingOrder = optionalOrder.get();
            existingOrder.setPaid(true);

            Orders updated = ordersRepo.save(existingOrder);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
