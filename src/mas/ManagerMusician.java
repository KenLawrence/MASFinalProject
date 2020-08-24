package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import functionality.Database;
import interfaces.IManager;

public class ManagerMusician extends Musician implements IManager {

	private int maxSubordinates;
	public static final int dyscryminator = 5;

	public static ArrayList<ManagerMusician> allManagersMusicians = new ArrayList<ManagerMusician>();

	public ManagerMusician(int category,String name, String surname, String email, String phoneNumber, double salary,
			String instrument, int maxSubordinates) {
		super(dyscriminator, name, surname, email, phoneNumber, salary, instrument);
		setMaxSubordinates(maxSubordinates);
		allManagersMusicians.add(this);
	}

	@Override
	public int getMaxSubordinates() {
		return 0;
	}

	@Override
	public void setMaxSubordinates(int maxSubordinates) {
		if (maxSubordinates < 0) {
			throw new IllegalArgumentException("Wrong max subordinates number!");
		}
		if (maxSubordinates > 25) {
			throw new IllegalArgumentException("Max subordinates number is too big!");
		}
		this.maxSubordinates = maxSubordinates;

	}

	public static void addManagerMusician(ManagerMusician managerMusician) {
		try {

			Connection connection = Database.openConnection();
			String updateString = "INSERT INTO Manager_Musician (category,personName,surname,email,phoneNumber,salary,instrument,maxSubordinates)"
					+ " VALUES (?,?,?,?,?,?,?,?);";

			PreparedStatement add = null;

			connection.setAutoCommit(false);
			add = connection.prepareStatement(updateString);

			add.setInt(1, managerMusician.getDyscriminator());
			add.setString(2, managerMusician.getName());
			add.setString(3, managerMusician.getSurname());
			add.setString(4, managerMusician.getEmail());
			add.setString(5, managerMusician.getPhoneNumber());
			add.setDouble(6, managerMusician.getSalary());
			add.setString(7, managerMusician.getInstrument());
			add.setInt(8, managerMusician.getMaxSubordinates());

			add.executeUpdate();
			connection.commit();

		}

		catch (Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}

	public static void getAllManagerMusicians() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Manager_Musician";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int category = rs.getInt("category");
				String personName = rs.getString("personName");
				String surname = rs.getString("surname");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				double salary = rs.getDouble("salary");
				String instrument = rs.getString("instrument");
				int maxSubordinates = rs.getInt("maxSubordinates");

				ManagerMusician managerMusician = new ManagerMusician(category,personName, surname, email, phoneNumber, salary, instrument, maxSubordinates);
				
			}
			rs.close();
			preparedStatement.close();

		
		
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
}
