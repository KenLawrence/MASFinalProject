package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import functionality.Database;

public class Band {

	private String name;
	private int foundYear;
	private String musicStyle;
	
	public static ArrayList<Band> allBandsEkstensja = new ArrayList<Band>();
	
	public Band(String name, int foundYear, String musicStyle) {
		setName(name);
		setFoundYear(foundYear);
		setMusicStyle(musicStyle);
		allBandsEkstensja.add(this);
	}

	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		validateString(name);
		this.name = name;
	}

	public int getFoundYear() {
		return foundYear;
	}

	public void setFoundYear(int foundYear) {
		if(foundYear < 1960) {
			throw new IllegalArgumentException("Wrong band found year!");
		}
		if(foundYear > getYear()) {
			throw new IllegalArgumentException("Wrong band found year!");
		}
		this.foundYear = foundYear;
	}

	public String getMusicStyle() {
		return musicStyle;
	}

	public void setMusicStyle(String musicStyle) {
		validateString(musicStyle);
		this.musicStyle = musicStyle;
	}


   private void validateString(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Name cannot be null!");
		}
		if (str.isEmpty()) {
			throw new IllegalArgumentException("Name must have 1 character or more");
		}
    }
	
   
	public static ArrayList<Band> showExtent() {
		return new ArrayList<Band>(allBandsEkstensja);
	}



	public static void setAllBandsEkstensja(ArrayList<Band> allBandsEkstensja) {
		Band.allBandsEkstensja = allBandsEkstensja;
	}



	private int getYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return year;
	}
	 
	public static int get_Band_id(Band band) {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select ID_Band from Band where Band_name ='"+band.getName()+"'";
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
	
	
	public static void addBand(Band band) {
		try {		
			Connection connection = Database.openConnection();

			String updateString = "INSERT INTO Band (Band_name,Found_year,Music_style)" + " VALUES (?,?,?);"; 
			
			PreparedStatement add = null;
			
				connection.setAutoCommit(false);
				add = connection.prepareStatement(updateString);

				add.setString(1, band.getName());
				add.setInt(2, band.getFoundYear());
				add.setString(3, band.getMusicStyle());
				
				add.executeUpdate();
				connection.commit();
				

		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	public static void getAllBand() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Band";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String name = rs.getString("Band_name");
				int foundYear = rs.getInt("Found_year");
				String musicStyle = rs.getString("Music_Style");
				
				Band band = new Band(name, foundYear, musicStyle);
			
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
		return "Band [name=" + name + ", foundYear=" + foundYear + ", musicStyle=" + musicStyle + "]";
	}
	
	
	
	
}
