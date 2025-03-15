package project.dto.room;

import java.util.List;
import java.util.stream.Collectors;

import project.dto.booking.ResumeBookingDTO;
import project.entities.Room;
import project.enums.RoomStatus;

/**
 * Data Transfer Object (DTO) for responding with room details. This class
 * allows dynamic control over whether to include bookings.
 */
public class ResponseRoomDTO {
	private Long id;
	private String name;
	private String location;
	private Integer capacity;
	private RoomStatus status;
	private List<ResumeBookingDTO> bookings; // Reservas resumidas

	public ResponseRoomDTO(Room room) {
		this.id = room.getId();
		this.name = room.getName();
		this.location = room.getLocation();
		this.capacity = room.getCapacity();
		this.status = room.getStatus();

		if (room.getBookings() != null) {
			this.bookings = room.getBookings().stream().map(ResumeBookingDTO::new) 
																					
					.collect(Collectors.toList());
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public List<ResumeBookingDTO> getBookings() {
		return bookings;
	}
}