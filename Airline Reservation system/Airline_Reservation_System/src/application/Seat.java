package application;

public class Seat {

	
	private int Booking_ID,Seat_No;
	private String Seat_Type;
	
	public Seat(int BID,int SNo,String Stype){
		Booking_ID=BID;
		Seat_No=SNo;
		Seat_Type=Stype;
	}
	public int getBooking_ID() {
		return Booking_ID;
	}
	public void setBooking_ID(int booking_ID) {
		Booking_ID = booking_ID;
	}
	public int getSeat_No() {
		return Seat_No;
	}
	public void setSeat_No(int seat_No) {
		Seat_No = seat_No;
	}
	public String getSeat_Type() {
		return Seat_Type;
	}
	public void setSeat_Type(String seat_Type) {
		Seat_Type = seat_Type;
	}
	
	public void PrintSeat() {
		System.out.println("Booking ID: "+Booking_ID+" Seat No: "+Seat_No+" Seat Type: "+Seat_Type);
	}
}
