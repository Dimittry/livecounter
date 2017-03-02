package com.livecounter.web.dto;


import com.livecounter.validation.PasswordMatches;
import com.livecounter.validation.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
public class UserDto {
    @NotNull
    @Size(min=1)
    private String firstName;

    @NotNull
    @Size(min=1)
    private String lastName;

    @NotNull
    @Size(min=1)
    private String password;
    private String matchingPassword;

    @NotNull
    @Size(min=1)
    @ValidEmail
    private String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("UserDto{").append("firstName='").append(firstName).append('\'').append(", lastName='").append(lastName).append('\'').append(", password='").append(password).append('\'').append(", matchingPassword='").append(matchingPassword).append('\'').append(", email='").append(email).append('\'').append('}').toString();
    }
}
