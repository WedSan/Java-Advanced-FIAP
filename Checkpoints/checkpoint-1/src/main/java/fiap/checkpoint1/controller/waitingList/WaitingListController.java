package fiap.checkpoint1.controller.waitingList;

import fiap.checkpoint1.dto.response.WaitingListResponseDTO;
import fiap.checkpoint1.mapper.BookWaitingListMapper;
import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.model.BookReservation;
import fiap.checkpoint1.service.library.LibraryManager;
import fiap.checkpoint1.service.user.UserManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@RestController
@RequestMapping("/api/v1/waiting_list")
public class WaitingListController {

    private LibraryManager libraryManager;

    private UserManager userManager;

    public WaitingListController(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }


    @GetMapping
    public ResponseEntity<List<WaitingListResponseDTO>> getAllWaitingList(){
        Map<Book, Queue<BookReservation>> waitingList = libraryManager.getAllWaitingList();
        return ResponseEntity.status(HttpStatus.OK).body(BookWaitingListMapper.toDTO(waitingList));
    }

}
