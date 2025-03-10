package project.dto.user;

import project.entities.User;

/**
 * A DTO (Data Transfer Object) class for update a user.
 * This class includes all the necessary fields needed update a user.
 */
public class UpdateUserDTO {

	private String username;
	private String email;

	public UpdateUserDTO() {
	}

	public UpdateUserDTO(User user) {
		this.username = user.getUsername();
		this.email = user.getEmail();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
