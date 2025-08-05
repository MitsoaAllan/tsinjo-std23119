package com.example.tsinjo.service;

import com.example.tsinjo.model.Beneficiary;
import com.example.tsinjo.model.Help;
import com.example.tsinjo.model.Payment;
import com.example.tsinjo.repository.jpa.BeneficiaryRepository;
import com.example.tsinjo.repository.jpa.HelpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HelpService {
    private final HelpRepository helpRepository;
    private final BeneficiaryRepository beneficiaryRepository;

    public Help createHelp(
            String beneficiaryEmail,
            String fullName,
            Payment payment,
            String accidentDescription
    ) {
        Beneficiary beneficiary = beneficiaryRepository.findByEmail(beneficiaryEmail)
                .orElseGet(() -> {
                    Beneficiary newBeneficiary = new Beneficiary(beneficiaryEmail, fullName);
                    return beneficiaryRepository.save(newBeneficiary);
                });

        Help help = new Help(
                beneficiary.getId(),
                payment,
                accidentDescription
        );

        return helpRepository.save(help);
    }

    public List<Help> getAllHelpsOrderedByDateDesc() {
        return helpRepository.findAllOrderedByDateDesc();
    }

    public void manuallyAddHelp(Help help) {
        helpRepository.save(help);
    }
}
