package com.example.tsinjo.model;

import java.time.Instant;
import lombok.Data;

@Data
public class Payment {
  private String pspType;
  private String pspPaymentId;
  private int amount;
  private Instant creationInstant;
  private VerificationStatus verificationStatus;
}
