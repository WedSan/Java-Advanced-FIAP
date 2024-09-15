package fiap.checkpoint1.service.book.bookManager.validator;

import fiap.checkpoint1.model.Book;

import java.util.List;

public interface BookListValidator {

    void validate(List<Book> bookList, Book bookToValidate);
}
