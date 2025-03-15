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

import project.dto.user.CreateUserDTO;
import project.dto.user.UpdateUserDTO;
import project.dto.user.UserResponseDTO;
import project.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public UserResponseDTO createUser(@RequestBody CreateUserDTO dto) {
		return userService.createUser(dto);
	}

	@PutMapping("/{id}")
	public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO dto) {
		return userService.updateUser(id, dto);
	}

	@GetMapping("/{id}")
	public UserResponseDTO findById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@GetMapping
	public List<UserResponseDTO> findAll() {
		return userService.findAll();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
