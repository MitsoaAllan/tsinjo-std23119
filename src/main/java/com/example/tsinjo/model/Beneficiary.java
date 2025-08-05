package com.example.tsinjo.model;

import com.example.tsinjo.service.DonationService;
import com.example.tsinjo.service.HelpService;
import lombok.Data;

import java.time.Instant;

@Data
public class Beneficiary{
    private Long id;
    private String email;
    private String fullName;
    private Instant creationInstant;

    public Beneficiary(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }
}
