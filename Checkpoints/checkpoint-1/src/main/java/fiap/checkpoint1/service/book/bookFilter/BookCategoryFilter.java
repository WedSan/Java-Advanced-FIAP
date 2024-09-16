package fiap.checkpoint1.service.book.bookFilter;

import fiap.checkpoint1.model.Book;

import java.util.List;

public interface BookCategoryFilter {

    List<Book> filterByCategory(List<Book> books, String category);
}
