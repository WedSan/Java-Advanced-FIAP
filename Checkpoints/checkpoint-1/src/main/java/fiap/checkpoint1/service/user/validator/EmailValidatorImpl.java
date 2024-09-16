package fiap.checkpoint1.service.user.validator;

import fiap.checkpoint1.exception.InvalidEmailException;
import org.springframework.stereotype.Component;

@Component
public class EmailValidatorImpl implements EmailValidator {
    @Override
    public void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new InvalidEmailException("Email cannot be null or empty");
        }
        if (!email.contains("@")) {
            throw new InvalidEmailException("Email must contain @");
        }
    }
}
