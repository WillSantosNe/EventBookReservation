package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.dto.auth.AuthRequestDTO;
import project.dto.auth.AuthResponseDTO;
import project.services.AuthService;

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
}