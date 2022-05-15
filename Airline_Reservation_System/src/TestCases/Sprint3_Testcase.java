package TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import application.ARS;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Sprint3_Testcase {
	
	@Test
	public void updateflight_test1() {
		
		ARS.getInstance().Populate();
		ARS.getInstance().EditFlight(4001, 0, "", "", "", "", "06:00 PM", "09:00 PM", "");
		String flight = "4001,270,B-777,Karachi,Islamabad,23-03-2022,06:00 PM,09:00 PM,10000 PKR";
		assertEquals(flight,ARS.getInstance().Flight_list.get(0).displayFlights());
         
	}
	
	@Test
	public void updateflight_test2() {
		
		ARS.getInstance().Populate();
		ARS.getInstance().EditFlight(4001, 0, "Islamabad", "Karachi","", "", "", "", "");
		String flight = "4001,270,B-777,Islamabad,Karachi,23-03-2022,06:00 PM,09:00 PM,10000 PKR";
		assertEquals(flight,ARS.getInstance().Flight_list.get(0).displayFlights());
         
	}
	
	
	@Test
	public void updateflight_test3() {
		
		ARS.getInstance().Populate();
		ARS.getInstance().EditFlight(4001, 0, "Islamabad", "Karachi","B-777", "23-03-2022", "06:00 PM", "09:00 PM", "10000 PKR");
		String flight = "4001,270,B-777,Islamabad,Karachi,23-03-2022,06:00 PM,09:00 PM,10000 PKR";
		assertEquals(flight,ARS.getInstance().Flight_list.get(0).displayFlights());
         
	}
	
	
	@Test
	public void updateflight_test4() {
		
		ARS.getInstance().Populate();
		ARS.getInstance().EditFlight(4001, 270,"Lahore", "","B-777", "23-03-2022", "06:00 PM", "09:00 PM", "5500 PKR");
		String flight = "4001,270,B-777,Lahore,Karachi,23-03-2022,06:00 PM,09:00 PM,5500 PKR";
		assertEquals(flight,ARS.getInstance().Flight_list.get(0).displayFlights());
         
	}
	
	
	@Test
	public void updateflight_test5() {
		
		ARS.getInstance().Populate();
		ARS.getInstance().EditFlight(4001, 270,"Multan", "","B-777", "23-03-2022", "06:00 PM", "09:00 PM", "5500 PKR");
		String flight = "4001,270,B-777,Multan,Karachi,23-03-2022,06:00 PM,09:00 PM,5500 PKR";
		assertEquals(flight,ARS.getInstance().Flight_list.get(0).displayFlights());
         
	}
	
	
	@Test
	public void updateflight_test6() {
		
		ARS.getInstance().Populate();
		ARS.getInstance().EditFlight(4001, 270, "", "Islamabad","B-777", "23-03-2022", "02:00 PM", "05:00 PM", "5500 PKR");
		String flight = "4001,270,B-777,Multan,Islamabad,23-03-2022,02:00 PM,05:00 PM,5500 PKR";
		assertEquals(flight,ARS.getInstance().Flight_list.get(0).displayFlights());
         
	}
	
	
	@Test
	public void updateflight_test7() {
		
		ARS.getInstance().Populate();
		ARS.getInstance().EditFlight(4001, 270, "Multan", "Islamabad","B-777", "", "02:00 PM", "05:00 PM", "5500 PKR");
		String flight = "4001,270,B-777,Multan,Islamabad,23-03-2022,02:00 PM,05:00 PM,5500 PKR";
		assertEquals(flight,ARS.getInstance().Flight_list.get(0).displayFlights());
         
	}
	
	
	@Test
	public void updateflight_test8() {
		
		ARS.getInstance().Populate();
		ARS.getInstance().EditFlight(4001, 270, "Multan", "Islamabad","B-777", "23-03-2022", "02:00 PM", "05:00 PM", "");
		String flight = "4001,270,B-777,Multan,Islamabad,23-03-2022,02:00 PM,05:00 PM,5500 PKR";
		assertEquals(flight,ARS.getInstance().Flight_list.get(0).displayFlights());
         
	}
	
	
	@Test
	public void updateflight_test9() {
		
		ARS.getInstance().Populate();
		ARS.getInstance().EditFlight(4001, 270, "Multan", "Islamabad","B-777", "", "02:00 PM", "05:00 PM", "5500 PKR");
		String flight = "4001,270,B-777,Multan,Islamabad,23-03-2022,02:00 PM,05:00 PM,5500 PKR";
		assertEquals(flight,ARS.getInstance().Flight_list.get(0).displayFlights());
         
	}
	
	
}