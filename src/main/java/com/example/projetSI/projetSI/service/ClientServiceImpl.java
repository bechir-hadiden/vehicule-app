package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Client;
import com.example.projetSI.projetSI.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client retrieveClient(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client modifyClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void removeClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
