package project.dto.room;

import project.entities.Room;

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
