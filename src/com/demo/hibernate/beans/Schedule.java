package com.demo.hibernate.beans;
// Generated 2016-4-24 22:36:56 by Hibernate Tools 3.5.0.Final

/**
 * Schedule generated by hbm2java
 */
public class Schedule{

	private Integer id;
	private String username;
	private Integer year;
	private Integer month;
	private Integer day;
	private String plan;

	public Schedule() {
	}

	public Schedule(String username) {
		this.username = username;
	}

	public Schedule(String username, Integer year, Integer month, Integer day, String plan) {
		this.username = username;
		this.year = year;
		this.month = month;
		this.day = day;
		this.plan = plan;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getPlan() {
		return this.plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

}