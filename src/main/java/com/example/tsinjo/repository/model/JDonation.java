package com.example.tsinjo.repository.model;

import com.example.tsinjo.model.VerificationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Table(name = "donation")
@Getter
@Setter
@Entity
public class JDonation {
  @Id private Long id;
  private Long donorId;
  private String pspType;
  private Long paymentId;
  private int amount;
  private Instant creationInstant;
  private VerificationStatus verificationStatus;
  private Instant lastVerificationStatusInstant;
}
