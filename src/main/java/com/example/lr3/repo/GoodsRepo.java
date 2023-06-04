package com.example.lr3.repo;

import com.example.lr3.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepo extends JpaRepository<Goods, Integer> {
}
