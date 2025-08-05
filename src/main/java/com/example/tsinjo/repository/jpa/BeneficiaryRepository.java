package com.example.tsinjo.repository.jpa;

import com.example.tsinjo.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeneficiaryRepository extends CrudRepository<Beneficiary, Long> {
    Optional<Beneficiary> findByEmail(String email);

    Optional<Beneficiary> findByEmailAndFullName(String email, String fullName);
}
