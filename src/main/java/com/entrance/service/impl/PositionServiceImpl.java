package com.entrance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrance.bean.Position;
import com.entrance.dao.PositionDao;
import com.entrance.service.PositionService;
@Service("positionService")
public class PositionServiceImpl implements PositionService{
	@Autowired
	private PositionDao positionDao;
	public PositionDao getPositionDao() {
		return positionDao;
	}
	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}
	public List<Position> findPosition(String year, String areas, String college, String major) {
		
		return this.positionDao.getPosition(year, areas, college, major);
	}

}
