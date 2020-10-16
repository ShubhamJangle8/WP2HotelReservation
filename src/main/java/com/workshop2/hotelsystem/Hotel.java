package com.workshop2.hotelsystem;

public class Hotel {
	private String name;
	private int regularWeekDayRate;
	private int regularWeekEndRate;
	private int rating;

	public Hotel(String name, int regularWeekday) {
		this.name = name;
		this.regularWeekDayRate = regularWeekday;
	}

	public Hotel(String name, int regularWeekday, int regularWeekend) {
		this.name = name;
		this.regularWeekDayRate = regularWeekday;
		this.regularWeekEndRate = regularWeekend;
	}
	
	public Hotel(String name, int regularWeekday, int regularWeekend, int rating) {
		this.name = name;
		this.regularWeekDayRate = regularWeekday;
		this.regularWeekEndRate = regularWeekend;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegularWeekDayRate() {
		return regularWeekDayRate;
	}

	public void setRegularWeekDayRate(int regularWeekday) {
		this.regularWeekDayRate = regularWeekday;
	}

	public int getRegularWeekEndRate() {
		return regularWeekEndRate;
	}

	public void setRegularWeekEndRate(int regularWeekend) {
		this.regularWeekEndRate = regularWeekend;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
