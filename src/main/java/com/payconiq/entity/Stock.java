package com.payconiq.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;



@Entity
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private BigDecimal price;
	@UpdateTimestamp
	private Date lastUpdate;
	
	public Stock() {}

	public Stock(long id, String name, BigDecimal price, Date lastUpdate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.lastUpdate = lastUpdate;
	}
	
	public Stock(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return String.format("Stock [id=%s, name=%s, price=%s, lastUpdate=%s]", id, name, price, lastUpdate);
	}
	
	
	
	
}
