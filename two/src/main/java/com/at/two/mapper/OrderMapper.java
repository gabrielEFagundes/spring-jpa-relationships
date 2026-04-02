package com.at.two.mapper;

import com.at.two.dto.order.OrderRequest;
import com.at.two.dto.order.OrderResponse;
import com.at.two.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    public Order toEntity(OrderRequest req){
        return new Order(req.itemName(), req.amount());
    }

    public OrderResponse toResponse(Order o){
        return new OrderResponse(o.getId(), o.getItemName(), o.getAmount(), o.getClient());
    }

    public List<OrderResponse> toResponse(List<Order> o){
        List<OrderResponse> orders = new ArrayList<>();

        o.forEach(order -> orders.add(toResponse(order)));

        return orders;
    }

}
