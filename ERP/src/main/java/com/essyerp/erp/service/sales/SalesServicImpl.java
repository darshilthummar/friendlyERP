package com.essyerp.erp.service.sales;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essyerp.erp.repo.SalesItemRepo;

@Service
@Transactional
public class SalesServicImpl implements SalesService {

	@Autowired
	SalesItemRepo salesItemRepo; 
	
	@Override
	public void deleteSalesItem(List<Long> l) {
		
			// TODO Auto-generated method stub
			salesItemRepo.deleteSalesItem(l);
			}
		
	

}
