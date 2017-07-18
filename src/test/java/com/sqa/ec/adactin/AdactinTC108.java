package com.sqa.ec.adactin;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class AdactinTC108 extends AdactinTest
{

	private String location = "Sydney";

	private String hotel = "Hotel Creek";

	private String roomType = "Standard";

	private String numberOfRooms = "2 - Two";

	private int checkInFromTodayDate = 0;

	private int checkOutFromTodayDate = 1;

	private String numberOfAdult = "1 - One";

	private String numberOfChildren = "0 - Zero";

	@Test
	public void totalPriceTest()
	{
		selectLocation(this.location);
		selectHotel(this.hotel);
		selectRoomType(this.roomType);
		selectNumRooms(this.numberOfRooms);
		enterCheckInDate(this.checkInFromTodayDate);
		enterCheckOutDate(this.checkOutFromTodayDate);
		selectNumAdult(this.numberOfAdult);
		selectNumChildren(this.numberOfChildren);
		search();
		verifyPrice();
	}

	public void verifyPrice()
	{
		// parse int value of String variable numberOfRooms
		int totalRooms = Integer.valueOf(this.numberOfRooms.replaceAll("[^\\d]+", ""));
		int totalNight = this.checkOutFromTodayDate - this.checkInFromTodayDate;
		// declare WebElement for price per night field and get the value of
		// attribute in String
		WebElement pricePerNight = getDriver().findElement(By.id("price_night_0"));
		String perNightPrice = pricePerNight.getAttribute("value");
		// parse the value of price per night from String to int value
		int costPerNight = Integer.valueOf(perNightPrice.replaceAll("[^\\d]+", ""));
		// calculate total cost in int value
		int expectedCost = totalRooms * totalNight * costPerNight;
		// declare WebElement for total price field and get the attribute value
		// in String
		WebElement price = getDriver().findElement(By.id("total_price_0"));
		String totalPrice = price.getAttribute("value");
		// parse the value of totalPrice from String to int
		int actualTotalCost = Integer.valueOf(totalPrice.replaceAll("[^\\d]+", ""));
		// Assert two String - convert float values of actualTotalCost
		// and expectedCost to String
		Assert.assertEquals(String.valueOf(actualTotalCost), String.valueOf(expectedCost));
	}
}
