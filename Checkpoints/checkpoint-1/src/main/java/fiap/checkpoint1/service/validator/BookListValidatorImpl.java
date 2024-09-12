package fiap.checkpoint1.service.validator;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.model.exception.BookAlreadyExistsException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookListValidatorImpl implements BookListValidator{

    @Override
    public void validate(List<Book> bookList, Book bookToValidate) {
        boolean bookAlreadyExists = bookList.stream()
                .anyMatch(book -> book.getIsbn().equals(bookToValidate.getIsbn()));
        if (bookAlreadyExists)
            throw new BookAlreadyExistsException("The book with isbn: " + bookToValidate.getIsbn() + " already exists in the list");
    }
}
