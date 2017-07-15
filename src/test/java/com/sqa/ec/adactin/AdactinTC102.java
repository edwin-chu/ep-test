/**
 * File Name: AdactinTC102.java<br>
 * Chu, Edwin<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 7, 2017
 */
package com.sqa.ec.adactin;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

/**
 * AdactinTC102 //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Chu, Edwin
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC102 extends AdactinTest
{

	private String location = "Sydney";

	private String hotel = "Hotel Creek";

	private String hotelType = "Standard";

	private String numberOfRooms = "1";

	private int checkInFromTodayDate = 7;

	private int checkOutFromTodayDate = 5;

	public void checkError()
	{
		try
		{
			// get error messages
			String checkInDateError = getDriver().findElement(By.id("checkin_span")).getText();
			String checkOutDateError = getDriver().findElement(By.id("checkout_span")).getText();
			// declare expected message
			String expectedCheckInError = "Check-In Date shall be before than Check-Out Date";
			String expectedCheckOutError = "Check-Out Date shall be after than Check-In Date";
			// Assert actual and expected error messages
			Assert.assertEquals(checkInDateError, expectedCheckInError);
			Assert.assertEquals(checkOutDateError, expectedCheckOutError);
			getLog().info("Test Success!");
		} catch (NoSuchElementException e)
		{
			// TODO Auto-generated catch block
			getLog().error("Test Failed!  Error message not found");
		}
	}

	@Test
	public void dateErrorTest()
	{
		selectLocation(this.location);
		selectHotel(this.hotel);
		selectRoomType(this.hotelType);
		selectNumRooms(this.numberOfRooms);
		enterCheckInDate(this.checkInFromTodayDate);
		enterCheckOutDate(this.checkOutFromTodayDate);
		search();
		checkError();
		getLog().info("Test Complete");
	}
}
