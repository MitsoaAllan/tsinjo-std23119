package com.example.tsinjo.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

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
