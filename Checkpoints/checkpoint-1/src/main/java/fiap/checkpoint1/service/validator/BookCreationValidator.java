package fiap.checkpoint1.service.validator;

import fiap.checkpoint1.model.Book;

public interface BookCreationValidator {

    void validate(Book bookToValidate);
}
