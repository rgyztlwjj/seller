package com.sellerms.service;

import java.util.List;

import com.sellerms.models.*;

public interface ReportService {

	public List<ReportModel> getReport(Integer userId);
}