package com.example.tsinjo.repository.model;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Table(name = "donor")
@Entity
@Getter
@Setter
public class JDonor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;
  private String fullName;
  private Instant creationInstant;
}
