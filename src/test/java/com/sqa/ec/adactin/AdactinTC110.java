package com.sqa.ec.adactin;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class AdactinTC110 extends AdactinTest
{

	public void checkPrice(String nRooms, int in, int out)
	{
		// % for GST
		float gst = 10;
		// parse int value of String numRooms
		int totalRooms = Integer.valueOf(nRooms.replaceAll("[^\\d]+", ""));
		// calculate number of nights stay at the hotel
		int numNight = out - in;
		// declare WebElement price per night display and get value of attribute
		// in String
		WebElement costPerNight = getDriver().findElement(By.id("price_night_dis"));
		String pricePerNight = costPerNight.getAttribute("value");
		// parse value of pricePerNight and get float value from that String
		float perNightCost = Float.valueOf(pricePerNight.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
		// calculate expectedCost
		float expectedCost = (totalRooms * numNight * perNightCost) * (100 + gst) / 100;
		// declare WebElement finalCost display and get value of attribute in
		// String
		WebElement finalCost = getDriver().findElement(By.id("final_price_dis"));
		String actualCost = finalCost.getAttribute("value");
		// parse value of actualCost and get float value from that String
		float actualTotalCost = Float.valueOf(actualCost.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
		// Assert two Strings - convert float value of actual and expected cost
		// to String
		Assert.assertEquals(String.valueOf(actualTotalCost), expectedCost);
	}

	@Test(dataProvider = "dp")
	public void checkTotalPriceWithTax(String locationName, String hotelName, String roomType, String numRooms, int inDateFromToday, int outDateFromToday, String numAdult,
			String numChildren)
	{
		getLog().info("Booking a hotel room");
		selectLocation(locationName);
		selectHotel(hotelName);
		selectRoomType(roomType);
		selectNumRooms(numRooms);
		enterCheckInDate(inDateFromToday);
		enterCheckOutDate(outDateFromToday);
		selectNumAdult(numAdult);
		selectNumChildren(numChildren);
		search();
		makeSelection();
		checkPrice(numRooms, inDateFromToday, outDateFromToday);
	}

	@DataProvider(name = "dp")
	public Object[][] dp()
	{
		return new Object[][]
		{ new Object[]
				{ "Melbourne", "Hotel Creek", "Standard", "2 - Two", 0, 1, "1 - One", "0 - Zero" } };
	}
}
