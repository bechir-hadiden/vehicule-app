package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Client;
import java.util.List;

public interface IClientService {
    List<Client> retrieveAllClients();
    Client retrieveClient(Long clientId);
    Client addClient(Client client);
    Client modifyClient(Client client);
    void removeClient(Long clientId);
}
