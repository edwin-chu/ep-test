/**
 * File Name: AdactinTest.java<br>
 * Chu, Edwin<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 1, 2017
 */
package com.sqa.ec.adactin;

import java.text.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.sqa.ec.helpers.*;

/**
 * AdactinTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Chu, Edwin
 * @version 1.0.0
 * @since 1.0
 */
public abstract class AdactinTest extends AbstractLoginTest
{

	/**
	 * @param baseUrl
	 */
	public AdactinTest()
	{
		super("http://adactin.com/HotelApp");
	}

	public String enterCheckInDate(int checkInFromToday)
	{
		// enter current date + 7 days in check-in date field
		WebElement checkInDate = getDriver().findElement(By.id("datepick_in"));
		checkInDate.clear();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar checkIn = Calendar.getInstance();
		checkIn.setTime(new Date());	// today's date
		checkIn.add(Calendar.DATE, checkInFromToday);	// add 7 days
		System.out.println(dateFormat.format(checkIn.getTime()));
		checkInDate.sendKeys(dateFormat.format(checkIn.getTime()));
		return dateFormat.format(checkIn.getTime());
	}

	public String enterCheckOutDate(int checkOutFromToday)
	{
		// enter current date + 5 days in check-out date field
		WebElement checkOutDate = getDriver().findElement(By.id("datepick_out"));
		checkOutDate.clear();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar checkOut = Calendar.getInstance();
		checkOut.setTime(new Date());
		checkOut.add(Calendar.DATE, checkOutFromToday);
		System.out.println(dateFormat.format(checkOut.getTime()));
		checkOutDate.sendKeys(dateFormat.format(checkOut.getTime()));
		return dateFormat.format(checkOut.getTime());
	}

	public boolean isValuePresent(String value, WebElement element)
	{
		boolean valuePresent = false;
		Select selectDropdown = new Select(element);
		List<WebElement> listOfAllValue = selectDropdown.getOptions();
		for (WebElement i : listOfAllValue)
		{
			System.out.println(i.getText());
			if (value.equalsIgnoreCase(i.getText()))
			{
				valuePresent = true;
				System.out.println("Value Found!");
				break;
			}
		}
		return valuePresent;
	}

	@Override
	public void login(String username, String password)
	{
		this.takeScreenshot("Pre Login");
		WebElement usernameField = getDriver().findElement(By.id("username"));
		WebElement passwordField = getDriver().findElement(By.id("password"));
		WebElement loginButton = getDriver().findElement(By.id("login"));
		usernameField.clear();
		usernameField.sendKeys(username);
		passwordField.clear();
		passwordField.sendKeys(password);
		loginButton.click();
		this.takeScreenshot("Post Login");
	}

	@Override
	public void logout()
	{
		WebElement logoutField = getDriver().findElement(By.cssSelector("a[href='Logout.php']"));
		logoutField.click();
	}

	public void search()
	{
		// click search button to search
		WebElement searchButton = getDriver().findElement(By.id("Submit"));
		searchButton.click();
	}

	public void selectHotel(String hotel)
	{
		// select value "Hotel Creek" from hotels dropdown
		WebElement hotelsDropdown = getDriver().findElement(By.id("hotels"));
		hotelsDropdown.click();
		boolean foundHotel = isValuePresent(hotel, hotelsDropdown);
		Select selectHotelsDropdown = new Select(hotelsDropdown);
		if (foundHotel)
		{
			selectHotelsDropdown.selectByValue(hotel);
		} else
		{
			getLog().error("Test Failed: Hotel name " + hotel + " not found in the list.");
		}
	}

	public void selectLocation(String loc)
	{
		// select value "Sydney" from location dropdown
		WebElement locationDropdown = getDriver().findElement(By.id("location"));
		locationDropdown.click();
		boolean foundLocation = isValuePresent(loc, locationDropdown);
		Select selectLocDropdown = new Select(locationDropdown);
		if (foundLocation)
		{
			selectLocDropdown.selectByValue(loc);
		} else
		{
			getLog().error("Test Failed: Location " + loc + " not found in the list.");
		}
	}

	public void selectNumAdult(String numAdult)
	{
		WebElement numAdultDropdown = getDriver().findElement(By.id("adult_room"));
		numAdultDropdown.click();
		boolean foundNumAdult = isValuePresent(numAdult, numAdultDropdown);
		Select selectNumAdultDropdown = new Select(numAdultDropdown);
		if (foundNumAdult)
		{
			selectNumAdultDropdown.selectByVisibleText(numAdult);
		} else
		{
			getLog().error("Test Failed: Selection " + numAdult + "for number of adult is not available.");
		}
	}

	public void selectNumChildren(String numChildren)
	{
		// select value "0" from location dropdown
		WebElement numChildrenDropdown = getDriver().findElement(By.id("child_room"));
		numChildrenDropdown.click();
		boolean foundNumChildren = isValuePresent(numChildren, numChildrenDropdown);
		Select selectNumChildrenDropdown = new Select(numChildrenDropdown);
		if (foundNumChildren)
		{
			selectNumChildrenDropdown.selectByVisibleText(numChildren);
		} else
		{
			getLog().error("Test Failed! Selection " + numChildren + " for number of children is not available.");
		}
	}

	public void selectNumRooms(String numRooms)
	{
		// select value "1" from number of rooms dropdown
		WebElement numRoomsDropdown = getDriver().findElement(By.id("room_nos"));
		numRoomsDropdown.click();
		boolean foundNumRooms = isValuePresent(numRooms, numRoomsDropdown);
		Select selectNumRoomsDropdown = new Select(numRoomsDropdown);
		if (foundNumRooms)
		{
			selectNumRoomsDropdown.selectByVisibleText(numRooms);
		} else
		{
			getLog().error("Test Failed: Selected number of rooms " + numRooms + ", is not available.");
		}
	}

	public void selectRoomType(String roomType)
	{
		// select value "Standard" from room type dropdown
		WebElement roomTypeDropdown = getDriver().findElement(By.id("room_type"));
		roomTypeDropdown.click();
		boolean foundRoomType = isValuePresent(roomType, roomTypeDropdown);
		Select selectRoomTypeDropdown = new Select(roomTypeDropdown);
		if (foundRoomType)
		{
			selectRoomTypeDropdown.selectByValue(roomType);
		} else
		{
			getLog().error("Test Failed: Room type " + roomType + " not found in the list.");
		}
	}
}
