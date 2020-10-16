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
	void WhenNewHotelAddedWithWeekEndRate_ShouldReturn_true() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		hotelReservation.printHotels();
	}
	
	@Test
	void WhenNewHotelAddedWithRating_ShouldReturn_true() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90, 3));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60, 4));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150, 5));
		hotelReservation.printHotels();
	}
	
	@Test
	void WhenCheapestMethodCalled_ShouldReturn_nameOfHotelForSingleDay() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		System.out.println("Cheapest Hotel for a single day using WeekDayRate : ");
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("10 Sep 2020", "11 Sep 2020"));
	}
	
	@Test
	void WhenCheapestMethodCalled_ShouldReturn_nameOfHotelForMultipleDays() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		System.out.println("Cheapest Hotel for multiple days using WeekDayRate : ");
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("01 Sep 2020", "11 Sep 2020"));
	}
	
	@Test
	void WhenCheapestMethodCalledForWeekEndAdded_ShouldReturn_nameOfHotelForSingleDay() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		System.out.println("Cheapest Hotel for a single day using additional WeekEndRate : ");
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("11 Sep 2020", "12 Sep 2020"));
	}
	
	@Test
	void WhenCheapestMethodCalledForWeekEndAdded_ShouldReturn_nameOfHotelForMultipleDays() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		System.out.println("Cheapest Hotel for multiple days using additional WeekEndRate : ");
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("01 Sep 2020", "11 Sep 2020"));
	}

}