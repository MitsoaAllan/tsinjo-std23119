package com.example.tsinjo.model;

import lombok.Data;

import java.time.Instant;

@Data
public class Donor {
    private Long id;
    private String email;
    private String fullName;
    private Instant creationInstant;

    public Donor() {}
    public Donor(String email,String fullName) {
        this.email = email;
        this.fullName = fullName;
    }
}
