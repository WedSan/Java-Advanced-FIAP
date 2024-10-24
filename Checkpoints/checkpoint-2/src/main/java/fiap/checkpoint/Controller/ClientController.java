package fiap.checkpoint.Controller;

import fiap.checkpoint.DTO.AddClientDTO;
import fiap.checkpoint.DTO.ClientDTO;
import fiap.checkpoint.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    public final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid AddClientDTO dto){
        ClientDTO response =  clientService.createClient(dto.name(), dto.email(), dto.document());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> getClients(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.listClients(PageRequest.of(page, size)));
    }
}
