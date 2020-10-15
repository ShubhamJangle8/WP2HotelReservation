package com.workshop2.hotelsystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HotelReservationTest {

	@Test
	void WhenNewHotelAdded_ShouldReturn_true() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220));
		hotelReservation.printHotels();
	}

	@Test
	void WhenCheapestMethodCalled_ShouldReturn_nameOfHotelForSingleDay() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220));
		System.out.println("Cheapest Hotel for a single day : ");
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("10 Sep 2020", "11 Sep 2020"));
	}
	
	@Test
	void WhenCheapestMethodCalled_ShouldReturn_nameOfHotelForMultipleDays() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220));
		System.out.println("Cheapest Hotel for multiple days : ");
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("01 Sep 2020", "11 Sep 2020"));
	}

}