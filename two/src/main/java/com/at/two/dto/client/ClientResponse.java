package com.at.two.dto.client;

import com.at.two.model.Order;

import java.util.List;

public record ClientResponse(Long id, String name, String email, String password, List<Order> orders) {
}
