package com.example.tsinjo.model;

import lombok.Data;

import java.time.Instant;

@Data
public class Payment {
    private String pspType;
    private String pspPaymentId;
    private int amount;
    private Instant creationInstant;
    private VerificationStatus verificationStatus;

}
