package fiap.checkpoint1.service.bookStock;

import fiap.checkpoint1.model.Book;

import java.util.Map;

public interface BookStock {


    int countBooks(Book book);

    void increaseStock(Book book, int quantity);

    void reduceStock(Book book, int quantity);

    Map<Book, Integer> getBookStock();
}
