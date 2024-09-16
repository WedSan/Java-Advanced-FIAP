package fiap.checkpoint1.controller.book;

import fiap.checkpoint1.dto.request.CreateBookRequestDTO;
import fiap.checkpoint1.dto.response.BookResponseDTO;
import fiap.checkpoint1.mapper.BookMapper;
import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.service.book.bookManager.BookManager;
import fiap.checkpoint1.service.book.bookSorter.BookSortOption;
import fiap.checkpoint1.service.book.bookSorter.EnumParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private BookManager bookManager;

    public BookController(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody CreateBookRequestDTO request){
        Book bookRequest = BookMapper.toDomain(request);
        bookManager.addBook(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(BookMapper.toDTO(bookRequest));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> listBooks(@RequestParam(required = false) String sortBy,
                                                           @RequestParam(required = false) String category){
        BookSortOption bookSortOption = EnumParser.parseToBookSorter(sortBy);
        List<Book> books = bookManager.listBooks(bookSortOption, category);
        return ResponseEntity.status(HttpStatus.OK).body(BookMapper.toDTO(books));
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookResponseDTO> findBookByIsbn(@PathVariable("isbn") String isbn){
        Book book = bookManager.findBookByIsbn(isbn);
        return ResponseEntity.status(HttpStatus.OK).body(BookMapper.toDTO(book));
    }

    @GetMapping("/search")
    public ResponseEntity<BookResponseDTO> findBookByName(@RequestParam(name = "book_name", required = true) String bookName){
        Book book = bookManager.findBookByName(bookName);
        return ResponseEntity.status(HttpStatus.OK).body(BookMapper.toDTO(book));
    }

    @DeleteMapping ("/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable("isbn") String isbn){
        Book book = bookManager.findBookByIsbn(isbn);
        bookManager.deleteBook(book);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
