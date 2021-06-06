package com.thefoodworld.service.order_bill;

import com.thefoodworld.model.OrderBill;
import com.thefoodworld.model.dto.OrderDTO;

public interface OrderBillService {
    OrderBill createOrder(OrderDTO orderDTO);
}
