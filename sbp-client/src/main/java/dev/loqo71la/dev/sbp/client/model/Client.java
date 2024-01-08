package dev.loqo71la.dev.sbp.client.model;

import dev.loqo71la.sbp.base.model.Model;
import dev.loqo71la.sbp.base.model.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client extends Model {

    private String firstName;

    private String lastName;

    private Gender gender;

    private Status status;

    private int age;

    private String address;

    private String phone;

    @NotBlank(message = "Already exist client")
    @Column(unique = true)
    private String userName;

    @NotBlank(message = "Password is required")
    private String password;

    @Email
    private String email;
}
