package projeto.listify.dto.request;

import jakarta.validation.constraints.NotEmpty;
import projeto.listify.entity.User;

public class UserUpdateDto {
    @NotEmpty(message = "Campo nome vazio")
    private String name;

    public UserUpdateDto() {
    }

    public UserUpdateDto(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public User toEntity(User user) {
        user.setName(this.name);
        return user;
    }
}
