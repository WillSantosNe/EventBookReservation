package project.dto.user;

import project.entities.User;
import project.enums.Role;

/**
 * A DTO (Data Transfer Object) class for returning user details in API
 * responses. This class includes all the necessary fields needed to display
 * user information while ensuring that sensitive data is not exposed.
 */
public class UserResponseDTO {
	private Long id;
	private String username;
	private String email;
	private Role role;

	public UserResponseDTO() {

	}

	public UserResponseDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.role = user.getRole();
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public Role getRole() {
		return role;
	}
}
