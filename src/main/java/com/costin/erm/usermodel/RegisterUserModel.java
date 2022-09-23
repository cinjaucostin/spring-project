package com.costin.erm.usermodel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterUserModel {

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    public String username;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    public String password;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    public String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    public String lastName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    public String email;

    public RegisterUserModel() {

    }

    public RegisterUserModel(String username, String password, String firstName,
                             String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "RegisterUserModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
