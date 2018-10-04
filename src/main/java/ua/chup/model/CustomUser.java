package ua.chup.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CustomUser")
@NoArgsConstructor
@Getter
@Setter
public class CustomUser {
    @Id
    @GeneratedValue
    @Column
    private long id;
    @Column
    private String login;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Column
    private String email;
    @Column
    private String phone;
    @Column(name = "path_avatar")
    private String pathAvatar;


    public CustomUser(String login, String password, UserRole role) {
        this.setLogin(login);
        this.setRole(role);
    }

    public CustomUser(String login, String password, UserRole role, String email, String phone, String pathAvatar) {
        this.setPathAvatar(pathAvatar);
        this.setLogin(login);
        this.password = password;
        this.setRole(role);
        this.setEmail(email);
        this.setPhone(phone);
    }

    public CustomUser(String login, String password, UserRole role, String email, String phone) {

        this.setLogin(login);
        this.password = password;
        this.setRole(role);
        this.setEmail(email);
        this.setPhone(phone);
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPathAvatar() {
        return pathAvatar;
    }

    public void setPathAvatar(String pathAvatar) {
        this.pathAvatar = pathAvatar;
    }
}
