package com.essyerp.erp.service.purchase;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essyerp.erp.repo.PurchaseitemRepo;
import com.essyerp.erp.repo.SalesItemRepo;

@Service
@Transactional
public class PurchaseServicImpl implements PurchaseService {

	@Autowired
	PurchaseitemRepo purchaseitemRepo;
	


	@Override
	public void deletePurchaseItem(List<Long> l) {
		// TODO Auto-generated method stub
		purchaseitemRepo.deletePurchaseItem(l);
	}
		
	

}
