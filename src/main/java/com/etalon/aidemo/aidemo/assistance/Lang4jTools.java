package com.etalon.aidemo.aidemo.assistance;

import org.springframework.stereotype.Component;

import com.etalon.aidemo.aidemo.ordermanagement.Order;
import com.etalon.aidemo.aidemo.ordermanagement.OrderService;

import dev.langchain4j.agent.tool.Tool;

@Component
class Lang4jTools {

    private final OrderService service;

    public Lang4jTools(OrderService service) {
        this.service = service;
    }

    @Tool
    public Order creatOrder(String description, String unit, int quantity) {
        return service.createOrder(new Order(description, unit, quantity));
    }
}
