package com.sellerms.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sellerms.entity.*;
import com.sellerms.repository.*;


import com.sellerms.models.*;;

@Service
public class ReportServiceImpl implements ReportService {
	private static final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);
	

	@Autowired
	private ItemsRepository itemsrepository;
	
	
	@Override
	public List<ReportModel> getReport(Integer userId) {
		

		List<ItemsEntity> lstEntity = itemsrepository.findBySellerId(userId);
		
		if (CollectionUtils.isEmpty(lstEntity)) {
			log.info("No reports" + userId);
			return null;
		}
		
		List<ReportModel> lstModel = new ArrayList<ReportModel>(lstEntity.size());

		lstEntity.stream().forEach(entity -> lstModel.add(conver(entity)));
		
		return lstModel;		
	}



	private ReportModel conver(ItemsEntity entity) {
		ReportModel reportModel= new ReportModel();
		
		BeanUtils.copyProperties(entity, reportModel);
		
		return reportModel;
	}
}
	

