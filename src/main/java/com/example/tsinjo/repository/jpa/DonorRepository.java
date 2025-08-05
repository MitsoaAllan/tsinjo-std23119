package com.example.tsinjo.repository.jpa;

import com.example.tsinjo.model.Donor;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends CrudRepository<Donor, Long> {
  Optional<Donor> findByEmail(String email);

  Optional<Donor> findByEmailAndFullName(String email, String fullName);
}
