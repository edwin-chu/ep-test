package com.sqa.ec.adactin;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class AdactinTC111 extends AdactinTest
{

	public void checkInfo(String loc, String hotel, String typeOfRoom, int in, int out, String selectHotelPrice)
	{
		compareLocation(loc);
		compareHotel(hotel);
		compareType(typeOfRoom);
		compareTotalDay(in, out);
		comparePricePerNight(selectHotelPrice);
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
		String selectPage = selectHotelPagePricePerNight();
		makeSelection();
		checkInfo(locationName, hotelName, roomType, inDateFromToday, outDateFromToday, selectPage);
	}

	public void compareHotel(String inn)
	{
		WebElement placeToStay = getDriver().findElement(By.id("hotel_name_dis"));
		String bookingPageHotel = placeToStay.getAttribute("value");
		Assert.assertEquals(bookingPageHotel, inn);
	}

	public void compareLocation(String location)
	{
		WebElement cityLocation = getDriver().findElement(By.id("location_dis"));
		String bookingPageLocation = cityLocation.getAttribute("value");
		Assert.assertEquals(bookingPageLocation, location);
	}

	public void comparePricePerNight(String selectPagePPN)
	{
		WebElement pricePerNight = getDriver().findElement(By.id("price_night_dis"));
		String bookingPagePPN = pricePerNight.getAttribute("value");
		Assert.assertEquals(bookingPagePPN, selectPagePPN);
	}

	public void compareTotalDay(int inDate, int outDate)
	{
		int totalDays = outDate - inDate;
		WebElement numDays = getDriver().findElement(By.id("total_days_dis"));
		String bookingPageNumDays = numDays.getAttribute("value");
		int bookingPageTotalDays = Integer.parseInt(bookingPageNumDays.replaceAll("[^\\d]+", ""));
		Assert.assertEquals(String.valueOf(bookingPageTotalDays), String.valueOf(totalDays));
	}

	public void compareType(String rmType)
	{
		WebElement rType = getDriver().findElement(By.id("room_type_dis"));
		String bookingPageRoomType = rType.getAttribute("value");
		Assert.assertEquals(bookingPageRoomType, rmType);
	}

	@DataProvider(name = "dp")
	public Object[][] dp()
	{
		return new Object[][]
		{ new Object[]
				{ "Sydney", "Hotel Creek", "Standard", "2 - Two", 0, 1, "1 - One", "0 - Zero" } };
	}

	public String selectHotelPagePricePerNight()
	{
		WebElement selectPagePrice = getDriver().findElement(By.id("price_night_0"));
		String selectHotelPagePrice = selectPagePrice.getAttribute("value");
		return selectHotelPagePrice;
	}
}
