package com.essyerp.erp.repo.logrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essyerp.erp.model.login.VerificationToken;

import java.util.List;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, String> {
    List<VerificationToken> findByUserEmail(String email);
    List<VerificationToken> findByToken(String token);
}
