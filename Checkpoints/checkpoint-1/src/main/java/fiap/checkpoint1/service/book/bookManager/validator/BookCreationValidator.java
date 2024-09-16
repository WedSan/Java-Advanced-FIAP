package fiap.checkpoint1.service.book.bookManager.validator;

import fiap.checkpoint1.model.Book;

public interface BookCreationValidator {

    void validate(Book bookToValidate);
}
