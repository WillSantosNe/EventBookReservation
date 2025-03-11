package project.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.user.CreateUserDTO;
import project.dto.user.UpdateUserDTO;
import project.dto.user.UserResponseDTO;
import project.entities.User;
import project.enums.Role;
import project.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserResponseDTO createUser(CreateUserDTO dto) {
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword()); // TODO In production, you need to encrypt the password.
		user.setRole(Role.USER);

		return new UserResponseDTO(userRepository.save(user));
	}

	public UserResponseDTO updateUser(Long id, UpdateUserDTO dto) {
		Optional<User> userOpt = userRepository.findById(id);
		if (userOpt.isEmpty()) {
			throw new RuntimeException("User not found");
		}

		User user = userOpt.get();
		if (dto.getUsername() != null)
			user.setUsername(dto.getUsername());
		if (dto.getEmail() != null)
			user.setEmail(dto.getEmail());

		return new UserResponseDTO(userRepository.save(user));
	}

	public UserResponseDTO findById(Long id) {
		Optional<User> userOpt = userRepository.findById(id);
		if (userOpt.isEmpty()) {
			throw new RuntimeException("User not found");
		}

		return new UserResponseDTO(userOpt.get());
	}

	public List<UserResponseDTO> findAll() {
		return userRepository.findAll().stream().map(UserResponseDTO::new).collect(Collectors.toList());
	}

	public void delete(Long id) {
		if (!userRepository.existsById(id)) {
			throw new RuntimeException("User not found with ID: " + id);
		}
		userRepository.deleteById(id);
	}
}
