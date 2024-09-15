package fiap.checkpoint1.service.user;

import fiap.checkpoint1.model.User;

public interface UserManager {

    User createUser(String name, String email);

    User findUserById(long id);
}
