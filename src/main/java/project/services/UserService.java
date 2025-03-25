package project.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.dto.user.CreateUserDTO;
import project.dto.user.UpdateUserDTO;
import project.dto.user.UserResponseDTO;
import project.entities.User;
import project.enums.Role;
import project.repositories.UserRepository;

/**
 * Service class for managing user-related operations.
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	
	/**
	 * Creates a new user with the given details.
	 *
	 * @param dto The DTO containing user creation details.
	 * @return The created user as a DTO.
	 */
	public UserResponseDTO createUser(CreateUserDTO dto) {
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		
		// Encrypt password before saving
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		user.setRole(Role.USER);

		return new UserResponseDTO(userRepository.save(user));
	}

	/**
	 * Updates an existing user with the given details.
	 *
	 * @param id  The ID of the user to update.
	 * @param dto The DTO containing user update details.
	 * @return The updated user as a DTO.
	 * @throws RuntimeException if the user with the given ID is not found.
	 */
	public UserResponseDTO updateUser(Long id, UpdateUserDTO dto) {
		Optional<User> userOpt = userRepository.findById(id);
		if (userOpt.isEmpty()) {
			throw new RuntimeException("User not found");
		}

		User user = userOpt.get();
		if (dto.getUsername() != null) {
			user.setUsername(dto.getUsername());
		}
		if (dto.getEmail() != null) {
			user.setEmail(dto.getEmail());
		}

		return new UserResponseDTO(userRepository.save(user));
	}

	/**
	 * Finds a user by their ID.
	 *
	 * @param id The ID of the user to find.
	 * @return The user as a DTO.
	 * @throws RuntimeException if the user with the given ID is not found.
	 */
	public UserResponseDTO findById(Long id) {
		Optional<User> userOpt = userRepository.findById(id);
		if (userOpt.isEmpty()) {
			throw new RuntimeException("User not found");
		}

		return new UserResponseDTO(userOpt.get());
	}

	/**
	 * Retrieves all users.
	 *
	 * @return A list of all users as DTOs.
	 */
	public List<UserResponseDTO> findAll() {
		return userRepository.findAll().stream().map(UserResponseDTO::new).collect(Collectors.toList());
	}

	/**
	 * Deletes a user by their ID.
	 *
	 * @param id The ID of the user to delete.
	 * @throws RuntimeException if the user with the given ID does not exist.
	 */
	public void delete(Long id) {
		if (!userRepository.existsById(id)) {
			throw new RuntimeException("User not found with ID: " + id);
		}
		userRepository.deleteById(id);
	}
}
