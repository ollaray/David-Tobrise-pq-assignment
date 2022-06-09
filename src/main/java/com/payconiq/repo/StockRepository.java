package com.payconiq.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payconiq.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
