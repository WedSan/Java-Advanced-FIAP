package fiap.checkpoint1.service;

import fiap.checkpoint1.model.Book;

import java.util.List;

public interface BookSorter {

    List<Book> sortBooks(List<Book> books);
}
