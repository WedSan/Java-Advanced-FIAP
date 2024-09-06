package net.andrelson.dto.request;

import java.time.LocalDateTime;

public record EditReservationDateRequest(
        LocalDateTime oldReservationDate,
        LocalDateTime newReservationDate
) {
}
