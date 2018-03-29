package com.entrance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrance.bean.AreasEnroll;
import com.entrance.dao.AreasEnrollDao;
import com.entrance.service.AreasEnrollService;

@Service("areasEnrollService")
public class AreasEnrollServiceImpl implements AreasEnrollService {
	@Autowired
	private AreasEnrollDao areasEnrollDao;

	public List<AreasEnroll> findAreasEnroll(String areas, String subject, String batch, String year) {

		return this.areasEnrollDao.selectAreasEnroll(areas, subject, batch, year);
	}

}
