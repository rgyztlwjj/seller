package com.sellerms.models;

import java.math.BigDecimal;


public class StockModel {
	
	private Integer itemid;
	
    private Integer manufacturName;
    
    private String itemName;

    private BigDecimal price;
    
    private Integer stockNumber;
    

	public Integer getItemId() {
		return itemid;
	}

	public void setItemId(Integer itemid) {
		this.itemid = itemid;
	}
 

	public Integer getManufacturId() {
		return manufacturName;
	}

	public void setManufacturId(Integer manufacturId) {
		this.manufacturName = manufacturId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName == null ? null : itemName.trim();
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}

}