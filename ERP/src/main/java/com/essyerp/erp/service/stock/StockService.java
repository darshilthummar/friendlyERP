package com.essyerp.erp.service.stock;

import java.util.List;

public interface StockService {
	
//	void deletePurchaseItem(List<Long> l);

	void updateAddStock(long qty, long productId);

	void updateSubStock(long qty, long productId);

}
