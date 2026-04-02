package com.at.two.dto.order;

import com.at.two.model.Client;

public record OrderResponse(Long id, String itemName, Integer amount, Client client) {
}
