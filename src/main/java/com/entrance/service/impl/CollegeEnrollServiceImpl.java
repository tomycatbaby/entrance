package com.entrance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrance.bean.CollegeEnroll;
import com.entrance.dao.CollegeEnrollDao;
import com.entrance.service.CollegeEnrollService;

@Service("collegeEnrollService")
public class CollegeEnrollServiceImpl implements CollegeEnrollService {
	@Autowired
	private CollegeEnrollDao collegeEnrollDao;

	public List<CollegeEnroll> find(String college) {

		return this.collegeEnrollDao.selectCollegeEnroll(college);
	}

}
