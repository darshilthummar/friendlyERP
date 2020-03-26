package com.essyerp.erp.repo.logrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essyerp.erp.model.login.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
