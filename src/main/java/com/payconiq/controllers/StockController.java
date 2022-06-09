package com.payconiq.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payconiq.entity.Stock;
import com.payconiq.service.StockService;

@RestController
@RequestMapping("/api")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@GetMapping("/stocks")
	public ResponseEntity<List<Stock>> getAllStocks(){
		return ResponseEntity.ok().body(stockService.getStocks());
	}
	
	@PostMapping("/stocks")
	public ResponseEntity<Stock> createStock(@RequestBody Stock stock){
		return ResponseEntity.ok().body(stockService.createStock(stock));
	}
	
	@GetMapping("/stocks/{id}")
	public ResponseEntity<Stock> getAStock(@PathVariable long id){
		return ResponseEntity.ok().body(stockService.getStockById(id));
	}
	
	@PatchMapping("/stocks/{id}")
	public ResponseEntity<Stock> updateStock(@PathVariable long id, @RequestBody Stock stock){
		try {
			stock.setId(id);
			return ResponseEntity.ok().body(stockService.updateStock(stock));
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/stocks/{id}")
	public ResponseEntity<?> deleteStock(@PathVariable long id){
		stockService.removeStock(id);
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
		//return ResponseEntity.notFound().build();
	}
	
}
