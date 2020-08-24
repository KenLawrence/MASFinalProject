package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import functionality.Database;
import interfaces.IMusician;

public class Musician extends Employee implements IMusician {

	private String instrument;

	public final static int dyscriminator = 1;

	public static ArrayList<Musician> allMusiciansEkstensja = new ArrayList<Musician>();

	public Musician(int dyscriminator, String name, String surname, String email, String phoneNumber, double salary,String instrument) {
		super(dyscriminator, name, surname, email, phoneNumber, salary);
		setInstrument(instrument);
		allMusiciansEkstensja.add(this);
	}

	@Override
	public String getInstrument() {

		return instrument;
	}

	@Override
	public void setInstrument(String instrument) {
		validateString(instrument);
		this.instrument = instrument;

	}

	public int getDyscriminator() {
		return dyscriminator;
	}
//
//	public static ArrayList<Musician> getAllMusiciansEkstensja() {
//		return new ArrayList<>(allMusiciansEkstensja);
//	}
//
//	public static void setAllMusiciansEkstensja(ArrayList<Musician> allMusiciansEkstensja) {
//		allMusiciansEkstensja = allMusiciansEkstensja;
//	}

	private void validateString(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Name cannot be null!");
		}
		if (str.isEmpty()) {
			throw new IllegalArgumentException("Name must have 1 character or more");
		}
	}

	public static int get_Musician_Id(Musician musician) {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select ID_Musician from Musician where Band_name ='"+musician.getName()+"'";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID_Band");
				return id;
			}
			rs.close();
			preparedStatement.close();

			
		
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static void addMusician(Musician m) {
		try {


				Connection connection = Database.openConnection();
				String updateString = "INSERT INTO Musician (category,personName,surname,email,phoneNumber,salary,instrument)"
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
				add.setString(7, m.getInstrument());

				add.executeUpdate();
				connection.commit();

			
		}
		
		catch (Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}

	
	public static void getMusicianEkstensja() {
		
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Musician";
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
				
				Musician musician = new Musician(category, personName, surname, email, phoneNumber, salary, instrument);
				
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
		return super.toString() + instrument ;
	}

}
