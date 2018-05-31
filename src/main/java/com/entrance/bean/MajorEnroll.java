package com.entrance.bean;

public class MajorEnroll {
private Integer id;
private String major;
private String college;
private Integer highest_score;
private Integer average;
private Integer rank;
private String subject;
private String areas;
private String batch;
private Integer year;

@Override
public String toString() {
	return "MajorEnroll [id=" + id + ", major=" + major + ", college=" + college + ", highest_score=" + highest_score
			+ ", average=" + average + ", rank=" + rank + ", subject=" + subject + ", areas=" + areas + ", batch="
			+ batch + ", year=" + year + "]";
}
public Integer getRank() {
	return rank;
}
public void setRank(Integer rank) {
	this.rank = rank;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
public Integer getHighest_score() {
	return highest_score;
}
public void setHighest_score(Integer highest_score) {
	this.highest_score = highest_score;
}
public Integer getAverage() {
	return average;
}
public void setAverage(Integer average) {
	this.average = average;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getAreas() {
	return areas;
}
public void setAreas(String areas) {
	this.areas = areas;
}
public String getBatch() {
	return batch;
}
public void setBatch(String batch) {
	this.batch = batch;
}
public Integer getYear() {
	return year;
}
public void setYear(Integer year) {
	this.year = year;
}
}
