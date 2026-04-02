package com.at.two.controller;

import com.at.two.dto.client.ClientRequest;
import com.at.two.dto.client.ClientResponse;
import com.at.two.model.Order;
import com.at.two.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping
    public ClientResponse addClient(@RequestBody ClientRequest req){
        return service.addClient(req);
    }

    @GetMapping
    public List<ClientResponse> getClients(){
        return service.getClients();
    }

    @GetMapping("/{id}")
    public ClientResponse getClientById(@PathVariable("id") Long id){
        return service.getClientById(id);
    }

    @GetMapping("/{id}/orders")
    public List<Order> getOrdersFromClientId(@PathVariable("id") Long id){
        return service.getOrdersFromClientById(id);
    }

}
