package com.payconiq.service;

import java.util.List;

import com.payconiq.entity.Stock;

public interface StockService {
	Stock createStock(Stock stock);
	
	Stock updateStock(Stock stock);
	
	List<Stock> getStocks();
	
	Stock getStockById(long id);
	
	void removeStock(long id);
	
}
