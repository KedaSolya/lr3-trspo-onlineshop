package com.example.lr3.repo;

import com.example.lr3.models.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistRepo extends JpaRepository<Blacklist, Integer> {
    Blacklist findByEmail(String email);
}
