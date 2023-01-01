package com.QRwineinventory.qrWineInventory.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.password4j.Hash;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.UUID;
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;
    private String profileImage;

    public User(String userName, String password, boolean active, String roles, String profileImage) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.profileImage = profileImage;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
