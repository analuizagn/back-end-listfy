package projeto.listify.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import projeto.listify.entity.User;

public class UserDto {
    @NotEmpty (message = "Campo nome vazio")
    private String name;
    @Email(message = "Email inválido")
    @NotEmpty(message = "Campo email vazio")
    private String email;
    @NotEmpty(message = "Campo senha vazio")
    private String password;

    public UserDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public User toEntity() {
        return new User(
                null,
                this.name,
                this.email,
                this.password
                );
    }
}
