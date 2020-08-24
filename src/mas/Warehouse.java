package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import functionality.Database;

public class Warehouse {

	private String address;
	private double surface;
	
	public static ArrayList<Warehouse> allWarehouseEkstensja = new ArrayList<Warehouse>();
	
	
	public Warehouse(String address, double surface) {
		setAddress(address);
		setSurface(surface);
		allWarehouseEkstensja.add(this);
	}

	
	
	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		validateString(address);
		this.address = address;
	}



	public double getSurface() {
		return surface;
	}



	public void setSurface(double surface) {
		if(surface < 0) {
			throw new IllegalArgumentException("Wrong warehouse surface!");
		}
		if(surface > 1000000) {
			throw new IllegalArgumentException("warehouse surface is too big!");
		}
		this.surface = surface;
	}

	private void validateString(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Name cannot be null!");
		}
		if (str.isEmpty()) {
			throw new IllegalArgumentException("Name must have 1 character or more");
		}
    }

	public static void addWarehouse(Warehouse warehouse) {
		try {

			Connection connection = Database.openConnection();

			String updateString = "INSERT INTO Warehouse (address, surface)" + " VALUES (?,?);"; 
			
			PreparedStatement add = null;
			add = connection.prepareStatement(updateString);

			add.setString(1, warehouse.getAddress());
			add.setDouble(2, warehouse.getSurface());

			add.executeUpdate();
			connection.commit();
			
			
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	public static void getWarehouse() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Warehouse";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String address = rs.getString("address");
				double surface = rs.getDouble("surface");
				
				Warehouse warehouse = new Warehouse(address, surface);
				
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
		return "Warehouse [address=" + address + ", surface=" + surface + "]";
	}
	
	
	
}
