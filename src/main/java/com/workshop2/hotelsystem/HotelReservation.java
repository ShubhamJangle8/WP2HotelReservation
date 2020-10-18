package com.workshop2.hotelsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HotelReservation {
	private static Map<String, Hotel> hotelMap;

	public HotelReservation() {
		hotelMap = new HashMap<>();
	}

	/**
	 * Adding new hotel to list of hotels
	 */
	public boolean addHotel(String name, int regularWeekDayRate) {
		Hotel hotel = new Hotel(name, regularWeekDayRate);
		hotelMap.put(name, hotel);
		return true;
	}

	public boolean addHotel(String name, int regularWeekDayRate, int regularWeekEndRate) {
		Hotel hotel = new Hotel(name, regularWeekDayRate, regularWeekEndRate);
		hotelMap.put(name, hotel);
		return true;
	}

	public boolean addHotel(String name, int regularWeekDayRate, int regularWeekEndRate, int rating) {
		Hotel hotel = new Hotel(name, regularWeekDayRate, regularWeekEndRate, rating);
		hotelMap.put(name, hotel);
		return true;
	}

	public boolean addHotel(String name, int regularWeekDayRate, int regularWeekEndRate, int rating,
			int rewardsWeekDayRate, int rewardsWeekEndRate) {
		Hotel hotel = new Hotel(name, regularWeekDayRate, regularWeekEndRate, rating, rewardsWeekDayRate,
				rewardsWeekEndRate);
		hotelMap.put(name, hotel);
		return true;
	}

	/**
	 * Printing all hotels and rates present in the list
	 * 
	 */
	public void printHotels() {
		for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			System.out.println("Hotel Name : " + entry.getKey());
			System.out.println("Rate for regular customer for weekday : " + entry.getValue().getRegularWeekDayRate()
					+ " / day\n" + "Rate for regular customer for weekEnd : " + entry.getValue().getRegularWeekEndRate()
					+ " / day\n" + "Rating for the Hotel : " + entry.getValue().getRating() + "\n"
					+ "Rate for the rewards customer on weekdays : " + entry.getValue().getRewardsWeekDayRate() + "\n"
					+ "Rate for the rewards customer on weekends : " + entry.getValue().getRewardsWeekEndRate() + "\n");
		}
	}

	/**
	 * find cheap hotel for given date range
	 */
	public String findCheapestHotel(String fromDate, String toDate) {
		Map<Integer, ArrayList<Hotel>> rentMap = createRentMap(fromDate, toDate);
		int minimumRent = Integer.MAX_VALUE;
		for (Map.Entry<Integer, ArrayList<Hotel>> entry : rentMap.entrySet()) {
			if (entry.getKey() < minimumRent)
				minimumRent = entry.getKey();
		}
		ArrayList<Hotel> cheapestHotels = rentMap.get(minimumRent);
		for (Hotel hotel : cheapestHotels) {
			System.out.println(
					hotel.getName() + ", Rating:" + hotel.getRating() + " and Total Rates: $" + minimumRent + "\n");
		}
		return rentMap.get(minimumRent).get(0).getName();
	}

	/**
	 * finding cheap for best rated
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public String findCheapestBestRatedHotel(String fromDate, String toDate) {
		Map<Integer, ArrayList<Hotel>> rentMap = createRentMap(fromDate, toDate);
		int minimumRent = Integer.MAX_VALUE;
		for (Map.Entry<Integer, ArrayList<Hotel>> entry : rentMap.entrySet()) {
			if (entry.getKey() < minimumRent)
				minimumRent = entry.getKey();
		}
		ArrayList<Hotel> cheapestHotels = rentMap.get(minimumRent);
		int rating = 0;
		for (Hotel hotel : cheapestHotels) {
			if (hotel.getRating() > rating) {
				rating = hotel.getRating();
			}
		}
		System.out.println(rentMap.get(minimumRent).get(0).getName() + ", Rating:"
				+ rentMap.get(minimumRent).get(0).getRating() + " and Total Rates: $" + minimumRent + "\n");
		return rentMap.get(minimumRent).get(0).getName();
	}

	public int calculateRent(String fromDate, String toDate, int weekDayRate, int weekEndRate) {
		int[] numOfDays = numberOfDays(fromDate, toDate);
		int weekdayRent = weekDayRate * numOfDays[0];
		int weekendRent = weekEndRate * numOfDays[1];
		int totalRent = weekdayRent + weekendRent;
		return totalRent;
	}

	/**
	 * find best Rated hotel for a date range
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public String bestRatedHotelForRange(String fromDate, String toDate) {
		int rent = 0;
		String bestHotelRated = "";
		int rating = 0;
		for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			if (entry.getValue().getRating() > rating) {
				rating = entry.getValue().getRating();
				bestHotelRated = entry.getKey();
				rent = calculateRent(fromDate, toDate, entry.getValue().getRegularWeekDayRate(),
						entry.getValue().getRegularWeekEndRate());
			}
		}
		System.out.println(bestHotelRated + " & Total Rates $" + rent + "\n");
		return bestHotelRated;
	}

	/**
	 * creates a map having rent as key and list of hotels as value
	 */
	public static Map<Integer, ArrayList<Hotel>> createRentMap(String fromDate, String toDate) {
		HashMap<Integer, ArrayList<Hotel>> rentMap = new HashMap<>();
		int[] numOfDays = numberOfDays(fromDate, toDate);
		for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			int weekdayRent = entry.getValue().getRegularWeekDayRate() * numOfDays[0];
			int weekendRent = entry.getValue().getRegularWeekEndRate() * numOfDays[1];
			int totalRent = weekdayRent + weekendRent;
			rentMap.computeIfAbsent(totalRent, k -> new ArrayList<>()).add(entry.getValue());
		}
		return rentMap;
	}

	/**
	 * returns number of days in the given range
	 */
	public static int[] numberOfDays(String fromDate, String toDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
		// convert String to LocalDate
		LocalDate from = LocalDate.parse(fromDate, formatter);
		LocalDate to = LocalDate.parse(toDate, formatter);
		int numOfweekdays = 0;
		int numOfWeekends = 0;
		for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
			DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
			switch (day) {
			case SATURDAY:
				numOfWeekends++;
				break;
			case SUNDAY:
				numOfWeekends++;
				break;
			default:
				numOfweekdays++;
				break;
			}
		}
		return new int[] { numOfweekdays, numOfWeekends };
	}

}