package com.thefoodworld.controller;

import com.thefoodworld.model.OrderBill;
import com.thefoodworld.model.dto.FoodCart;
import com.thefoodworld.model.dto.OrderDTO;
import com.thefoodworld.service.order_bill.OrderBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderBillService orderBillService;

    @PostMapping("")
    public ResponseEntity<OrderBill> createNewOrder(@RequestBody OrderDTO orderDTO){
        try{
            return new ResponseEntity<>(orderBillService.createOrder(orderDTO), HttpStatus.CREATED);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
