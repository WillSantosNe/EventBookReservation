package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.dto.auth.AuthRequestDTO;
import project.dto.auth.AuthResponseDTO;
import project.dto.user.CreateUserDTO;
import project.dto.user.UserResponseDTO;
import project.services.AuthService;
import project.services.UserService;

/**
 * Controller responsible for managing authentication endpoints.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

	/**
	 * Authentication service used by the controller.
	 */
	@Autowired
	private AuthService authService;

	@Autowired
	private UserService userService;

	/**
	 * Endpoint for user login.
	 *
	 * @param dto Object containing the authentication credentials provided by the
	 *            client.
	 * @return Response containing the generated authentication token.
	 */
	@PostMapping("/login")
	public AuthResponseDTO login(@RequestBody AuthRequestDTO dto) {
		return authService.authenticate(dto);
	}

	/**
	 * Handles user registration requests by accepting a CreateUserDTO object
	 * and returning a UserResponseDTO object.
	 *
	 * @param dto The data transfer object containing user creation details.
	 * @return ResponseEntity containing the UserResponseDTO with the created user's information.
	 * 
	 * @see CreateUserDTO
	 * @see UserResponseDTO
	 */
	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> register(@RequestBody CreateUserDTO dto) {
	    return ResponseEntity.ok(userService.createUser(dto));
	}
}