package com.example.tsinjo.service;

import com.example.tsinjo.model.Donation;
import com.example.tsinjo.model.Donor;
import com.example.tsinjo.model.Payment;
import com.example.tsinjo.model.VerificationStatus;
import com.example.tsinjo.repository.jpa.DonationRepository;
import com.example.tsinjo.repository.jpa.DonorRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonationService {
  private final DonationRepository donationRepository;
  private final DonorRepository donorRepository;
  private final VolaService volaService;

  public Donation createDonation(String donorEmail, String fullName, Payment payment) {
    Donor donor =
        donorRepository
            .findByEmail(donorEmail)
            .orElseGet(
                () -> {
                  Donor newDonor = new Donor(donorEmail, fullName);
                  return donorRepository.save(newDonor);
                });

    Donation donation = new Donation(donor, payment, VerificationStatus.VERIFYING);

    return donationRepository.save(donation);
  }

  public List<Donation> getAllDonationsOrderedByDateDesc() {
    return donationRepository.findAllOrderedByDateDesc();
  }

  @Scheduled(fixedRate = 60000) // Vérifie toutes les minutes
  public void updatePaymentStatuses() {
    List<Donation> verifyingDonations =
        donationRepository.findByPaymentVerificationStatus(VerificationStatus.VERIFYING);

    verifyingDonations.forEach(
        donation -> {
          Payment updatedStatus =
              volaService.verifyPayment(
                  donorRepository.findById(donation.getId()).orElseThrow().getEmail(),
                  donation.getPayment().getPspType(),
                  donation.getPayment().getPspPaymentId());

          donation.getPayment().setVerificationStatus(updatedStatus.getVerificationStatus());
          donationRepository.save(donation);
        });
  }
}
