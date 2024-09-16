package fiap.checkpoint1.factory;

import fiap.checkpoint1.service.book.bookSorter.BookSortOption;
import fiap.checkpoint1.service.book.bookSorter.BookSorter;
import fiap.checkpoint1.service.book.bookSorter.BookAuthorSorter;
import fiap.checkpoint1.service.book.bookSorter.BookCategorySorter;
import fiap.checkpoint1.service.book.bookSorter.BookTitleSorter;
import org.springframework.stereotype.Component;

@Component
public class BookSorterFactory {

    public BookSorter createBookSorter(BookSortOption option){
        switch (option){
            case CATEGORY:
                return new BookCategorySorter();
            case AUTHOR:
                return new BookAuthorSorter();
            default:
                return new BookTitleSorter();
        }
    }
}
