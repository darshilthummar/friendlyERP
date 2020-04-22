package com.essyerp.erp.repo.logrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.essyerp.erp.model.login.User;

public interface UserRepository extends JpaRepository<User, Long> {
//	@Query(value="SELECT * FROM user WHERE is_active = ?1",nativeQuery=true)
	
	@Query(value="SELECT * FROM user WHERE username = ?1 and is_active = 1",nativeQuery=true)
	User findUser(String username);
	
	//User findByUserId(Long Id);
    
	List<User> findByEmail(String email);

	User findByUsername(String username);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE user SET password= ?1 WHERE id = ?2",nativeQuery=true)
	void changePass(String password, Long id);

	@Query(value="SELECT * FROM user WHERE email = ?1", nativeQuery=true)
	User findEmail(String email);
	
	@Query(value="SELECT * FROM user WHERE email = ?1 and is_active = 1", nativeQuery=true)
	User findAtEmail(String email);


}
