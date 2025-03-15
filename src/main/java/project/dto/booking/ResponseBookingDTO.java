package project.dto.booking;

import java.time.Instant;

import project.dto.room.ResponseRoomDTO;
import project.dto.user.UserResponseDTO;
import project.entities.Booking;
import project.enums.BookingStatus;

/**
 * A DTO (Data Transfer Object) class for returning booking details in API
 * responses. Includes user and room details in a simplified format.
 */
public class ResponseBookingDTO {
	private Long id;
	private Instant startDateTime;
	private Instant endDateTime;
	private String purpose;
	private BookingStatus status;
	private UserResponseDTO user;
	private ResponseRoomDTO room; // Returns basic information about the reserved room

	public ResponseBookingDTO(Booking booking, boolean includeRoom) {
		this.id = booking.getId();
		this.startDateTime = booking.getStartDateTime();
		this.endDateTime = booking.getEndDateTime();
		this.purpose = booking.getPurpose();
		this.status = booking.getStatus();
		this.user = booking.getUser() != null ? new UserResponseDTO(booking.getUser()) : null;

		// Conditionally include room details
		if (includeRoom && booking.getRoom() != null) {
			this.room = new ResponseRoomDTO(booking.getRoom(), false); // Avoid loop
		}
	}

	public Long getId() {
		return id;
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

	public BookingStatus getStatus() {
		return status;
	}

	public UserResponseDTO getUser() {
		return user;
	}

	public ResponseRoomDTO getRoom() {
		return room;
	}
}
