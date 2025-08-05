package com.example.tsinjo.endpoint.rest.controller;

import com.example.tsinjo.model.Payment;
import com.example.tsinjo.model.VerificationStatus;
import com.example.tsinjo.repository.jpa.DonationRepository;
import com.example.tsinjo.repository.jpa.HelpRepository;
import com.example.tsinjo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TsinjoController {
    private final DonationRepository donationRepo;
    private final HelpRepository helpRepo;
    private final PaymentService paymentService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("donations", donationRepo.findAllOrderedByDateDesc());
        model.addAttribute("helps", helpRepo.findAllOrderedByDateDesc());
        return "index";
    }

    @PostMapping("/donate")
    public String donate(@RequestParam String email,
                         @RequestParam String pspPaymentId) {
        Payment payment = new Payment();
        payment.setPspType("ORANGE_MONEY");
        payment.setPspPaymentId(pspPaymentId);
        payment.setVerificationStatus(VerificationStatus.VERIFYING);

        paymentService.processDonation(email, payment);
        return "redirect:/";
    }
}
