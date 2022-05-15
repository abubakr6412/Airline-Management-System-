package UI;

public class menushow {

		
		private String companyname,airport,origin,destination,status;
		
		
		public menushow(String companyname,String airport,String origin,String destination,String status){
			this.companyname = companyname;
			this.airport = airport;
			this.origin = origin;
			this.destination = destination;
			this.status = status;
			
		}


		public String getCompanyname() {
			return companyname;
		}


		public void setCompanyname(String companyname) {
			this.companyname = companyname;
		}


		public String getAirport() {
			return airport;
		}


		public void setAirport(String airport) {
			this.airport = airport;
		}


		public String getOrigin() {
			return origin;
		}


		public void setOrigin(String origin) {
			this.origin = origin;
		}


		public String getDestination() {
			return destination;
		}


		public void setDestination(String destination) {
			this.destination = destination;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}
	
		public String Displaymenushow() {
			return(companyname+","+airport+","+origin+","+destination+","+status);
		}


}
