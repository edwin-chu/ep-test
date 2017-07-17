package com.sqa.ec.adactin;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class AdactinTC105 extends AdactinTest
{

	private String location = "Sydney";

	private String hotel = "Hotel Creek";

	private String roomType = "Standard";

	private String numberOfRooms = "1 - One";

	private int checkInFromTodayDate = 0;

	private int checkOutFromTodayDate = 1;

	private String numberOfAdult = "1 - One";

	private String numberOfChildren = "0 - Zero";

	public void checkError(String arrDate, String depDate)
	{
		WebElement checkInDate = getDriver().findElement(By.id("arr_date_0"));
		WebElement checkOutDate = getDriver().findElement(By.id("dep_date_0"));
		String expectedCheckInDate = checkInDate.getAttribute("value");
		String expectedCheckOutDate = checkOutDate.getAttribute("value");
		Assert.assertEquals(arrDate, expectedCheckInDate);
		Assert.assertEquals(depDate, expectedCheckOutDate);
	}

	@Test
	public void dateDisplayTest()
	{
		selectLocation(this.location);
		selectHotel(this.hotel);
		selectRoomType(this.roomType);
		selectNumRooms(this.numberOfRooms);
		String arrivalDate = enterCheckInDate(this.checkInFromTodayDate);
		String departureDate = enterCheckOutDate(this.checkOutFromTodayDate);
		selectNumAdult(this.numberOfAdult);
		selectNumChildren(this.numberOfChildren);
		search();
		checkError(arrivalDate, departureDate);
		System.out.println("Test Complete");
	}
}
