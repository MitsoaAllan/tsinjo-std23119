package com.example.tsinjo.repository.jpa;

import com.example.tsinjo.model.Donation;
import com.example.tsinjo.model.VerificationStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {
    @Query("SELECT * FROM donation ORDER BY created_at DESC")
    List<Donation> findAllOrderedByDateDesc();

    @Query("SELECT * FROM donation WHERE payment->>'verification_status' = :status")
    List<Donation> findByPaymentStatus(@Param("status") String status);

    List<Donation> findByPaymentVerificationStatus(VerificationStatus paymentVerificationStatus);
}
