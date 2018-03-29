package com.entrance.dao;

import java.util.List;

import com.entrance.bean.MajorEnroll;

public interface MajorDao {
	List<MajorEnroll> selectMajor(String major,String areas,String subject,String batch,String year,int limit);
	int selectCount(String major,String areas,String subject,String batch,String year);
}
