package com.payconiq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payconiq.entity.Stock;
import com.payconiq.exceptions.ResourceNotFoundException;
import com.payconiq.repo.StockRepository;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public Stock createStock(Stock stock) {
		return stockRepository.save(stock);
	}

	@Override
	public Stock updateStock(Stock stock) {
		Optional<Stock> stk = stockRepository.findById(stock.getId());
		if(stk.isPresent()) {
			Stock stockUpdate = stk.get();
			stockUpdate.setId(stock.getId());
			stockUpdate.setName(stock.getName());
			stockUpdate.setPrice(stock.getPrice());
			stockUpdate.setLastUpdate(stock.getLastUpdate());
			return stockRepository.save(stockUpdate);
		}else {
			throw new ResourceNotFoundException("Resource with the Id: "+stock.getId()+ " Could not be found");
		}
		
		
	}

	@Override
	public List<Stock> getStocks() {
		return stockRepository.findAll();
	}

	@Override
	public Stock getStockById(long id) {
		Optional<Stock> stk = stockRepository.findById(id);
		if(stk.isPresent()) {
			return stk.get();
		}else {
			throw new ResourceNotFoundException("Resource with the Id: "+id+" Could not be found");
		}
		
	}

	@Override
	public void removeStock(long id) {		
		Optional<Stock> stk = stockRepository.findById(id);
		if(stk.isPresent()) {
			stockRepository.deleteById(id);
		}else {
			throw new ResourceNotFoundException("Resource with the Id: "+id+" Could not be found");
		}
	}

}
