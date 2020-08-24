package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import functionality.Database;
import interfaces.IManager;

public class Manager extends Employee implements IManager{

	private int maxSubordinates;
	
	public static final int dyscryminator = 2;
	
	public static ArrayList<Manager> allManagersEkstensja = new ArrayList<Manager>();
	
	public Manager(int dyscryminator,String name, String surname, String email, String phoneNumber, double salary,int maxSubordinates) {
		super(dyscryminator,name, surname, email, phoneNumber, salary);
		setMaxSubordinates(maxSubordinates);
		allManagersEkstensja.add(this);
	}


	@Override
	public int getMaxSubordinates() {
		return maxSubordinates;
	}


	@Override
	public void setMaxSubordinates(int maxSubordinates) {
		if(maxSubordinates < 0) {
			throw new IllegalArgumentException("Wrong max subordinates number!");
		}
		if(maxSubordinates > 25) {
			throw new IllegalArgumentException("Max subordinates number is too big!");
		}
		this.maxSubordinates = maxSubordinates;
	}
	

	public static int getDyscryminator() {
		return dyscryminator;
	}

	
	public static void addManager(Manager m) {
		try {


			Connection connection = Database.openConnection();
			String updateString = "INSERT INTO Manager (category,personName,surname,email,phoneNumber,salary,maxSubordinates)"
					+ " VALUES (?,?,?,?,?,?,?);";

			PreparedStatement add = null;

			connection.setAutoCommit(false);
			add = connection.prepareStatement(updateString);

			add.setInt(1, m.getDyscriminator());
			add.setString(2, m.getName());
			add.setString(3, m.getSurname());
			add.setString(4, m.getEmail());
			add.setString(5, m.getPhoneNumber());
			add.setDouble(6, m.getSalary());
			add.setInt(7, m.getMaxSubordinates());

			add.executeUpdate();
			connection.commit();

		
	}
	
	catch (Exception e) {
		System.out.println("Connection to database failed.");
		e.printStackTrace();
	}
	}
	
	
	public static void getAllManagers() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Manager";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int category = rs.getInt("category");
				String personName = rs.getString("personName");
				String surname = rs.getString("surname");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				double salary = rs.getDouble("salary");
				int maxSubordinates = rs.getInt("maxSubordinates");
				
				Manager manager = new Manager(category, personName, surname, email, phoneNumber, salary, maxSubordinates);
				
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
		return "Manager [maxSubordinates=" + maxSubordinates + "]";
	}

	
	
	
}
