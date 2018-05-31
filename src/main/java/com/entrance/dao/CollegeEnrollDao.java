package com.entrance.dao;

import java.util.List;

import com.entrance.bean.CollegeEnroll;

public interface CollegeEnrollDao {
	List<CollegeEnroll> selectCollegeEnroll(String college, String areas, String subject);

	List<CollegeEnroll> selectBy(String college, String areas, String subject, String batch, String year);
	
	int insert(CollegeEnroll collegeEnroll);
	List<CollegeEnroll> choose(String place, String areas, String subject, String batch, String year,String score);
}
