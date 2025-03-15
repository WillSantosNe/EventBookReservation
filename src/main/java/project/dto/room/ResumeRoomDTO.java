package project.dto.room;

import project.entities.Room;
import project.enums.RoomStatus;

/**
 * This DTO is used to display the list of Rooms of a Booking, avoiding loops
 * between the entities.
 */
public class ResumeRoomDTO {
	private Long id;
	private String name;
	private String location;
	private RoomStatus status;

	public ResumeRoomDTO(Room room) {
		this.id = room.getId();
		this.name = room.getName();
		this.location = room.getLocation();
		this.status = room.getStatus();
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

	public RoomStatus getStatus() {
		return status;
	}
}
