package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import functionality.Database;

public class BandInfo {

	private String name;
	private String foundYear;
	private String musicStyle;

	public static ArrayList <BandInfo> allBandInfoEkstensja = new ArrayList<BandInfo>();
	
	public BandInfo(String name, String founYear, String musicStyle) {
		setName(name);
		setFoundYear(founYear);
		setMusicStyle(musicStyle);
		allBandInfoEkstensja.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		validateString(name);
		this.name = name;
	}

	public String getFoundYear() {
		return foundYear;
	}

	public void setFoundYear(String foundYear) {
		this.foundYear = foundYear;
	}

	public String getMusicStyle() {
		return musicStyle;
	}

	public void setMusicStyle(String musicStyle) {
		validateString(musicStyle);
		this.musicStyle = musicStyle;
	}
	
	public static void addBandInfo(BandInfo bandInfo) {
		
		try {

			Connection connection = Database.openConnection();

			String updateString = "INSERT INTO BandInfo (bandName, foundYear, musicStyle)" + " VALUES (?,?,?);"; 
			
			PreparedStatement add = null;
			add = connection.prepareStatement(updateString);

			add.setString(1, bandInfo.getName());
			add.setString(2, bandInfo.getFoundYear());
			add.setString(3, bandInfo.getMusicStyle());

			add.executeUpdate();
			connection.commit();
			
			
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
		
	}
	
	public static void getAllBandInfo() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from BandInfo";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String bandName = rs.getString("Venue_name");
				String foundYear = rs.getString("street");
				String musicStyle = rs.getString("musicStyle");
				
				BandInfo bandInfo = new BandInfo(bandName, foundYear, musicStyle);
				
			}
			rs.close();
			preparedStatement.close();

			
		
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	   private void validateString(String str) {
			if (str == null) {
				throw new IllegalArgumentException("Name cannot be null!");
			}
			if (str.isEmpty()) {
				throw new IllegalArgumentException("Name must have 1 character or more");
			}
	    }
	
}
