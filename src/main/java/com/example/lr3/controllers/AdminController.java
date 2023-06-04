package com.example.lr3.controllers;

import com.example.lr3.models.Blacklist;
import com.example.lr3.models.Goods;
import com.example.lr3.repo.BlacklistRepo;
import com.example.lr3.repo.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {
    @Autowired
    private GoodsRepo goodsRepo;
    @Autowired
    private BlacklistRepo blacklistRepo;

    // Get a list of all goods
    @GetMapping("/admin/goods")
    public ResponseEntity<List<Goods>> getAllGoods() {
        List<Goods> goodsList = goodsRepo.findAll();
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }

    // Add a new good
    @PostMapping("/admin/goods")
    public ResponseEntity<Goods> addGood(@RequestBody Goods g) {
        goodsRepo.save(g);
        return new ResponseEntity<>(g, HttpStatus.CREATED);
    }

    // Update good's info
    @PutMapping("/admin/goods/{id}")
    public ResponseEntity<Goods> updateGoods(@PathVariable int id, @RequestBody Goods updatedGoods) {
        Optional<Goods> optionalGoods = goodsRepo.findById(id);
        if (optionalGoods.isPresent()) {
            Goods existingGoods = optionalGoods.get();
            existingGoods.setName(updatedGoods.getName());
            existingGoods.setPrice(updatedGoods.getPrice());
            existingGoods.setCategory(updatedGoods.getCategory());

            Goods updated = goodsRepo.save(existingGoods);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a good
    @DeleteMapping("/admin/goods/{id}")
    public ResponseEntity<Void> removeGood(@PathVariable int id) {
        Goods deleteG = goodsRepo.findById(id).get();
        if (deleteG != null) {
            goodsRepo.delete(deleteG);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get a blacklist
    @GetMapping("/admin/blacklist")
    public ResponseEntity<List<Blacklist>> getAllBlacklist() {
        List<Blacklist> blacklistList = blacklistRepo.findAll();
        return new ResponseEntity<>(blacklistList, HttpStatus.OK);
    }

    // Add an email to blacklist
    @PostMapping("/admin/blacklist")
    public ResponseEntity<Blacklist> addToBlacklist(@RequestBody Blacklist email) {
        Blacklist existingEmail = blacklistRepo.findByEmail(email.getEmail());
        if (existingEmail == null) {
            Blacklist newEmail = new Blacklist();
            newEmail.setEmail(email.getEmail());
            Blacklist savedEmail = blacklistRepo.save(newEmail);
            return ResponseEntity.ok(savedEmail);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Remove an email from blacklist
    @DeleteMapping("/admin/blacklist/{id}")
    public ResponseEntity<Void> removeEmailBlacklist(@PathVariable int id) {
        Blacklist deleteB = blacklistRepo.findById(id).get();
        if (deleteB != null) {
            blacklistRepo.delete(deleteB);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
