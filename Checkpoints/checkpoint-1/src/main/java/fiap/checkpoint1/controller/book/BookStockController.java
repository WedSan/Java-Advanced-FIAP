package fiap.checkpoint1.controller.book;

import fiap.checkpoint1.dto.request.BookAlterQuantityRequestDTO;
import fiap.checkpoint1.dto.response.BookQuantityResponseDTO;
import fiap.checkpoint1.dto.response.SingleBookCountResponseDTO;
import fiap.checkpoint1.mapper.BookCountMapper;
import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.service.book.bookManager.BookManager;
import fiap.checkpoint1.service.bookStock.BookStock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book_stock")
public class BookStockController {
    private BookStock bookStock;

    private BookManager bookManager;

    public BookStockController(BookStock bookStock, BookManager bookManager) {
        this.bookStock = bookStock;
        this.bookManager = bookManager;
    }

    @GetMapping("/count")
    public ResponseEntity<SingleBookCountResponseDTO> countBooks(@RequestParam(name="book_name" ,required = true) String bookName){
        Book findedBook = bookManager.findBookByName(bookName);
        int bookQuantityAvailable = bookStock.countBooks(findedBook);
        return ResponseEntity.status(HttpStatus.OK).body(BookCountMapper.toDto(bookQuantityAvailable));
    }

    @PatchMapping("/{isbn}/reduce")
    public ResponseEntity<BookQuantityResponseDTO> reduceStock(@PathVariable("isbn") String isbn, @RequestBody BookAlterQuantityRequestDTO request){
        Book findedBook = bookManager.findBookByIsbn(isbn);
        bookStock.reduceStock(findedBook, request.quantity());
        int bookQuantity = bookStock.countBooks(findedBook);
        return ResponseEntity.status(HttpStatus.OK).body(new BookQuantityResponseDTO(findedBook, bookQuantity));
    }

    @PatchMapping("/{isbn}/increase")
    public ResponseEntity<BookQuantityResponseDTO> increaseStock(@PathVariable("isbn") String isbn, @RequestBody BookAlterQuantityRequestDTO request){
        Book findedBook = bookManager.findBookByIsbn(isbn);
        bookStock.increaseStock(findedBook, request.quantity());
        int bookQuantity = bookStock.countBooks(findedBook);
        return ResponseEntity.status(HttpStatus.OK).body(new BookQuantityResponseDTO(findedBook, bookQuantity));
    }
}
