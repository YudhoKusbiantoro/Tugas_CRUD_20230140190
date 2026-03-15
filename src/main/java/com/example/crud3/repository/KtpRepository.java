package com.example.crud3.repository;

import com.example.crud3.model.entity.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KtpRepository extends JpaRepository<Ktp, Long> {
    Optional<Ktp> findByNomorktp(String nomorktp);
    boolean existsByNomorktp(String nomorktp);
}