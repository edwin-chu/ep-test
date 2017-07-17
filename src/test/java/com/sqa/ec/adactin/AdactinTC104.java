/**
 * File Name: AdactinTC104.java<br>
 * Chu, Edwin<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 14, 2017
 */
package com.sqa.ec.adactin;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

/**
 * AdactinTC104 //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Chu, Edwin
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC104 extends AdactinTest
{

	private String location = "Sydney";

	private String hotel = "Hotel Creek";

	private String roomType = "Standard";

	private String numberOfRooms = "1 - One";

	private int checkInFromTodayDate = 0;

	private int checkOutFromTodayDate = 1;

	private String numberOfChildren = "0 - Zero";

	public void checkError()
	{
		String location = getDriver().findElement(By.id("location_0")).getAttribute("value");
		String expectedLocation = location;
		Assert.assertEquals(location, expectedLocation);
		getLog().info("Test Success! Location " + location + " found in search Hotel form.");
	}

	@Test
	public void locationErrorTest()
	{
		selectLocation(this.location);
		selectHotel(this.hotel);
		selectRoomType(this.roomType);
		selectNumRooms(this.numberOfRooms);
		enterCheckInDate(this.checkInFromTodayDate);
		enterCheckOutDate(this.checkOutFromTodayDate);
		selectNumChildren(this.numberOfChildren);
		search();
		checkError();
		System.out.println("Test Complete");
	}
}
