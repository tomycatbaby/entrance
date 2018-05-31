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

	public List<CollegeEnroll> find(String college, String areas, String subject) {

		return this.collegeEnrollDao.selectCollegeEnroll(college, areas, subject);
	}

	public List<CollegeEnroll> searchBy(String college, String areas, String subject, String batch, String year) {

		return this.collegeEnrollDao.selectBy(college, areas, subject, batch, year);
	}

	public void addCollege(CollegeEnroll college) {
		this.collegeEnrollDao.insert(college);
		
	}

	public List<CollegeEnroll> choose(String place, String areas, String subject, String batch, String year,String score) {
		
		return this.collegeEnrollDao.choose(place, areas, subject, batch, year,score);
	}

}
