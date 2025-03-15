package project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.dto.room.CreateRoomDTO;
import project.dto.room.ResponseRoomDTO;
import project.dto.room.UpdateRoomDTO;
import project.services.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@PostMapping
	public ResponseRoomDTO createRoom(@RequestBody CreateRoomDTO dto) {
		return roomService.createRoom(dto);
	}

	@PutMapping("{id}")
	public ResponseRoomDTO updateRoom(@PathVariable Long id, @RequestBody UpdateRoomDTO dto) {
		return roomService.updateRoom(id, dto);
	}

	@GetMapping("/{id}")
	public ResponseRoomDTO findById(@PathVariable Long id) {
		return roomService.findById(id);
	}

	@GetMapping
	public List<ResponseRoomDTO> findAll() {
		return roomService.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		roomService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
