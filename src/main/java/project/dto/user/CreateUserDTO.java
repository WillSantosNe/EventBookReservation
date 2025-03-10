package project.dto.user;

public class CreateUserDTO {

    private String username;
    private String password;
    private String email;

    // Construtor padrão
    public CreateUserDTO() {
    }

    // Construtor com argumentos
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
