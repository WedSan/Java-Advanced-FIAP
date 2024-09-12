package fiap.checkpoint1.factory;

import fiap.checkpoint1.service.BookSortOption;
import fiap.checkpoint1.service.BookSorter;
import fiap.checkpoint1.service.bookSorter.BookTitleSorter;

public class BookSorterFactory {

    public BookSorter createBookSorter(BookSortOption option){
        switch (option){
            case TITLE:
                return new BookTitleSorter();
        }
    }
}
