package project.dto.booking;

import java.time.Instant;

import project.entities.Booking;

/**
 * A DTO (Data Transfer Object) class for creating a new booking. This class
 * includes only the necessary fields needed to create a booking.
 */
public class CreateBookingDTO {
	private Instant startDateTime;
	private Instant endDateTime;
	private String purpose;
	private Long userId; // ID of the user making the booking
	private Long roomId; // ID of the room being booked

	public CreateBookingDTO() {
	}

	public CreateBookingDTO(Booking booking) {
		this.startDateTime = booking.getStartDateTime();
		this.endDateTime = booking.getEndDateTime();
		this.purpose = booking.getPurpose();
		this.userId = booking.getUser().getId();
		this.roomId = booking.getRoom().getId();
	}

	public Instant getStartDateTime() {
		return startDateTime;
	}

	public Instant getEndDateTime() {
		return endDateTime;
	}

	public String getPurpose() {
		return purpose;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getRoomId() {
		return roomId;
	}

}
