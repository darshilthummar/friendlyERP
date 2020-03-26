package com.essyerp.erp.repo.logrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.essyerp.erp.model.login.User;

public interface UserRepository extends JpaRepository<User, Long> {
//	@Query(value="SELECT * FROM user WHERE is_active = ?1",nativeQuery=true)
	
	@Query(value="SELECT * FROM user WHERE username = ?1 and is_active = 1",nativeQuery=true)
	User findUser(String username);
	
	//User findByUsername(String username);
    
	List<User> findByEmail(String email);
}
