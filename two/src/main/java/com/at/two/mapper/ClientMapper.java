package com.at.two.mapper;

import com.at.two.dto.client.ClientRequest;
import com.at.two.dto.client.ClientResponse;
import com.at.two.model.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    public Client toEntity(ClientRequest req){
        return new Client(req.name(), req.email(), req.password());
    }

    public ClientResponse toResponse(Client c){
        return new ClientResponse(c.getId(), c.getName(), c.getEmail(), c.getPassword(), c.getOrders());
    }

    public List<ClientResponse> toResponse(List<Client> c){
        List<ClientResponse> clients = new ArrayList<>();

        c.forEach(client -> clients.add(toResponse(client)));

        return clients;
    }

}
