package com.entrance.dao;

import java.util.List;

import com.entrance.bean.MajorEnroll;

public interface MajorDao {
	List<MajorEnroll> selectMajor(String major,String areas,String subject,String batch,String year,int limit);
	int selectCount(String major,String areas,String subject,String batch,String year);
	List<MajorEnroll> getCollege(String place,String areas,String subject,String batch,String year);
	List<MajorEnroll> getMajor(String place,String areas,String subject,String batch,String year,String college);
	List<MajorEnroll> rank(String place,String areas,String subject,String batch,String year,String college,String rank,String major);

}
