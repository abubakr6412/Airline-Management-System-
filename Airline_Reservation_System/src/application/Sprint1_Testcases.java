package application;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class Sprint1_Testcases {

	@Test
	public void AddCustomer() {
		ARS tempclass = new ARS();
		Customer tempCust = new Customer("Haroon", "Risasat 5 Road 6 Islamabad", "Female", "0315593484", "Hoeroon123",
				"1234", 45, 3002);

		tempclass.Customer_list.add(tempCust);

		assertEquals(tempCust.GetCustomer(), tempclass.Customer_list.get(0).GetCustomer());

	}

	@Test
	public void AddAdmin() {
		ARS tempclass = new ARS();
		Admin tempAdmin = new Admin("Haroon", "Risasat 5 Road 6 Islamabad", "Female", "0315593484", "Hoeroon123",
				"1234", 45, 3002);

		tempclass.Admin_list.add(tempAdmin);

		assertEquals(tempAdmin, tempclass.Admin_list.get(0));

	}

	@Test
	public void AddFDO() {
		ARS tempclass = new ARS();
		FDO tempFDO = new FDO("Haroon", "Risasat 5 Road 6 Islamabad", "Female", "0315593484", "Hoeroon123", "1234", 45,
				3002);

		tempclass.FDO_list.add(tempFDO);

		assertEquals(tempFDO, tempclass.FDO_list.get(0));

	}

	@Test
	public void AddFlight() {
		ARS tempclass = new ARS();
		Flight tempFlight = new Flight(4002, 120, "Islamabad", "Karachi", "A-330", "25-03-22", "08:30", "11:30");

		tempclass.Flight_list.add(tempFlight);

		assertEquals(tempFlight, tempclass.Flight_list.get(0));

	}

	@Test
	public void Customer_ID() {
		ARS.getInstance().Populate();

		assertEquals(ARS.getInstance().Customer_list.get(0).getCustomer_ID(), 3001);
	}

	@Test
	public void CustomerName() {

		assertEquals(ARS.getInstance().Customer_list.get(0).getUsername(), "Hayiqa123");
	}

	@Test
	public void CustomerGender() {

		assertEquals(ARS.getInstance().Customer_list.get(0).getGender(), "Female");
	}

	@Test
	public void FDO_ID() {

		assertEquals(ARS.getInstance().FDO_list.get(0).getFDO_ID(), 1001);
	}

	@Test
	public void Admin_ID() {
		ARS tempclass = new ARS();
		tempclass.Populate();

		assertEquals(tempclass.Admin_list.get(0).getAdmin_ID(), 2001);
	}

	@Test
	public void DeptTest2() {

		assertEquals("Hayiqa Fatima,505 G10/1 Islamabad,Female,03169131888,Hayiqa123,1234,21,3001",
				ARS.getInstance().Customer_list.get(0).GetCustomer());

	}

}
