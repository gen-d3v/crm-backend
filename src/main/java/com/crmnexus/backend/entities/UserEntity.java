package com.crmnexus.backend.entities;

import com.crmnexus.backend.enums.Role;
import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "User")
@Table(name ="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private UUID userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String firstName;

    @Column()
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;



    protected UserEntity() {}


    public UserEntity(UUID userId, String username, String email, String passwordHash, String firstName, String lastName, Role role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }



    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public UUID getUserId() {
        return userId;
    }

}
