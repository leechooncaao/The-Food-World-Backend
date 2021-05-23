package com.thefoodworld.service.order_bill;

import com.thefoodworld.repository.OrderBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBillServiceImpl implements OrderBillService{
    @Autowired
    private OrderBillRepository orderBillRepository;
}
