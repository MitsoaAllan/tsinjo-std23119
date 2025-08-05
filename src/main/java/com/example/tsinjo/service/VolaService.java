package com.example.tsinjo.service;

import com.example.tsinjo.model.Payment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class VolaService {
    private RestTemplate restTemplate;
    private String apiKey;
    private final String volaBaseUrl = "https://42cwka3n4ifcp7ufheyrpmph240iuaxo.lambda-url.eu-west-3.on.aws";

    public Payment verifyPayment(String payerEmail, String pspType, String pspPaymentId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(volaBaseUrl + "/payment")
                .queryParam("apiKey", apiKey)
                .queryParam("payerEmail", payerEmail)
                .queryParam("pspType", pspType)
                .queryParam("pspPaymentId", pspPaymentId);

        return restTemplate.getForObject(builder.toUriString(), Payment.class);
    }

    public Payment createPayment(String payerEmail, String pspType, String pspPaymentId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(volaBaseUrl + "/payment")
                .queryParam("apiKey", apiKey)
                .queryParam("payerEmail", payerEmail)
                .queryParam("pspType", pspType)
                .queryParam("pspPaymentId", pspPaymentId);

        return restTemplate.postForObject(builder.toUriString(), null, Payment.class);
    }
}
