package com.example.tsinjo.model;

import java.time.Instant;
import lombok.Data;

@Data
public class Beneficiary {
  private Long id;
  private String email;
  private String fullName;
  private Instant creationInstant;

  public Beneficiary(String email, String fullName) {
    this.email = email;
    this.fullName = fullName;
  }
}
