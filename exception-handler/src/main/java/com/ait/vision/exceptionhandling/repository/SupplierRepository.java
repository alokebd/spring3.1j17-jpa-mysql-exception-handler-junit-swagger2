package com.ait.vision.exceptionhandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ait.vision.exceptionhandling.entity.Supplier;

import java.util.Optional;

@Repository
public interface SupplierRepository  extends JpaRepository<Supplier,Long> {
    Optional<Supplier> findByRegistrationNo(int registrationNo);
}
