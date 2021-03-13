package com.example.AirportApp.Models;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FeedBack {
   @NotNull
    private String name;
    @NonNull
    @Email
    private String email;
    @NotNull
    @Min(10)
    private String feedback;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @NonNull
    public String getEmail() {
        return email;
    }
    public void setEmail(@NonNull String email) {
        this.email = email;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
