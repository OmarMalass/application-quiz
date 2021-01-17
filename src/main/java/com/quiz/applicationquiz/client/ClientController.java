package com.quiz.applicationquiz.client;


import com.quiz.applicationquiz.client.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<ClientDTO> fetchAll() {
        return service.all().stream().map(ClientDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public ClientDTO create(@RequestBody ClientDTO clientDTO) {
        Client client = service.create(clientDTO.toEntity());
        return new ClientDTO(client);
    }

    @PostMapping("/update")
    public ClientDTO update(@RequestBody ClientDTO clientDTO) {
        Client client = service.update(clientDTO);
        return new ClientDTO(client);
    }
}
