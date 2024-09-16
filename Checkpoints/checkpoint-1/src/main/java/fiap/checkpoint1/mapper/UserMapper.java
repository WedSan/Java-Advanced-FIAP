package fiap.checkpoint1.mapper;

import fiap.checkpoint1.dto.response.UserResponseDTO;
import fiap.checkpoint1.model.User;

public class UserMapper {

    public static UserResponseDTO toDto(User user){
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }
}
