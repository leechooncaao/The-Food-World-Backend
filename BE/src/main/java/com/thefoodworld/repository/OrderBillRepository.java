package com.thefoodworld.repository;

import com.thefoodworld.model.OrderBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBillRepository extends JpaRepository<OrderBill, Integer> {
}
