package io.bvalentino.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 150)
    private String name;

    @NotNull
    @Max(value = 125)
    private Long age;

    @NotBlank
    @Size(max = 150)
    private String email;

    @NotBlank
    @Size(max = 10)
    private String password;

    @Deprecated
    public User() {}

    public User(String name, Long age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

}
