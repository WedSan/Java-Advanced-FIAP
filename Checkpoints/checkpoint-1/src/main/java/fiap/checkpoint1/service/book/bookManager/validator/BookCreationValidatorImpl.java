package fiap.checkpoint1.service.book.bookManager.validator;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.exception.InvalidBookAttributeException;
import org.springframework.stereotype.Component;

@Component
public class BookCreationValidatorImpl implements BookCreationValidator{

    @Override
    public void validate(Book bookToValidate) {
        validateAttribute(bookToValidate.getIsbn(), "ISBN cannot be null or blank");
        validateAttribute(bookToValidate.getName(), "Name cannot be null or blank");
        validateAttribute(bookToValidate.getAuthor(), "Author cannot be null or blank");
        validateAttribute(bookToValidate.getCategory(), "Category cannot be null or blank");
    }

    private void validateAttribute(String attribute, String errorMessage){
        if(verifyStringIsNullOrBlank(attribute))
            throw new InvalidBookAttributeException(errorMessage);
    }

    private boolean verifyStringIsNullOrBlank(String str){
        return str == null || str.isBlank();
    }
}
