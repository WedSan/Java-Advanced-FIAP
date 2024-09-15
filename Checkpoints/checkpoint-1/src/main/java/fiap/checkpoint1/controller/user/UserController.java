package fiap.checkpoint1.controller.user;


import fiap.checkpoint1.dto.request.UserCreationRequestDTO;
import fiap.checkpoint1.dto.response.UserResponseDTO;
import fiap.checkpoint1.mapper.UserMapper;
import fiap.checkpoint1.model.User;
import fiap.checkpoint1.service.user.UserManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreationRequestDTO request){
        User userCreated = userManager.createUser(request.name(), request.email());
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.toDto(userCreated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUser(@PathVariable("id") long userId){
        User userCreated = userManager.findUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.toDto(userCreated));
    }

}
