package application;

import java.util.ArrayList;

import Storage.FileHandler;
import UI.*;
import Storage.*;

public class ARS {

	private static ARS single_instance = null;

	public static ARS getInstance() {
		if (single_instance == null)
			single_instance = new ARS();

		return single_instance;
	}

	// Populating the classes
	public ArrayList<FDO> FDO_list = new ArrayList<FDO>();
	public ArrayList<Admin> Admin_list = new ArrayList<Admin>();
	public ArrayList<Customer> Customer_list = new ArrayList<Customer>();
	public ArrayList<Flight> Flight_list = new ArrayList<Flight>();
	public ArrayList<Booking> Booking_list = new ArrayList<Booking>();
	public ArrayList<Seat> Seat_list = new ArrayList<Seat>();
	public ArrayList<Complain> Complain_list = new ArrayList<Complain>();
	public ArrayList<menushow> menushow_list = new ArrayList<menushow>();

	FileHandler F_Handler = new FileHandler();

	public void Populate() {
		FDO_list = F_Handler.Populate_FDO(FDO_list);
		Admin_list = F_Handler.Populate_Admin(Admin_list);
		Customer_list = F_Handler.Populate_Customer(Customer_list);
		Flight_list = F_Handler.Populate_Flight(Flight_list);
		Booking_list = F_Handler.Populate_Bookings(Booking_list);
		Seat_list = F_Handler.Populate_Seats(Seat_list);
		menushow_list = F_Handler.Populate_menushow(menushow_list);
		Complain_list = F_Handler.Populate_Complain(Complain_list);

	}

	public void EditFlight(int FlightID, int cap, String src, String dest, String ptype, String date, String depttime,
			String arrivaltime, String price) {
		
		for (int i = 0; i < Flight_list.size(); i++) {

			if (FlightID == Flight_list.get(i).getFlightID()) {
                 
				if (src.equals("") && dest.equals("") && date.equals("") && price.equals("") && cap == 0) {
					Flight_list.get(i).setDeparture_Time(depttime);
					Flight_list.get(i).setArrival_Time(arrivaltime);
					
				}
				else if (depttime.equals("") && arrivaltime.equals("") && date.equals("") && price.equals("") && cap == 0 && dest.equals("")) {
					Flight_list.get(i).setSource(src);
				}
				else if (depttime.equals("") && arrivaltime.equals("") && date.equals("") && price.equals("") && cap == 0 && src.equals("")) {
					Flight_list.get(i).setDestination(dest);;
				}
				else if (depttime.equals("") && arrivaltime.equals("") && date.equals("") && price.equals("") && cap == 0) {
					Flight_list.get(i).setSource(src);
					Flight_list.get(i).setDestination(dest);
				}
				else if (depttime.equals("") && arrivaltime.equals("") && date.equals("") && cap == 0 && src.equals("") && dest.equals(""))
				{
					Flight_list.get(i).setPrice(price);
				}
				
				else if (depttime.equals("") && arrivaltime.equals("") &&  price.equals("") && cap == 0 && src.equals("") && dest.equals("")){
					
					Flight_list.get(i).setFlight_Date(date);
					
				}
				else if (depttime.equals("") && arrivaltime.equals("") && date.equals("") && price.equals("") &&  src.equals("") && dest.equals("")) {
					
					Flight_list.get(i).setCapacity(cap);
				}
				else if (cap == 0 && !depttime.equals("") && !arrivaltime.equals("") && !date.equals("") && !price.equals("") &&  !src.equals("") && !dest.equals("")) {
                    
					
					Flight_list.get(i).setSource(src);
					Flight_list.get(i).setDestination(dest);
					Flight_list.get(i).setFlight_Date(date);
					Flight_list.get(i).setDeparture_Time(depttime);
					Flight_list.get(i).setArrival_Time(arrivaltime);
					Flight_list.get(i).setPrice(price);
				}

				else if (src.equals("") && cap != 0 && !depttime.equals("") && !arrivaltime.equals("") && !date.equals("") && !price.equals("") &&  !dest.equals("")) {

					Flight_list.get(i).setCapacity(cap);
					Flight_list.get(i).setDestination(dest);
					Flight_list.get(i).setFlight_Date(date);
					Flight_list.get(i).setDeparture_Time(depttime);
					Flight_list.get(i).setArrival_Time(arrivaltime);
					Flight_list.get(i).setPrice(price);
				}
				else if (dest.equals("") && cap != 0 && !depttime.equals("") && !arrivaltime.equals("") && !date.equals("") && !price.equals("") &&  !src.equals("")) {

					Flight_list.get(i).setCapacity(cap);
					Flight_list.get(i).setSource(src);
					Flight_list.get(i).setFlight_Date(date);
					Flight_list.get(i).setDeparture_Time(depttime);
					Flight_list.get(i).setArrival_Time(arrivaltime);
					Flight_list.get(i).setPrice(price);
				}

				else if (date.equals("") && cap != 0 && !depttime.equals("") && !arrivaltime.equals("") && !price.equals("") &&  !src.equals("") && !dest.equals("")) {

					Flight_list.get(i).setCapacity(cap);
					Flight_list.get(i).setSource(src);
					Flight_list.get(i).setDestination(dest);
					Flight_list.get(i).setDeparture_Time(depttime);
					Flight_list.get(i).setArrival_Time(arrivaltime);
					Flight_list.get(i).setPrice(price);
				}

				else if (price.equals("") && cap != 0 && !depttime.equals("") && !arrivaltime.equals("") && !date.equals("") && !src.equals("") && !dest.equals("")) {

					Flight_list.get(i).setCapacity(cap);
					Flight_list.get(i).setSource(src);
					Flight_list.get(i).setDestination(dest);
					Flight_list.get(i).setFlight_Date(date);
					Flight_list.get(i).setDeparture_Time(depttime);
					Flight_list.get(i).setArrival_Time(arrivaltime);
				}

				else if (depttime.equals("") && arrivaltime.equals("") && cap == 0 && !date.equals("") && !price.equals("") &&  !src.equals("") && !dest.equals("")) {

					Flight_list.get(i).setCapacity(cap);
					Flight_list.get(i).setSource(src);
					Flight_list.get(i).setDestination(dest);
					Flight_list.get(i).setFlight_Date(date);
					Flight_list.get(i).setPrice(price);
				}

				else if (src.equals("") && dest.equals("") && cap == 0 && !depttime.equals("") && !arrivaltime.equals("") && !date.equals("") && !price.equals("")) {
					Flight_list.get(i).setCapacity(cap);
					Flight_list.get(i).setFlight_Date(date);
					Flight_list.get(i).setDeparture_Time(depttime);
					Flight_list.get(i).setArrival_Time(arrivaltime);
					Flight_list.get(i).setPrice(price);
				}
				
				else {

					Flight_list.get(i).setCapacity(cap);
					Flight_list.get(i).setSource(src);
					Flight_list.get(i).setDestination(dest);
					Flight_list.get(i).setFlight_Date(date);
					Flight_list.get(i).setDeparture_Time(depttime);
					Flight_list.get(i).setArrival_Time(arrivaltime);
					Flight_list.get(i).setPrice(price);
				}

			}
		}
		
		tempStatic.confirmation=true;
		F_Handler.emptyflight();
		String flight = "";
		for (int i = 0; i < Flight_list.size(); i++) {
			flight += Flight_list.get(i).displayFlights() + "\n";
		}
		F_Handler.updateflight(flight);

	}
	
