package com.workshop2.hotelsystem;

import java.util.HashMap;
import java.util.Map;

public class HotelReservation {
	Map<String, Integer> myMapHotel;

	public HotelReservation() {
		myMapHotel = new HashMap<>();
	}

	/**
	 * Adding function for hotel
	 * @param name
	 * @param rate
	 */
	public void add(String name, int rate) {
		myMapHotel.put(name, rate);
	}

	/**
	 * Getting the size for test
	 * @return
	 */
	public int size() {
		return myMapHotel.size();
	}
	
	public void printHotels() {
		for(Map.Entry<String, Integer> entry : myMapHotel.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation System");
	}

}
