package com.entrance.service;

import java.util.List;

import com.entrance.bean.MajorEnroll;

public interface MajorService {
	public List<MajorEnroll> findMajor(String major, String areas, String subject, String batch, String year,
			int limit);

	public int findCount(String major, String areas, String subject, String batch, String year);
	public List<MajorEnroll> getCollege(String place,String areas,String subject,String batch,String year);
	public List<MajorEnroll> getMajor(String place,String areas,String subject,String batch,String year,String college);
	public List<MajorEnroll> rank(String place,String areas,String subject,String batch,String year,String college,String rank,String major);

}
