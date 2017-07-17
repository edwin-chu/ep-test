package com.sqa.ec.adactin;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class AdactinTC103 extends AdactinTest
{

	private String location = "Sydney";

	private String hotel = "Hotel Creek";

	private String roomType = "Standard";

	private String numberOfRooms = "1 - One";

	private int checkInFromTodayDate = -5;

	private int checkOutFromTodayDate = -3;

	public void checkError()
	{
		try
		{ 	// get error messages
			String checkInDateError = getDriver().findElement(By.id("checkin_span")).getText();
			String checkOutDateError = getDriver().findElement(By.id("checkout_span")).getText();
			// declare expected message
			String expectedCheckInError = "Check-In Date shall be before than Check-Out Date";
			String expectedCheckOutError = "Check-Out Date shall be after than Check-In Date";
			// Assert actual and expected error messages
			Assert.assertEquals(checkInDateError, expectedCheckInError);
			Assert.assertEquals(checkOutDateError, expectedCheckOutError);
			getLog().info("Test Success! Error Message Display");
		} catch (NoSuchElementException e)
		{
			getLog().error("Test Failed! Error Message NOT Found");
		}
	}

	@Test
	public void dateErrorTest()
	{
		selectLocation(this.location);
		selectHotel(this.hotel);
		selectRoomType(this.roomType);
		selectNumRooms(this.numberOfRooms);
		enterCheckInDate(this.checkInFromTodayDate);
		enterCheckOutDate(this.checkOutFromTodayDate);
		search();
		checkError();
		System.out.println("Test Complete");
	}
}
