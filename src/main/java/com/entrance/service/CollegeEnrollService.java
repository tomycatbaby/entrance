package com.entrance.service;

import java.util.List;

import com.entrance.bean.CollegeEnroll;

public interface CollegeEnrollService {
	public List<CollegeEnroll> find(String college, String areas, String subject);

	public List<CollegeEnroll> searchBy(String college, String areas, String subject, String batch, String year);
}
