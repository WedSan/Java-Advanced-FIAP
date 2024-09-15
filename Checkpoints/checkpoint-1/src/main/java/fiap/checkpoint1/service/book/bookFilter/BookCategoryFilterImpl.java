package fiap.checkpoint1.service.book.bookFilter;

import fiap.checkpoint1.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookCategoryFilterImpl implements BookCategoryFilter{

        @Override
        public List<Book> filterByCategory(List<Book> books, String category) {
            return books.stream()
                    .filter(book -> book.getCategory().equalsIgnoreCase(category))
                    .toList();
        }
}
