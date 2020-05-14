package com.sellerms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellerms.service.*;
import com.sellerms.models.*;

@RestController
@RequestMapping(value = "/salesmanage")
public class SellerController {
	@Autowired
	private ItemService itemservice;
	
	@Autowired
	private ReportService reportservice;
	
	@Autowired
	private StockService stockservice;
	
	@GetMapping("/manufacturer")
    public ResponseEntity<List<ManufacturModel>> getMamulist() {
		
		List<ManufacturModel> lst = itemservice.getpulldownlistManu();
		
		if (CollectionUtils.isEmpty(lst)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.ok(lst);
    }
    
	@GetMapping("/category")
    public ResponseEntity<List<CategoryModel>> getCatelist() {
		
		List<CategoryModel> lst = itemservice.getpulldownlistCat();
		
		if (CollectionUtils.isEmpty(lst)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.ok(lst);
    }
	
	@GetMapping("/subcategory")
    public ResponseEntity<List<SubCategoryModel>> getSubcatelist() {
		
		List<SubCategoryModel> lst = itemservice.getpulldownlistSubCat();
		
		if (CollectionUtils.isEmpty(lst)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.ok(lst);
    }
	
	
	@GetMapping("/report/{userId}")
    public ResponseEntity<List<ReportModel>> getReport(@PathVariable Integer userId) {
		
		List<ReportModel> lst = reportservice.getReport(userId);
		
		if (CollectionUtils.isEmpty(lst)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.ok(lst);
    }
	
	
	@GetMapping("/stock")
    public ResponseEntity<List<StockModel>> getStocks(@PathVariable Integer userId) {
		
		List<StockModel> lst = stockservice.getStock(userId);
		
		if (CollectionUtils.isEmpty(lst)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.ok(lst);
    }
	
	@PostMapping("/updatestock")
    public ResponseEntity<StockModel> andItem(@RequestBody StockModel model) {
		
		
	
		if(!stockservice.updateStocks(model)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	
		return ResponseEntity.status(HttpStatus.CREATED).body(model);
		
    }
	
	@PostMapping("/additem")
    public ResponseEntity<AdditemModel> andItem(@RequestBody AdditemModel item) {
		
		
		Boolean addrlt =itemservice.addItem(item);
		if(!addrlt) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	
		return ResponseEntity.status(HttpStatus.CREATED).body(item);
		
    }

}