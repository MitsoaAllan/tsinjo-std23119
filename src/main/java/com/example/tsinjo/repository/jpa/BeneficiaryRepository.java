package com.example.tsinjo.repository.jpa;

import com.example.tsinjo.model.Beneficiary;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends CrudRepository<Beneficiary, Long> {
  Optional<Beneficiary> findByEmail(String email);

  Optional<Beneficiary> findByEmailAndFullName(String email, String fullName);
}
