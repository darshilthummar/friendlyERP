package com.essyerp.erp.service.stock;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essyerp.erp.repo.PurchaseitemRepo;
import com.essyerp.erp.repo.SalesItemRepo;
import com.essyerp.erp.repo.StockRepo;

@Service
@Transactional
public class StockServicImpl implements StockService {

	@Autowired
	StockRepo stockRepo;
	


//	@Override
//	public void deletePurchaseItem(List<Long> l) {
//		// TODO Auto-generated method stub
//		purchaseitemRepo.deletePurchaseItem(l);
//	}



	@Override
	public void updateAddStock(long qty, long productId) {
		// TODO Auto-generated method stub
		stockRepo.updateAddStock(qty, productId);
	}



	@Override
	public void updateSubStock(long qty, long productId) {
		// TODO Auto-generated method stub
		stockRepo.updateSubStock(qty, productId);
	}
		
	

}
