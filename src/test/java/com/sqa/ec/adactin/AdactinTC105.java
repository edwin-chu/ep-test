package com.sqa.ec.adactin;

public class AdactinTC105 extends AdactinTest
{

	private String location = "Sydney";

	private String hotel = "Hotel Creek";

	private String hotelType = "Standard";

	private String numberOfRooms = "1";

	private int checkInFromTodayDate = 0;

	private int checkOutFromTodayDate = 1;

	private String numberOfAdult = "1";

	private String numerOfChildren = "0";

	public void dateDisplayTest()
	{
		selectLocation(this.location);
		selectHotel(this.hotel);
		selectRoomType(this.hotelType);
		selectNumRooms(this.numberOfRooms);
		enterCheckInDate(this.checkInFromTodayDate);
		enterCheckOutDate(this.checkOutFromTodayDate);
		selectNumAdult(this.numberOfAdult);
		selectNumChildren(this.numerOfChildren);
		search();
		System.out.println("Test Complete");
	}
}
