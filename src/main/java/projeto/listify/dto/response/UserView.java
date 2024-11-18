package projeto.listify.dto.response;

import projeto.listify.entity.User;

public class UserView {

    private String name;
    private String email;
    private Long id;
    
    public UserView(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.id = user.getId();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
