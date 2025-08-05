package com.example.tsinjo.model;

import java.time.Instant;
import lombok.Data;

@Data
public class Donation {
  private Long id;
  private Donor donor;
  private Payment payment;
  private Instant creationInstant;
  private VerificationStatus verificationStatus;
  private Instant lastVerificationStatusInstant;

  public Donation(Donor donor, Payment payment, VerificationStatus verificationStatus) {
    this.donor = donor;
    this.payment = payment;
    this.verificationStatus = verificationStatus;
  }
}
