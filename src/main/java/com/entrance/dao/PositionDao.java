package com.entrance.dao;

import java.util.List;

import com.entrance.bean.Position;

public interface PositionDao {
	List<Position> getPosition(String year,String areas,String college,String major);
}
