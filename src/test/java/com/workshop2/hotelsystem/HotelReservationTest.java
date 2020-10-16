package com.workshop2.hotelsystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HotelReservationTest {
	//UC1
	@Test
	void WhenNewHotelAdded_ShouldReturn_true() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220));
		System.out.println("1");
		hotelReservation.printHotels();
	}
//	UC3
	@Test
	void WhenNewHotelAddedWithWeekEndRate_ShouldReturn_true() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		System.out.println("2");
		hotelReservation.printHotels();
	}
//	UC5
	@Test
	void WhenNewHotelAddedWithRating_ShouldReturn_true() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90, 3));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60, 4));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150, 5));
		System.out.println("3");
		hotelReservation.printHotels();
	}
//	UC2
	@Test
	void WhenCheapestMethodCalled_ShouldReturn_nameOfHotelForSingleDay() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220));
		System.out.println("4 Cheapest Hotel for a single day using WeekDayRate : ");
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("10 Sep 2020", "11 Sep 2020"));
	}
	
	@Test
	void WhenCheapestMethodCalled_ShouldReturn_nameOfHotelForMultipleDays() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		System.out.println("5 Cheapest Hotel for multiple days using WeekDayRate : ");
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("01 Sep 2020", "11 Sep 2020"));
	}
//	UC4
	@Test
	void WhenCheapestMethodCalledForWeekEndAdded_ShouldReturn_nameOfHotelForSingleDay1() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		System.out.println("6 Cheapest Hotel for a single day using additional WeekEndRate : ");
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("11 Sep 2020", "12 Sep 2020"));
	}
	
	@Test
	void WhenCheapestMethodCalledForWeekEndAdded_ShouldReturn_nameOfHotelForSingleDay2() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservation.addHotel("Bridgewood", 150, 50));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		System.out.println("7 Cheapest Hotel for a single day using additional WeekEndRate : ");
		assertEquals("Bridgewood", hotelReservation.findCheapestHotel("11 Sep 2020", "12 Sep 2020"));
	}
	
	@Test
	void WhenCheapestMethodCalledForWeekEndAdded_ShouldReturn_nameOfHotelForMultipleDays() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		System.out.println("8 Cheapest Hotel for multiple days using additional WeekEndRate : ");
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("01 Sep 2020", "11 Sep 2020"));
	}
//	UC6
	@Test
	void WhenCheapestMethodCalledForRatings_ShouldReturn_nameOfHotelForSingleDayAllDay() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90, 3));
		assertTrue(hotelReservation.addHotel("Bridgewood", 150, 50, 4));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150, 5));
		System.out.println("9 Cheapest Hotel for multiple days using additional ratings : ");
		assertEquals("Bridgewood", hotelReservation.findCheapestBestRatedHotel("11 Sep 2020", "12 Sep 2020"));
	}
	//UC6
	@Test
	void WhenCheapestMethodCalledForRatings_ShouldReturn_nameOfHotelForSingleDayWeekDay() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90, 3));
		assertTrue(hotelReservation.addHotel("Bridgewood", 150, 50, 4));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150, 5));
		System.out.println("10 Cheapest Hotel for multiple days using additional ratings : ");
		assertEquals("Lakewood", hotelReservation.findCheapestBestRatedHotel("10 Sep 2020", "11 Sep 2020"));
	}

}