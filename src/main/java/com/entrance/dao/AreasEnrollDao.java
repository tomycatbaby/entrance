package com.entrance.dao;

import java.util.List;

import com.entrance.bean.AreasEnroll;

public interface AreasEnrollDao {
	List<AreasEnroll> selectAreasEnroll( String areas, String subject,String batch,String year);
}
