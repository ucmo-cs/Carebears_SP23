package com.petvax.petvaxServices.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name = "users",
        schema = "PETVAX",
        uniqueConstraints = @UniqueConstraint(columnNames = "username")
)
public class UserEntity {

    @Column(
            name = "uuid",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    @NotNull
    @NotEmpty
    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;
    @NotNull
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @Column(
            name = "ownerId",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String ownerId;

    @NotNull
    @Column(
            name = "status",
            nullable = false
    )
    private String status;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public String getRole() {
        return String.valueOf(role);
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public enum Role implements GrantedAuthority {
        ADMIN,
        USER;

        @Override
        public String getAuthority() {
            return name();
        }
    }
}
