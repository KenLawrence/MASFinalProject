package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import functionality.Database;
import interfaces.ICrewWorker;

public class CrewWorker extends Employee implements ICrewWorker {

	private int experienceYears;
	private Crew crew;

	public static final int dyscryminator = 3;

	public static ArrayList<CrewWorker> allCrewWorkersEkstensja = new ArrayList<CrewWorker>();

	public CrewWorker(int dyscryminator, String name, String surname, String email, String phoneNumber, double salary,
			int experienceYears) {
		super(dyscryminator, name, surname, email, phoneNumber, salary);
		setExperienceYears(experienceYears);
		allCrewWorkersEkstensja.add(this);
	}
	
	public CrewWorker(int dyscryminator, String name, String surname, String email, String phoneNumber, double salary,
			int experienceYears,Crew crew) {
		super(dyscryminator, name, surname, email, phoneNumber, salary);
		setExperienceYears(experienceYears);
		allCrewWorkersEkstensja.add(this);
	}
	
	public static int getDyscryminator() {
		return dyscryminator;
	}

	@Override
	public int getExperienceYears() {
		return experienceYears;
	}

	@Override
	public void setExperienceYears(int experienceYears) {
		if (experienceYears < 1) {
			throw new IllegalArgumentException("Experience years is too small!");
		}
		if (experienceYears > 45) {
			throw new IllegalArgumentException("Experience years is too big!");
		}
	}

	public Crew getCrew() {
		return crew;
	}

	public void setCrew(Crew crew) {
		if (crew == null) {
			throw new IllegalArgumentException("Crew cannot be null");
		}
		this.crew = crew;
	}

	public static void addCrewWorker(CrewWorker crewWorker) {
		try {

			String updateString = "";
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();

			if(crewWorker.getCrew() == null) {
				updateString = "INSERT INTO Crew_Worker(category,personName,surname,email,phoneNumber,salary,experienceYears)"
						+ " VALUES (?,?,?,?,?,?,?);";
			}
			
			updateString = "INSERT INTO Crew_Worker(category,personName,surname,email,phoneNumber,salary,experienceYears,crew_ID)"
					+ " VALUES (?,?,?,?,?,?,?,?);";
			
			ResultSet rs = statement.executeQuery("select ID_Crew from Crew where band_name ='"+crewWorker.getCrew().getUniqueCode()+"'");
			int crew_id = 0;
			while(rs.next()) {
				crew_id = rs.getInt(1);
			}
			
			PreparedStatement add = null;

			connection.setAutoCommit(false);
			add = connection.prepareStatement(updateString);
			
			if(crewWorker.getCrew()!= null) {
				add.setInt(1, crewWorker.getDyscryminator());
				add.setString(2, crewWorker.getName());
				add.setString(3, crewWorker.getSurname());
				add.setString(4, crewWorker.getPhoneNumber());
				add.setDouble(5, crewWorker.getSalary());
				add.setInt(6, crewWorker.getExperienceYears());
				add.setInt(7, crew_id);
			}
			if(crewWorker.getCrew()== null) {
				add.setInt(1, crewWorker.getDyscryminator());
				add.setString(2, crewWorker.getName());
				add.setString(3, crewWorker.getSurname());
				add.setString(4, crewWorker.getPhoneNumber());
				add.setDouble(5, crewWorker.getSalary());
				add.setInt(6, crewWorker.getExperienceYears());
			}
			
			add.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	public static void getAllCrewWorkers() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;

			String getAllData = "select * from Crew_Worker";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int category = rs.getInt("category");
				String personName = rs.getString("personName");
				String surname = rs.getString("surname");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				double salary = rs.getDouble("salary");
				int experienceYears = rs.getInt("experienceYears");
				Integer crewID = rs.getInt("crew_ID");
				
//				if(crewID != null) {
//					CrewWorker crewWorker = new CrewWorker(category, personName, surname, email, phoneNumber, salary,
//							experienceYears, crewID);
//				}

			}
			rs.close();
			preparedStatement.close();

		} catch (Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return super.toString() + "experienceYears=" + experienceYears + "]";
	}

}
