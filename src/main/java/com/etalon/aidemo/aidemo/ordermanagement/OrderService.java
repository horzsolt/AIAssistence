package com.etalon.aidemo.aidemo.ordermanagement;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public Order getOrderById(Long id) {
        return repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found: " + id));
    }

    public List<Order> findAll() {
        return repository.findAll();
    }
   
}
