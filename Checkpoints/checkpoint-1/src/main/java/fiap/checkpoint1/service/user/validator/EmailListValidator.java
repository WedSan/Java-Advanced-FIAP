package fiap.checkpoint1.service.user.validator;

import fiap.checkpoint1.model.User;

import java.util.List;

public interface EmailListValidator {

    void validateEmailExists(List<User> users, String email);
}
