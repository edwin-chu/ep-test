package com.sqa.ec.adactin;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class AdactinTC107 extends AdactinTest
{

	private String location = "Sydney";

	private String hotel = "Hotel Creek";

	private String roomType = "Deluxe";

	private String numberOfRooms = "1 - One";

	private int checkInFromTodayDate = 0;

	private int checkOutFromTodayDate = 1;

	private String numberOfAdult = "1 - One";

	private String numberOfChildren = "0 - Zero";

	public void checkRoomTypeError(String rmType)
	{
		WebElement typeOfRoom = getDriver().findElement(By.id("room_type_0"));
		String room = typeOfRoom.getAttribute("value");
		Assert.assertEquals(this.roomType, room);
	}

	@Test
	public void checkRoomTypeTest()
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
		checkRoomTypeError(this.roomType);
	}
}
