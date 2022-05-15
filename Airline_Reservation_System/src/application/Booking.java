package application;

public class Booking {
	private int Booking_ID,Customer_ID,Num_Seats,Flight_ID;
    private String Seattype;
	
	
	public Booking(int BID,int CID,int Numseats,int FiD, String seattype){
		Booking_ID=BID;
		Customer_ID=CID;
		Num_Seats=Numseats;
		Flight_ID=FiD;
		Seattype = seattype;
		
	}
	public int getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}

	public int getNum_Seats() {
		return Num_Seats;
	}

	public void setNum_Seats(int num_Seats) {
		Num_Seats = num_Seats;
	}

	public int getFlight_ID() {
		return Flight_ID;
	}

	public void setFlight_ID(int flight_ID) {
		Flight_ID = flight_ID;
	}
	public int getBooking_ID() {
		return Booking_ID;
	}
	public void setBooking_ID(int booking_ID) {
		Booking_ID = booking_ID;
	}
	public String getSeattype() {
		return Seattype;
	}
	public void setSeattype(String seattype) {
		this.Seattype = seattype;
	}
	public void PrintBooking() {
		System.out.println("Booking ID: "+Booking_ID+" Customer ID: "+Customer_ID+" Num Seats: "+Num_Seats+" Flight ID: "+Flight_ID + "Seat type"+Seattype);
	}
	
	public String string_Booking() {
		return(Booking_ID+","+Customer_ID+","+Num_Seats+","+Flight_ID+","+Seattype);
	}
	
	
}
