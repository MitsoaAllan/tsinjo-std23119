package com.example.tsinjo.model;

import java.time.Instant;
import lombok.Data;

@Data
public class Help {
  private Long id;
  private Beneficiary beneficiary;
  private Payment payment;
  private String accidentDescription;
  private Instant creationInstant;
  private Instant lastVerificationStatusInstant;

  public Help(Long id, Payment payment, String accidentDescription) {
    this.id = id;
    this.payment = payment;
    this.accidentDescription = accidentDescription;
  }
}
