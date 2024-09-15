package fiap.checkpoint1.mapper;

import fiap.checkpoint1.dto.response.ReservationResponseDTO;
import fiap.checkpoint1.dto.response.WaitingListResponseDTO;
import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.model.BookReservation;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BookWaitingListMapper {

    public static List<WaitingListResponseDTO> toDTO(Map<Book, Queue<BookReservation>> waitingList){
        return waitingList.entrySet()
                .stream()
                .map(entry -> new WaitingListResponseDTO(BookMapper.toDTO(entry.getKey()),
                        entry.getValue()
                                .stream()
                                .map(reservation -> new ReservationResponseDTO(reservation.getId(),
                                        UserMapper.toDto(reservation.getUser()),
                                        BookMapper.toDTO(reservation.getBook()),
                                        reservation.getReservationDate())).toList()))
                .toList();
    }
}
