package com.vijay.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.entity.Quote;


public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
