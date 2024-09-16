package fiap.checkpoint1.controller.book;

import fiap.checkpoint1.dto.response.ReservationResponseDTO;
import fiap.checkpoint1.mapper.BookReservationMapper;
import fiap.checkpoint1.model.BookReservation;
import fiap.checkpoint1.service.library.LibraryManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookWaitingListController {

    private LibraryManager libraryManager;

    public BookWaitingListController(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @GetMapping("/{bookTitle}/waiting_list")
    public ResponseEntity<List<ReservationResponseDTO>> getBookWaitingList(@PathVariable("bookTitle") String bookTitle){
        List<BookReservation> waitingList = libraryManager.getAllWaitingList(bookTitle);
        return ResponseEntity.status(HttpStatus.OK).body(BookReservationMapper.toDTO(waitingList));
    }
}
