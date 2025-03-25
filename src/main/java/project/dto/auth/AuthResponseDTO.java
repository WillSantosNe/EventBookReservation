package project.dto.auth;

/*
 * DTO containing the user's authentication token
 */
public class AuthResponseDTO {
	private String token;

	public AuthResponseDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
