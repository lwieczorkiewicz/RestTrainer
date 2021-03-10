package com.example.app.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @NotBlank(message = "Put your NAME please")
    @Size(min=2, max = 20, message = "Has to be between 2 and 20 characters")
    @Column(name = "name", nullable = false)
    private String firstName;

    @NotBlank(message = "Put your SURNAME please")
    @Size(min=2, max = 20, message = "Has to be between 2 and 20 characters")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Put your EMAIL please and need to be with '@'")
    @Email(message = "Wrong EMAIL. Use '@'")
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull(message = "Put your phone please")
    private Integer phoneNumber;

    public Trainer(UUID id, String firstName, String lastName, String email, int phoneNumber) {
    }

    public Trainer(String firstName, String lastName, String email, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
