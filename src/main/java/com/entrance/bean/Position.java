package com.entrance.bean;

public class Position {
private Integer id;
private String areas;
private String college;
private String major;
private Integer year;
private String subject;
private Integer first;
private Integer second;
private Integer third;
private Integer fourth;
private Integer fifth;
private Integer sixth;
@Override
public String toString() {
	return "Position [id=" + id + ", areas=" + areas + ", college=" + college + ", major=" + major + ", year=" + year
			+ ", subject=" + subject + ", first=" + first + ", second=" + second + ", third=" + third + ", fourth="
			+ fourth + ", fifth=" + fifth + ", sixth=" + sixth + "]";
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getAreas() {
	return areas;
}
public void setAreas(String areas) {
	this.areas = areas;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public Integer getYear() {
	return year;
}
public void setYear(Integer year) {
	this.year = year;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public Integer getFirst() {
	return first;
}
public void setFirst(Integer first) {
	this.first = first;
}
public Integer getSecond() {
	return second;
}
public void setSecond(Integer second) {
	this.second = second;
}
public Integer getThird() {
	return third;
}
public void setThird(Integer third) {
	this.third = third;
}
public Integer getFourth() {
	return fourth;
}
public void setFourth(Integer fourth) {
	this.fourth = fourth;
}
public Integer getFifth() {
	return fifth;
}
public void setFifth(Integer fifth) {
	this.fifth = fifth;
}
public Integer getSixth() {
	return sixth;
}
public void setSixth(Integer sixth) {
	this.sixth = sixth;
}
}
