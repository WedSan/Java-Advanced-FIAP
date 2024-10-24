package fiap.checkpoint.service;

import fiap.checkpoint.DTO.ClientDTO;
import fiap.checkpoint.model.Client;
import fiap.checkpoint.repository.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ClientService {

    public final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping
    public ClientDTO createClient(String name, String email, String document) {
        Client newClient = new Client(name, email, document);
        return convertToDTO(clientRepository.save(newClient));
    }

    @GetMapping
    public Page<ClientDTO> listClients(Pageable pageable) {
        Page<ClientDTO> list = clientRepository.findAll(pageable)
                .map(this::convertToDTO);
        return list;
    }

    private ClientDTO convertToDTO(Client client) {
        return new ClientDTO(client.getId(), client.getName(), client.getEmail(), client.getDocument());
    }

}
