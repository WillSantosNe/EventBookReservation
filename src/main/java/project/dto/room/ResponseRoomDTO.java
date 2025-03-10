package project.dto.room;

import java.util.List;
import java.util.stream.Collectors;

import project.entities.Room;
import project.enums.RoomStatus;

public class ResponseRoomDTO {
	private Long id;
	private String name;
	private String location;
	private Integer capacity;
	private RoomStatus status;
	private List<BookingResponseDTO> bookings; // list of bookings

	public ResponseRoomDTO() {

	}

	public ResponseRoomDTO(Room room) {
		this.id = room.getId();
		this.name = room.getName();
		this.location = room.getLocation();
		this.capacity = room.getCapacity();
		this.status = room.getStatus();
		this.bookings = room.getBookings() != null
				? room.getBookings().stream().map(BookingResponseDTO::new).collect(Collectors.toList())
				: null;
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

	public List<BookingResponseDTO> getBookings() {
		return bookings;
	}

}
