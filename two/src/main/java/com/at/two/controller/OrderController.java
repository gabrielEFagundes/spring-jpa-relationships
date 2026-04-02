package com.at.two.controller;

import com.at.two.dto.order.OrderRequest;
import com.at.two.dto.order.OrderResponse;
import com.at.two.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public OrderResponse addOrder(@RequestBody OrderRequest req){
        return service.addOrder(req);
    }

    @GetMapping
    public List<OrderResponse> getOrders(){
        return service.getOrders();
    }

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable("id") Long id){
        return service.getOrderById(id);
    }

    @GetMapping("/{id}/client")
    public OrderResponse getOrderWithClientDetails(@PathVariable("id") Long id){
        return service.getOrderWithClientDetails(id);
    }

}
