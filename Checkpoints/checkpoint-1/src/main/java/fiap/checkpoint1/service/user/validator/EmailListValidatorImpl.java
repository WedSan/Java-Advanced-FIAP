package fiap.checkpoint1.service.user.validator;

import fiap.checkpoint1.model.User;
import fiap.checkpoint1.exception.InvalidEmailException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailListValidatorImpl implements EmailListValidator{
    @Override
    public void validateEmailExists(List<User> users, String email) {
        boolean emailAlreadyUsed = users.stream()
                .anyMatch(user -> user.getEmail().equals(email));

        if (emailAlreadyUsed)
            throw new InvalidEmailException("Email already used");

    }
}
