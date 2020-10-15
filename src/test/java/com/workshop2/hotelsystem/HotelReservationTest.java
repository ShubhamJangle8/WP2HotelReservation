package com.workshop2.hotelsystem;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class HotelReservationTest {

	/**
	 * Adding the data of UC1
	 */
	@Test
	void GivenThreeHotels_WhenAddedToMap_PassingTest() {
		HotelReservation hotel = new HotelReservation();
		hotel.add("LakeWood", 110);
		hotel.add("BridgeWood", 160);
		hotel.add("RidgeWood", 220);
		int result = hotel.size();
		hotel.printHotels();
		Assert.assertEquals(3, result);
	}

}
