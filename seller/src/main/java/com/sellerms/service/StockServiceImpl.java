package com.sellerms.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.descriptor.tld.ImplicitTldRuleSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sellerms.entity.*;
import com.sellerms.repository.*;

import javassist.expr.NewArray;

import com.sellerms.models.*;;

@Service
public class StockServiceImpl implements StockService {
	
	private static final Logger log = LoggerFactory.getLogger(StockServiceImpl.class);

	@Autowired
	private ItemsRepository itemsrepository;

	/**
	 * 
	 */
	@Override
	public List<StockModel> getStock(Integer userId) {
		

		List<ItemsEntity> lstEntity = itemsrepository.findBySellerId(userId);
		
		if (CollectionUtils.isEmpty(lstEntity)) {
			log.info("No stocks" + userId);
			return null;
		}
		
		List<StockModel> lstModel = new ArrayList<StockModel>(lstEntity.size());

		lstEntity.stream().forEach(entity -> lstModel.add(conver(entity)));
		
		return lstModel;		
	}



	/**
	 * 
	 * @param entity
	 * @return
	 */
	private StockModel conver(ItemsEntity entity) {
		StockModel stockmodel= new StockModel();
		
		BeanUtils.copyProperties(entity, stockmodel);
		
		return stockmodel;
	}



	@Override
	public boolean updateStocks(StockModel stockmodel) {
		
		ItemsEntity updatobjEntity =itemsrepository.findById(stockmodel.getItemId()).orElse(null);
		if (updatobjEntity == null) {

			return false;
		}
		try {
			itemsrepository.save(updatobjEntity);
		} catch (Exception e) {
			
			return false;
		}
		return true;
	}



	

	
}
	

