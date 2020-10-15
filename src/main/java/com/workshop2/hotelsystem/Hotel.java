package com.workshop2.hotelsystem;

public class Hotel {
	private String hotelName;
	private int regularWeekDay;

	public Hotel(String hotelName, int regularWeekDay) {
		super();
		this.hotelName = hotelName;
		this.regularWeekDay = regularWeekDay;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularWeekDayRate() {
		return regularWeekDay;
	}

	public void setRegularWeekDayRate(int regularWeekDay) {
		this.regularWeekDay = regularWeekDay;
	}

}
