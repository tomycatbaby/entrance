package com.entrance.service;

import java.util.List;

import com.entrance.bean.MajorEnroll;

public interface MajorService {
	public List<MajorEnroll> findMajor(String major, String areas, String subject, String batch, String year,
			int limit);

	public int findCount(String major, String areas, String subject, String batch, String year);
}
