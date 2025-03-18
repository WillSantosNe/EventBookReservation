package project.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import project.dto.room.CreateRoomDTO;
import project.dto.room.ResponseRoomDTO;
import project.dto.room.UpdateRoomDTO;
import project.entities.Room;
import project.enums.RoomStatus;
import project.repositories.RoomRepository;

/**
 * Service class for managing room-related operations.
 */
@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	/**
	 * Creates a new room with the given details.
	 *
	 * @param dto The DTO containing room creation details.
	 * @return The created room as a DTO.
	 */
	public ResponseRoomDTO createRoom(CreateRoomDTO dto) {
		Room room = new Room();
		room.setName(dto.getName());
		room.setLocation(dto.getLocation());
		room.setCapacity(dto.getCapacity());
		room.setStatus(RoomStatus.ACTIVE);

		return new ResponseRoomDTO(roomRepository.save(room));
	}

	/**
	 * Updates an existing room with the given details.
	 *
	 * @param id  The ID of the room to update.
	 * @param dto The DTO containing room update details.
	 * @return The updated room as a DTO.
	 * @throws RuntimeException if the room with the given ID is not found.
	 */
	public ResponseRoomDTO updateRoom(Long id, UpdateRoomDTO dto) {
		Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));

		if (dto.getName() != null) {
			room.setName(dto.getName());
		}
		if (dto.getLocation() != null) {
			room.setLocation(dto.getLocation());
		}
		if (dto.getCapacity() != null) {
			room.setCapacity(dto.getCapacity());
		}

		return new ResponseRoomDTO(roomRepository.save(room));
	}

	/**
	 * Finds a room by its ID.
	 *
	 * @param id The ID of the room to find.
	 * @return The room as a DTO.
	 * @throws RuntimeException if the room with the given ID is not found.
	 */
	public ResponseRoomDTO findById(Long id) {
		Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));

		return new ResponseRoomDTO(room);
	}

	/**
	 * Retrieves all rooms.
	 *
	 * @return A list of all rooms as DTOs.
	 */
	@Transactional
	public List<ResponseRoomDTO> findAll() {
		return roomRepository.findAll().stream().map(ResponseRoomDTO::new).collect(Collectors.toList());
	}

	/**
	 * Deletes a room by its ID.
	 *
	 * @param id The ID of the room to delete.
	 * @throws RuntimeException if the room with the given ID does not exist.
	 */
	public void delete(Long id) {
		if (!roomRepository.existsById(id)) {
			throw new RuntimeException("Room not found with Id: " + id);
		}
		roomRepository.deleteById(id);
	}
}
