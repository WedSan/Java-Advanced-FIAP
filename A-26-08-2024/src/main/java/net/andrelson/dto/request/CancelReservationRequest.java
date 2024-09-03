package net.andrelson.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CancelReservationRequest(
        LocalDateTime cancelDate
) {

}
