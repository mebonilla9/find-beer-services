package co.edu.umb.client.service.booking;

import java.time.LocalDateTime;

public record BookingRequest(
  Integer id,
  LocalDateTime date,
  Integer quantity,
  BookingRequest brewery,
  Integer state
) {
}
