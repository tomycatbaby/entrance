package com.entrance.service;

import java.util.List;

import com.entrance.bean.AreasEnroll;

public interface AreasEnrollService {
	public List<AreasEnroll> findAreasEnroll( String areas, String subject,String batch,String year);
}
