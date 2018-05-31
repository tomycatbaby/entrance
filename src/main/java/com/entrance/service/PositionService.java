package com.entrance.service;


import java.util.List;

import com.entrance.bean.Position;

public interface PositionService {
	public List<Position> findPosition( String year, String areas	,String college,String major);
}
