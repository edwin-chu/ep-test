package com.sqa.ec.adactin;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class AdactinTC106 extends AdactinTest
{

	private String location = "Sydney";

	private String hotel = "Hotel Creek";

	private String roomType = "Standard";

	private String numberOfRooms = "3 - Three";

	private int checkInFromTodayDate = 0;

	private int checkOutFromTodayDate = 1;

	private String numberOfAdult = "1 - One";

	private String numberOfChildren = "0 - Zero";

	public void checkNumRooms()
	{
		int beginIndex = 0;
		int endIndex = 1;
		WebElement numRooms = getDriver().findElement(By.id("rooms_0"));
		String numOfRooms = numRooms.getAttribute("value");
		Assert.assertEquals(numOfRooms.substring(beginIndex, endIndex), this.numberOfRooms.substring(beginIndex, endIndex));
	}

	@Test
	public void roomDisplayTest()
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
		checkNumRooms();
	}
}
