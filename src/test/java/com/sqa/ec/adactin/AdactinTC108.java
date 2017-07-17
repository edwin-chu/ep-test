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
		int beginIndex = 0;
		int endIndex = 1;
		int perNightPriceInDigit = 3;
		int totalCostInDigit = 3;
		int totalRooms = Integer.parseInt(this.numberOfRooms.substring(beginIndex, endIndex));
		int totalNight = this.checkOutFromTodayDate - this.checkInFromTodayDate;
		WebElement pricePerNight = getDriver().findElement(By.id("price_night_0"));
		String perNightPrice = pricePerNight.getAttribute("value");
		int costPerNight = Integer.parseInt(perNightPrice.substring(perNightPrice.length() - perNightPriceInDigit, perNightPrice.length()));
		int totalCost = totalRooms * totalNight * costPerNight;
		WebElement price = getDriver().findElement(By.id("total_price_0"));
		String totalPrice = price.getAttribute("value");
		Assert.assertEquals(totalPrice.substring(totalPrice.length() - totalCostInDigit, totalPrice.length()), String.valueOf(totalCost));
	}
}
