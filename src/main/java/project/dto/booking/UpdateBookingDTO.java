package project.dto.booking;

import java.time.Instant;

import project.entities.Booking;
import project.enums.BookingStatus;

/**
 * A DTO (Data Transfer Object) class for updating an existing booking. This
 * class includes only the fields that can be updated.
 */
public class UpdateBookingDTO {
	private Instant startDateTime;
	private Instant endDateTime;
	private String purpose;
	private BookingStatus status;

	public UpdateBookingDTO() {
	}

	public UpdateBookingDTO(Booking booking) {
		this.startDateTime = booking.getStartDateTime();
		this.endDateTime = booking.getEndDateTime();
		this.purpose = booking.getPurpose();
		this.status = booking.getStatus();
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

	/**
	 * Applies the updates from this DTO to an existing `Booking` entity.
	 *
	 * @param booking The booking entity to be updated.
	 */
	public void updateEntity(Booking booking) {
		if (this.startDateTime != null) {
			booking.setStartDateTime(this.startDateTime);
		}
		if (this.endDateTime != null) {
			booking.setEndDateTime(this.endDateTime);
		}
		if (this.purpose != null) {
			booking.setPurpose(this.purpose);
		}
		if (this.status != null) {
			booking.setStatus(this.status);
		}
	}
}
