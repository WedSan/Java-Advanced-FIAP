package fiap.checkpoint1.mapper;

import fiap.checkpoint1.dto.response.BookReservationResultResponseDTO;
import fiap.checkpoint1.dto.response.ReservationResponseDTO;
import fiap.checkpoint1.model.BookReservation;
import fiap.checkpoint1.service.library.reservation.BookReservationResult;

import java.util.List;
import java.util.Queue;

public class BookReservationMapper {

    public static BookReservationResultResponseDTO toDTO(BookReservationResult reservationResult){
        return new BookReservationResultResponseDTO(reservationResult.getBookReservation(),
                reservationResult.getResultMessage(), reservationResult.isWaitingList());
    }

    public static ReservationResponseDTO toDTO(BookReservation reservationResult){
        return new ReservationResponseDTO(reservationResult.getId(),
                UserMapper.toDto(reservationResult.getUser()),
                BookMapper.toDTO(reservationResult.getBook()),
                reservationResult.getReservationDate());
    }

    public static List<ReservationResponseDTO> toDTO(List<BookReservation> reservationResult){
        return reservationResult.stream()
                .map(reservation -> new ReservationResponseDTO(reservation.getId(),
                    UserMapper.toDto(reservation.getUser()),
                    BookMapper.toDTO(reservation.getBook()),
                reservation.getReservationDate()))
                .toList();
    }

    public static List<ReservationResponseDTO> toDTO(Queue<BookReservation> reservationResult){
        return reservationResult.stream()
                .map(reservation -> new ReservationResponseDTO(reservation.getId(),
                        UserMapper.toDto(reservation.getUser()),
                        BookMapper.toDTO(reservation.getBook()),
                        reservation.getReservationDate()))
                .toList();
    }
}

