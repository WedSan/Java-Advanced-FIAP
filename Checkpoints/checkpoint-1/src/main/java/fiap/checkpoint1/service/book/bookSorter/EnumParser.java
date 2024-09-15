package fiap.checkpoint1.service.book.bookSorter;

import fiap.checkpoint1.exception.InvalidSortOptionException;

public class EnumParser {

    public static BookSortOption parseToBookSorter(String value) {
        if (value == null || value.isEmpty())
            return BookSortOption.TITLE;

        switch (value.toUpperCase()) {
            case "TITLE":
                return BookSortOption.TITLE;
            case "AUTHOR":
                return BookSortOption.AUTHOR;
            case "CATEGORY":
                return BookSortOption.CATEGORY;
            default:
               throw new InvalidSortOptionException(value + " is not a valid sort option");
        }
    }
}
