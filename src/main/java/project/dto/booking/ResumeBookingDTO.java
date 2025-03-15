package project.dto.booking;

import java.time.Instant;

import project.entities.Booking;
import project.enums.BookingStatus;

/*
 * This DTO is used to display the list of Bookings of a Room, 
 * thus avoiding infinite loops between the entities
 */
public class ResumeBookingDTO {
	private Long id;
	private Instant startDateTime;
	private Instant endDateTime;
	private String purpose;
	private BookingStatus status;

	public ResumeBookingDTO(Booking booking) {
		this.id = booking.getId();
		this.startDateTime = booking.getStartDateTime();
		this.endDateTime = booking.getEndDateTime();
		this.purpose = booking.getPurpose();
		this.status = booking.getStatus();
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

}
