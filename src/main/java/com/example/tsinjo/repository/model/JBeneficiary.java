package com.example.tsinjo.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Table(name = "beneficiary")
@Entity
@Getter
@Setter
public class JBeneficiary {
  @Id private Long id;
  private String email;
  private String fullName;
  private Instant creationInstant;
}
