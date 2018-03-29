package com.entrance.bean;

public class CollegeEnroll {
	@Override
	public String toString() {
		return "CollegeEnroll [id=" + id + ", college=" + college + ", areas=" + areas + ", subject=" + subject
				+ ", average=" + average + ", enrollment=" + enrollment + ", control_line=" + control_line
				+ ", shift_line=" + shift_line + ", batch=" + batch + ", year=" + year + ", highest_score="
				+ highest_score + ", lowest_score=" + lowest_score + "]";
	}

	private Integer id;
	private String college;
	private String areas;
	private String subject;
	private Integer average;
	private Integer enrollment;
	private Integer control_line;
	private Integer shift_line;
	private String batch;
	private Integer year;
	private Integer highest_score;
	private Integer lowest_score;

	public Integer getShift_line() {
		return shift_line;
	}

	public void setShift_line(Integer shift_line) {
		this.shift_line = shift_line;
	}

	public Integer getHighest_score() {
		return highest_score;
	}

	public void setHighest_score(Integer highest_score) {
		this.highest_score = highest_score;
	}

	public Integer getLowest_score() {
		return lowest_score;
	}

	public void setLowest_score(Integer lowest_score) {
		this.lowest_score = lowest_score;
	}

	public Integer getControl_line() {
		return control_line;
	}

	public void setControl_line(Integer control_line) {
		this.control_line = control_line;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getAreas() {
		return areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getAverage() {
		return average;
	}

	public void setAverage(Integer average) {
		this.average = average;
	}

	public Integer getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Integer enrollment) {
		this.enrollment = enrollment;
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
