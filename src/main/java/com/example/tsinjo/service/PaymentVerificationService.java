package com.example.tsinjo.service;

import com.example.tsinjo.model.Donation;
import com.example.tsinjo.model.Payment;
import com.example.tsinjo.model.VerificationStatus;
import com.example.tsinjo.repository.jpa.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentVerificationService {
    private final VolaService volaService;
    private final DonationRepository donationRepository;

    @Scheduled(fixedRate = 60000)
    public void verifyPendingPayments() {
        List<Donation> pendingDonations = donationRepository.findByPaymentVerificationStatus((VerificationStatus.VERIFYING));

        pendingDonations.forEach(donation -> {
            Payment payment = volaService.verifyPayment(
                    donation.getDonor().getEmail(),
                    donation.getPayment().getPspType(),
                    donation.getPayment().getPspPaymentId()
            );

            donation.getPayment().setVerificationStatus(payment.getVerificationStatus());
            donationRepository.save(donation);
        });
    }
}
