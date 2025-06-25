package com.vijay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

