package com.example.tsinjo.repository.model;

import com.example.tsinjo.model.VerificationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Table(name = "help")
@Getter
@Setter
@Entity
public class JHelp {
  @Id private long id;
  private long beneficiaryId;
  private String pspType;
  private long pspPaymentId;
  private int amount;
  private Instant creationInstant;
  private VerificationStatus verificationStatus;
  private String accidentDescription;
  private Instant lastVerificationStatusInstant;
}
