package com.entrance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrance.bean.MajorEnroll;
import com.entrance.dao.MajorDao;
import com.entrance.service.MajorService;

@Service("majorService")
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorDao majorDao;

	public List<MajorEnroll> findMajor(String major, String areas, String subject, String batch, String year,int limit) {

		return this.majorDao.selectMajor(major, areas, subject, batch, year,limit);
	}

	public int findCount(String major, String areas, String subject, String batch, String year) {
		
		return this.majorDao.selectCount(major, areas, subject, batch, year);
	}

}
