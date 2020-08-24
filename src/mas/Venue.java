package mas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import functionality.Database;

public class Venue {

	private String name;
	private String street;
	private boolean isOpenAir;
	private int capacity;

	private Show show;

	private static ArrayList<Venue> allVenuesEkstensja = new ArrayList<Venue>();

	public Venue(String name, String street, boolean isOpenAir, int capacity) {
		setName(name);
		setStreet(street);
		setOpenAir(isOpenAir);
		setCapacity(capacity);
		allVenuesEkstensja.add(this);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		validateString(name);
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		validateString(street);
		this.street = street;
	}

	public boolean isOpenAir() {
		return isOpenAir;
	}

	public void setOpenAir(boolean isOpenAir) {
		this.isOpenAir = isOpenAir;
	}

	public int getCapacity() {
		return capacity;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public void setCapacity(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Venue capacity must be bigger than 0!");
		}
		if (capacity > 800_000) {
			throw new IllegalArgumentException("Venue capacity cannot be bigger than 800.000!");
		}
		this.capacity = capacity;
	}

	private void validateString(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Name cannot be null!");
		}
		if (str.isEmpty()) {
			throw new IllegalArgumentException("Name must have 1 character or more");
		}
	}

	public static void addVenue(Venue venue) {
		try {		
			Connection connection = Database.openConnection();

			String updateString = "INSERT INTO Venue (Venue_name,street,is_Open_air,capacity)" + " VALUES (?,?,?,?);"; 
			
			PreparedStatement add = null;
			
				connection.setAutoCommit(false);
				add = connection.prepareStatement(updateString);

				add.setString(1, venue.getName());
				add.setString(2, venue.getStreet());
				add.setBoolean(3, venue.isOpenAir());
				add.setInt(4, venue.getCapacity());
				
				add.executeUpdate();
				connection.commit();


		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}

	}

	public static void getAllVenue() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Venue";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String venueName = rs.getString("Venue_name");
				String street = rs.getString("street");
				boolean isOpenAir = rs.getBoolean("is_Open_air");
				int capacity = rs.getInt("capacity");
				
				Venue venue = new Venue(venueName, street, isOpenAir, capacity);
	
			}
			rs.close();
			preparedStatement.close();

			
		
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "Venue [name=" + name + ", street=" + street + ", isOpenAir=" + isOpenAir + ", capacity=" + capacity
				+ "]";
	}

}
