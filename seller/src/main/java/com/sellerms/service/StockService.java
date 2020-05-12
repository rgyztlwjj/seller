package com.sellerms.service;

import java.util.List;

import com.sellerms.models.*;

public interface StockService {
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<StockModel> getStock(Integer userId);
	
	/**
	 * 
	 * @param stockmodel
	 * @return
	 */
	public boolean updateStocks(StockModel stockmodel);
}
