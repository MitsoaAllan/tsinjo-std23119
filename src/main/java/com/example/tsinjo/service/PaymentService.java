package com.example.tsinjo.service;

import com.example.tsinjo.model.Donation;
import com.example.tsinjo.model.Donor;
import com.example.tsinjo.model.Payment;
import com.example.tsinjo.model.VerificationStatus;
import com.example.tsinjo.repository.jpa.DonationRepository;
import com.example.tsinjo.repository.jpa.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
  private final DonationRepository donationRepo;
  private final DonorRepository donorRepo;

  public void processDonation(String donorEmail, Payment paymentRequest) {
    Donor donor =
        donorRepo
            .findByEmail(donorEmail)
            .orElseGet(() -> donorRepo.save(new Donor(donorEmail, "Nom à définir")));

    Donation donation = new Donation(donor, paymentRequest, VerificationStatus.VERIFYING);
    donationRepo.save(donation);
  }
}
