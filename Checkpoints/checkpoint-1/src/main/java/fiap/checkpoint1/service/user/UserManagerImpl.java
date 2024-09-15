package fiap.checkpoint1.service.user;

import fiap.checkpoint1.model.User;
import fiap.checkpoint1.exception.UserNotFoundException;
import fiap.checkpoint1.service.user.validator.EmailListValidator;
import fiap.checkpoint1.service.user.validator.EmailValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagerImpl implements UserManager{

    private List<User> users;

    private EmailValidator emailValidator;

    private EmailListValidator emailListValidator;

    public UserManagerImpl(EmailValidator emailValidator, EmailListValidator emailListValidator) {
        this.emailValidator = emailValidator;
        this.emailListValidator = emailListValidator;
        this.users = new ArrayList<>();
    }

    @Override
    public User createUser(String name, String email){
        User user = new User(name, email);
        emailValidator.validateEmail(email);
        emailListValidator.validateEmailExists(users, email);
        users.add(user);
        return user;
    }

    @Override
    public User findUserById(long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
