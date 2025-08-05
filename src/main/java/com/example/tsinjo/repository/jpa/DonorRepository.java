package com.example.tsinjo.repository.jpa;

import com.example.tsinjo.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonorRepository extends CrudRepository<Donor, Long> {
    Optional<Donor> findByEmail(String email);

    Optional<Donor> findByEmailAndFullName(String email, String fullName);
}
