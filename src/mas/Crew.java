package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import functionality.Database;

public class Crew{

	public static final int maxCrewSize = 250;
	private int size;
	private int uniqueCode;
	
	
	private static ArrayList<Crew> allCrewEkstensja = new ArrayList<Crew>();
	
	private ArrayList<CrewWorker> workers = new ArrayList<CrewWorker>();
	
	public Crew(int size) {
		setSize(size);
		allCrewEkstensja.add(this);
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if(size < 10) {
			throw new IllegalArgumentException("Crew team cannot be smaller than 10!");
		}
		if(size > maxCrewSize) {
			throw new IllegalArgumentException("Crew team cannot be bigger than 250!");
		}
		this.size = size;
	}
	
	
	public int getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(int uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	public static ArrayList<Crew> getExtent() {
		return allCrewEkstensja;
	}

	public void setCrewList(ArrayList<Crew> crewList) {
		crewList = allCrewEkstensja;
	}

	public void addWorker(CrewWorker crewWorker) {
		if(workers.contains(crewWorker)) {
			throw new IllegalArgumentException("This person already belongs to the Crew");
		}
		workers.add(crewWorker);
	}
	
//	public static void addCrew(Crew crew) {
//		try {
//
//			Connection connection = Database.openConnection();
//
//			String updateString = "INSERT INTO Crew (Crew_Size, Crew_Worker_ID)" + " VALUES (?,?);"; 
//			
//			PreparedStatement add = null;
//			add = connection.prepareStatement(updateString);
//
//			add.setInt(1, crew.getSize());
//			add.setString(2, c.getFoundYear());
//			add.setString(3, bandInfo.getMusicStyle());
//
//			add.executeUpdate();
//			connection.commit();
//			
//			
//		}catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//	}
	
	public static void getAllCrew() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Crew";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int size = rs.getInt("Crew_Size");
				int code = rs.getInt("uniqueCode");
				Crew crew = new Crew(size); 
				crew.setUniqueCode(code);
			}
			rs.close();
			preparedStatement.close();

			
		
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	
	public int getID_Crew(Crew crew) {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Crew where uniqueCode ='"+crew.getUniqueCode()+"'";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int crewSize = rs.getInt("Crew_Size");
				rs.close();
				preparedStatement.close();
				
		}
		
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
		return 0;
	}
	
	public static Crew getCrewByID(int id) {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Crew where ID_Crew ='"+id+"'";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int crewSize = rs.getInt("Crew_Size");
				int uniqueCode =rs.getInt("uniqueCode");
				rs.close();
				preparedStatement.close();
				
				Crew crew = new Crew(crewSize);
				
				return crew;
		}
		
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public String toString() {
		return "Crew []";
	}
	
	
	
}
