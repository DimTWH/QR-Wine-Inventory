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
    @Column(unique = true)
    private UUID uid;
    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String email;
    @Column(nullable = false)
    @NotBlank
    private String password;

    public User(@JsonProperty("uid") UUID uid,
                @JsonProperty("name") String name,
                @JsonProperty("email") String email,
                @JsonProperty("password") String password) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
