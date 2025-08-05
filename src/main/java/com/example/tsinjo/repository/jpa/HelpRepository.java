package com.example.tsinjo.repository.jpa;

import com.example.tsinjo.model.Help;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRepository extends CrudRepository<Help, Long> {
  @Query("SELECT * FROM help ORDER BY created_at DESC")
  List<Help> findAllOrderedByDateDesc();
}
