package com.quiz.applicationquiz.client;


import com.quiz.applicationquiz.client.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client create(Client client) {
        return repository.save(client);
    }

    public List<Client> all() {
        return repository.findAll();
    }

    private void updateNonNull(Client client, ClientDTO clientDTO) {
        if (clientDTO.getName() != null)
            client.setName(clientDTO.getName());
        if (clientDTO.getLastName() != null)
            client.setLastName(clientDTO.getLastName());
        if (clientDTO.getMobileNumber() != null)
            client.setMobileNumber(clientDTO.getMobileNumber());
    }

    public Client update(ClientDTO clientDTO) {
        Client client = repository.findById(clientDTO.getID()).orElse(null);
        if (client != null) {
            updateNonNull(client, clientDTO);
            repository.save(client);
        }
        return client;
    }
}
