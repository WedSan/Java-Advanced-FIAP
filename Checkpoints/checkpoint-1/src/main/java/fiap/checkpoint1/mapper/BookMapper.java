package fiap.checkpoint1.mapper;

import fiap.checkpoint1.dto.request.CreateBookRequestDTO;
import fiap.checkpoint1.dto.response.BookResponseDTO;
import fiap.checkpoint1.model.Book;

import java.util.List;

public class BookMapper {

    public static Book toDomain(CreateBookRequestDTO dto){
        return new Book(dto.name(), dto.author(), dto.isbn(), dto.category());
    }

    public static BookResponseDTO toDTO(Book book){
        return new BookResponseDTO(book.getName(), book.getAuthor(), book.getIsbn(), book.getCategory());
    }

    public static List<BookResponseDTO> toDTO(List<Book> books){
        return books.stream().map(book -> new BookResponseDTO(book.getName(), book.getAuthor(), book.getIsbn(), book.getCategory())).toList();
    }
}
