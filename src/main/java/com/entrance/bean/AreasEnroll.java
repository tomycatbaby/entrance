package com.entrance.bean;

public class AreasEnroll {
	private Integer id;
	private String areas;
	private String subject;
	private Integer control_line;
	private Integer year;
	private String batch;

	@Override
	public String toString() {
		return "AreasEnroll [id=" + id + ", areas=" + areas + ", subject=" + subject + ", control_line=" + control_line
				+ ", year=" + year + ", batch=" + batch + "]";
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getControl_line() {
		return control_line;
	}

	public void setControl_line(Integer control_line) {
		this.control_line = control_line;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}
}
