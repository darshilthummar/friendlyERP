package com.essyerp.erp.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.country.City;
import com.essyerp.erp.model.country.Country;


@Repository
public interface CountryRepo extends JpaRepository<Country, Long>,DataTablesRepository<Country, Long> {

}
