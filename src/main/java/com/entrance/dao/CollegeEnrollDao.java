package com.entrance.dao;

import java.util.List;

import com.entrance.bean.CollegeEnroll;

public interface CollegeEnrollDao {
	List<CollegeEnroll> selectCollegeEnroll(String college);
}
