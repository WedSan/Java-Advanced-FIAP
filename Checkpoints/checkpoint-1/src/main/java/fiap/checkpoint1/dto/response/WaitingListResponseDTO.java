package fiap.checkpoint1.dto.response;

import fiap.checkpoint1.model.Book;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public record WaitingListResponseDTO(
        BookResponseDTO book,
        List<ReservationResponseDTO> waitingList
) {
}
