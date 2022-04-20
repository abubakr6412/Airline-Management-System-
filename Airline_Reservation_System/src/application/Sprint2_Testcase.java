package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class Sprint2_Testcase {
	
	@Test
	public void AddBooking() {
		ARS tempclass = new ARS();
		Booking temp = new Booking(10002,3002,4,4001);

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

	


}
