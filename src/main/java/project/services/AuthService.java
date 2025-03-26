package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.config.JwtUtil;
import project.dto.auth.AuthRequestDTO;
import project.dto.auth.AuthResponseDTO;
import project.entities.User;
import project.repositories.UserRepository;

/**
 * Service responsible for handling user authentication and JWT token generation.
 */
@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Authenticates a user based on provided credentials and returns a JWT token.
	 *
	 * @param dto the authentication request containing username and password
	 * @return an {@link AuthResponseDTO} containing the generated JWT token
	 * @throws RuntimeException if the user is not found or the password is invalid
	 */
	public AuthResponseDTO authenticate(AuthRequestDTO dto) {
		User user = userRepository.findByUsername(dto.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));


		
		if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid password");
		}

		String token = jwtUtil.generateToken(user.getUsername(), user.getRole().name());
		return new AuthResponseDTO(token);
	}
}
