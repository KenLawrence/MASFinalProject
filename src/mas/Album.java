package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import functionality.Database;

public class Album {

	private String name;
	private String length;
	private String songsNumber;
	private String description;
	private String producer;
	
	public static ArrayList<Album> allAlbumsEkstensja = new ArrayList<Album>();
	
	public Album(String name, String length,String songsNumber,String description, String producer) {
		setName(name);
		setLength(length);
		setSongsNumber(songsNumber);
		setDescription(description);
		setProducer(producer);
		allAlbumsEkstensja.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		validateString(name);
		this.name = name;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		validateString(length);
		this.length = length;
	}

	public String getSongsNumber() {
		return songsNumber;
	}

	public void setSongsNumber(String songsNumber) {
		validateString(songsNumber);
		this.songsNumber = songsNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		validateString(description);
		this.description = description;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		validateString(producer);
		this.producer = producer;
	}
	
	public static void addNewAlbum(Album album) {
		
		try {

			Connection connection = Database.openConnection();

			String updateString = "INSERT INTO Album (albumName,albumLength,songsNumber,description,producer)" + " VALUES (?,?,?,?,?);"; 
			
			PreparedStatement add = null;
			
				connection.setAutoCommit(false);
				add = connection.prepareStatement(updateString);
				
				add.setString(1, album.getName());
				add.setString(2, album.getLength());
				add.setString(3, album.getSongsNumber());
				add.setString(4, album.getDescription());
				add.setString(5,album.getProducer());
				
				add.executeUpdate();
				connection.commit();
				
				Album my_album = new Album(album.getName(),album.getLength(),album.getSongsNumber(),album.getDescription(),album.getProducer());;
				Album.allAlbumsEkstensja.add(my_album);
			
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
		
	}
	
	private static void getAllAlbums() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Album";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String albumName = rs.getString("albumName");
				String albumLength = rs.getString("albumLength");
				String songsNumber = rs.getString("songsNumber");
				String description = rs.getString("description");
				String producer = rs.getString("producer");
				
				Album album = new Album(albumName, albumLength, songsNumber, description, producer);
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
