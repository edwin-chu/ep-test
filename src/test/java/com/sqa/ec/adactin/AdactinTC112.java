package com.sqa.ec.adactin;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class AdactinTC112 extends AdactinTest
{

	public void checkFinalBill(String rooms, int in, int out)
	{
		int gstPercent = 10;
		int daysStay = out - in;
		int totalRooms = Integer.valueOf(rooms.replaceAll("[^\\d]+", ""));
		WebElement pricePerNight = getDriver().findElement(By.id("price_night_dis"));
		String priceForOneNight = pricePerNight.getAttribute("value");
		int costPerNight = Integer.valueOf(priceForOneNight.replaceAll("[^\\d]+", ""));
		float expectedCost = (totalRooms * daysStay * costPerNight);
		float expectedCostWithTax = expectedCost * (100 + gstPercent) / 100;
		WebElement finalBill = getDriver().findElement(By.id("final_price_dis"));
		String finalPrice = finalBill.getAttribute("value");
		Assert.assertEquals(finalPrice, String.valueOf(expectedCostWithTax));
	}

	@Test(dataProvider = "dp")
	public void checkTotalPriceWithTax(String locationName, String hotelName, String roomType, String numRooms, int inDateFromToday, int outDateFromToday, String numAdult,
			String numChildren)
	{
		getLog().info("Booking a hotel room!");
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
		checkFinalBill(numRooms, inDateFromToday, outDateFromToday);
	}

	@DataProvider(name = "dp")
	public Object[][] dp()
	{
		return new Object[][]
		{ new Object[]
				{ "Sydney", "Hotel Creek", "Standard", "2 - Two", 0, 1, "1 - One", "0 - Zero" } };
	}
}
