package Storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import UI.Customer;
import UI.menushow;
import application.Admin;
import application.Booking;
import application.Complain;
import application.FDO;
import application.Flight;
import application.Seat;

public class FileHandler {

	public ArrayList<FDO> Populate_FDO(ArrayList<FDO> FDO_list) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src\\Storage\\fdo.txt"), StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split(",");
				FDO temp = new FDO(split[0], split[1], split[2], split[3], split[4], split[5],
						Integer.parseInt(split[6]), Integer.parseInt(split[7]));
				FDO_list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FDO_list;

	}

	public ArrayList<Admin> Populate_Admin(ArrayList<Admin> Admin_list) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src\\Storage\\admin.txt"), StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split(",");
				Admin temp = new Admin(split[0], split[1], split[2], split[3], split[4], split[5],
						Integer.parseInt(split[6]), Integer.parseInt(split[7]));
				Admin_list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Admin_list;

	}

	public ArrayList<Customer> Populate_Customer(ArrayList<Customer> Customer_list) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src\\Storage\\customer.txt"), StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split(",");
				Customer temp = new Customer(split[0], split[1], split[2], split[3], split[4], split[5],
						Integer.parseInt(split[6]), Integer.parseInt(split[7]));
				Customer_list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Customer_list;

	}

	public ArrayList<Flight> Populate_Flight(ArrayList<Flight> Flight_list) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src\\Storage\\flight.txt"), StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split(",");
				
				Flight temp = new Flight(Integer.parseInt(split[0]), Integer.parseInt(split[1]), split[2], split[3],
						split[4], split[5], split[6], split[7],split[8]);
				Flight_list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Flight_list;

	}

	public ArrayList<Booking> Populate_Bookings(ArrayList<Booking> Booking_list) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src\\Storage\\booking.txt"), StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split(",");
				Booking temp = new Booking(Integer.parseInt(split[0]), Integer.parseInt(split[1]),
						Integer.parseInt(split[2]), Integer.parseInt(split[3]),split[4]);
				Booking_list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Booking_list;

	}

	public ArrayList<Seat> Populate_Seats(ArrayList<Seat> Seats_list) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src\\Storage\\booking.txt"), StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split(",");
				Seat temp = new Seat(Integer.parseInt(split[0]), Integer.parseInt(split[1]), split[2]);
				Seats_list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Seats_list;

	}

	public ArrayList<menushow> Populate_menushow(ArrayList<menushow> menushow_list) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src\\Storage\\menuShow.txt"), StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split(",");
				menushow temp = new menushow(split[0], split[1], split[2], split[3],split[4]);
				menushow_list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return menushow_list;

	}
	public ArrayList<Complain> Populate_Complain(ArrayList<Complain> Complain_list) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src\\Storage\\complain.txt"), StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split(",");
				Complain temp = new Complain(Integer.parseInt(split[0]), split[1]);
				Complain_list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Complain_list;

	}
	
	public void ADDFlight(String flight) {
	try {

			Files.write(Paths.get("src\\Storage\\flight.txt"), "\r\n".getBytes(),StandardOpenOption.APPEND);
			Files.write(Paths.get("src\\Storage\\flight.txt"),(flight).getBytes(),StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}
	
	public void ADDBooking(String book) {
	try {

			Files.write(Paths.get("src\\Storage\\booking.txt"), "\r\n".getBytes(),StandardOpenOption.APPEND);
			Files.write(Paths.get("src\\Storage\\booking.txt"),(book).getBytes(),StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}
	
	public void ADDcustomer(String cust) {
		try {
				Files.write(Paths.get("src\\Storage\\customer.txt"), "\r\n".getBytes(),StandardOpenOption.APPEND);
				Files.write(Paths.get("src\\Storage\\customer.txt"),(cust).getBytes(),StandardOpenOption.APPEND);
			} catch (IOException e) {
				System.out.println("An error occurred.");
			}
		}
	
	public void ADDcomplain(String comp) {
		try {
				Files.write(Paths.get("src\\Storage\\complain.txt"), "\r\n".getBytes(),StandardOpenOption.APPEND);
				Files.write(Paths.get("src\\Storage\\complain.txt"),(comp).getBytes(),StandardOpenOption.APPEND);
			} catch (IOException e) {
				System.out.println("An error occurred.");
			}
		}
	
	public void emptyflight()
	{
		 PrintWriter empty;
		try {
			empty = new PrintWriter("src\\Storage\\flight.txt");
		    empty.print("");
			empty.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		}
		   
	}
	public void emptyfile()
	{
		 PrintWriter empty;
		try {
			empty = new PrintWriter("src\\Storage\\booking.txt");
		    empty.print("");
			empty.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		}
		   
	}
	public void cancelbooking(String book) {
		
		try {
		      FileWriter write = new FileWriter("src\\\\Storage\\\\booking.txt");
		      write.write(book);
		      write.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		}
	
	public void updateflight(String flight) {
		try {
		      FileWriter write = new FileWriter("src\\\\Storage\\\\flight.txt");
		      write.write(flight);
		      write.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		}
}


