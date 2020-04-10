package com.essyerp.erp.repo.logrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.login.ForgetToken;

@Repository
public interface FrogetTokenRepo extends JpaRepository<ForgetToken, Long> 
{

	List<ForgetToken> findByUserEmail(String email);
	List<ForgetToken> findByToken(String token);
}
