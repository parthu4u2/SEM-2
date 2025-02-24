package beans;

import java.io.Serializable;

public class UserBean implements Serializable {
    private String username;
    private String password;

    // No-argument constructor
    public UserBean() {}

    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
