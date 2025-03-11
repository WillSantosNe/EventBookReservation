package project.dto.room;

import project.entities.Room;

/**
 * Data Transfer Object (DTO) for updating a room. This class encapsulates the
 * data required to update a room, including its name, location, and capacity.
 */
public class UpdateRoomDTO {
	private String name;
	private String location;
	private Integer capacity;

	public UpdateRoomDTO() {

	}

	public UpdateRoomDTO(Room room) {
		this.name = room.getName();
		this.location = room.getLocation();
		this.capacity = room.getCapacity();
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

}
