package com.at.two.service;

import com.at.two.dto.order.OrderRequest;
import com.at.two.dto.order.OrderResponse;
import com.at.two.mapper.OrderMapper;
import com.at.two.model.Client;
import com.at.two.model.Order;
import com.at.two.repository.ClientRepository;
import com.at.two.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final ClientRepository clientRepository;
    private final OrderMapper mapper;

    public OrderResponse addOrder(OrderRequest req){
        if(!clientRepository.existsById(req.clientId())){
            throw new RuntimeException("Ops! Client does not exists!");
        }

        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(req)
                )
        );
    }

    public List<OrderResponse> getOrders(){
        return mapper.toResponse(repository.findAll());
    }

    public OrderResponse getOrderById(Long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Nope (Order by Id)")));
    }

    public OrderResponse getOrderWithClientDetails(Long orderId){
        Order order = repository.findById(orderId).orElseThrow(() -> new RuntimeException("Nope (Finding Order with Client Details)"));
        Client client = clientRepository.findById(order.getClient().getId()).orElseThrow(() -> new RuntimeException("Nope (Finding Client with Order Id)"));

        order.setClient(client);

        return mapper.toResponse(order);
    }

}
