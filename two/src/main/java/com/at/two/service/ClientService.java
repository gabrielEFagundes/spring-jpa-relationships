package com.at.two.service;

import com.at.two.dto.client.ClientRequest;
import com.at.two.dto.client.ClientResponse;
import com.at.two.mapper.ClientMapper;
import com.at.two.model.Client;
import com.at.two.model.Order;
import com.at.two.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientResponse addClient(ClientRequest req){
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(req)
                )
        );
    }

    public List<ClientResponse> getClients(){
        return mapper.toResponse(repository.findAll());
    }

    public ClientResponse getClientById(Long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Nope (Client by Id)")));
    }

    public List<Order> getOrdersFromClientById(Long id){
        Client client = repository.findById(id).orElseThrow(() -> new RuntimeException("Nope (Orders from Client by Id)"));

        return client.getOrders();
    }

}
