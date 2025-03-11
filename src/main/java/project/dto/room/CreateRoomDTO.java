package project.dto.room;

/**
 * Data Transfer Object (DTO) for creating a room. This class encapsulates the
 * data required to create a room, including its name, location, and capacity.
 */
public class CreateRoomDTO {
	private String name;
	private String location;
	private Integer capacity;

	public CreateRoomDTO() {

	}

	public CreateRoomDTO(String name, String location, Integer capacity) {
		this.name = name;
		this.location = location;
		this.capacity = capacity;
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
