package project.dto.user;

/**
 * Data Transfer Object (DTO) for creating a user.
 * This class encapsulates the data required to create a user,
 * including username, password, and email.
 */
public class CreateUserDTO {

    private String username;
    private String password;
    private String email;

    public CreateUserDTO() {
    }

    public CreateUserDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters e setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
