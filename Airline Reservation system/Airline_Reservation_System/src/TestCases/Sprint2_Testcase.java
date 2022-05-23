package TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.ARS;
import application.Booking;
import application.Complain;

public class Sprint2_Testcase {
	
	@Test
	public void AddBooking() {
		ARS tempclass = new ARS();
		Booking temp = new Booking(10002,3002,4,4001,"Business");

		tempclass.Booking_list.add(temp);

		assertEquals(temp.string_Booking(), tempclass.Booking_list.get(0).string_Booking());

	}
	
	@Test
	public void Getbooking_ID() {
		ARS.getInstance().Populate();
		assertEquals(10001,ARS.getInstance().Booking_list.get(0).getBooking_ID());
	}
	
	@Test
	public void CancelBooking() {
		
		ARS.getInstance().Populate();
		ARS.getInstance().CancelBooking(10001);
		assertEquals(true,ARS.getInstance().Booking_list.isEmpty());
	}
	@Test
	public void viewSeatnumber() {
		
		ARS.getInstance().Populate();
		assertEquals(2,ARS.getInstance().Booking_list.get(0).getNum_Seats());
	}
	
	@Test
	public void AddComplain() {
		
		ARS tempclass = new ARS();
		Complain temp = new Complain(112,"My booking hasn't been cancelled");
		tempclass.Complain_list.add(temp);
		assertEquals(temp.string_complain(), tempclass.Complain_list.get(0).string_complain());

	}
	@Test
	public void testComplain() {
		ARS.getInstance().Populate();
		assertEquals(111,ARS.getInstance().Complain_list.get(0).getComplainID());
		
	}

	


}