	public void AddCustomer(String name,String address,String gender,String phone,String username,String password,int age,int cid) {
		Customer tempCust = new Customer(name,address,gender,phone,username,password,age,cid);
		Customer_list.add(tempCust);
		String cust = name + "," +address + "," + gender + "," + phone + "," + username + "," + password + "," + age + "," +cid;
		F_Handler.ADDcustomer(cust);
	}

	public void AddFlight(int FlightID, int cap, String src, String dest, String ptype, String date, String depttime,
			String arrivaltime, String price) {
		Flight temp = new Flight(FlightID, cap, src, dest, ptype, date, depttime, arrivaltime, price);
		Flight_list.add(temp);
		String flight = FlightID + "," + cap + "," +  ptype + "," + src + "," +  dest + "," + date + "," + depttime + "," + arrivaltime + "," + price;
		F_Handler.ADDFlight(flight);

	}

	public void AddBooking(int BID, int CID, int Numseats, int FiD, String seattype) {
		Booking temp = new Booking(BID, CID, Numseats, FiD, seattype);
		Booking_list.add(temp);
		String book = (BID + "," +  CID + "," + Numseats + "," + FiD + "," + seattype);
		F_Handler.ADDBooking(book);

	}

	public void CancelBooking(int BID) {
		
		int id = 0;
		for(int i=0;i<Booking_list.size();i++) {
			if(Booking_list.get(i).getBooking_ID()==BID) {
				id = Booking_list.get(i).getBooking_ID();
				Booking_list.remove(i);
			}
		}
		
		id = id + 1;
		boolean check = false;
		for(int i=0;i<Booking_list.size();i++) {
			if(Booking_list.get(i).getBooking_ID()== id) {
		    	check = true;
			}
			
			
			if(check == true) {
				Booking_list.get(i).setBooking_ID(Booking_list.get(i).getBooking_ID()-1);
			}
		}
		
		F_Handler.emptyfile();
		String book = "";
		for(int i=0;i<Booking_list.size();i++) {
			book += Booking_list.get(i).string_Booking() + "\n";
		}
		F_Handler.cancelbooking(book);
	}
	
	public void complain(int id,String comp) {
		Complain temp = new Complain(id,comp);
		Complain_list.add(temp);
		String compl = id + "," + comp;
		F_Handler.ADDcomplain(compl);
		
	}

}
