package application;

public class Complain {

    private int ComplainID;
    private String Complain;
	
	
    Complain(int complainID,String complain){
    	ComplainID = complainID;
    	Complain = complain;
		
	}


	public int getComplainID() {
		return ComplainID;
	}


	public void setComplainID(int complainID) {
		ComplainID = complainID;
	}


	public String getComplain() {
		return Complain;
	}


	public void setComplain(String complain) {
		this.Complain = complain;
	}
	
	public String string_complain() {
		return (ComplainID + "," + Complain);
	}
}
