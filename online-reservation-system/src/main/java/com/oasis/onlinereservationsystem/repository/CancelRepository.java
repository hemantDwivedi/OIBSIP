package com.oasis.onlinereservationsystem.repository;

import com.oasis.onlinereservationsystem.model.Cancel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancelRepository extends JpaRepository<Cancel, Integer> {
}
