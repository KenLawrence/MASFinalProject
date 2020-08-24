package mas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Enum.Role;
import functionality.Database;

public class MusicianBand_BAG {

	private Band band;
	private Musician musician;
	private Role role;
	
	public static ArrayList<MusicianBand_BAG> musicianBandEkstensja = new ArrayList<MusicianBand_BAG>();
	
	public MusicianBand_BAG(Band band, Musician musician, Role role) {
		setBand(band);
		setMusician(musician);
		setRole(role);
		musicianBandEkstensja.add(this);
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		if(band == null) {
			throw new IllegalArgumentException("Band cannot be null");
		}
		this.band = band;
	}

	public Musician getMusician() {
		return musician;
	}

	public void setMusician(Musician musician) {
		if(musician == null) {
			throw new IllegalArgumentException("Musician cannot be null");
		}
		this.musician = musician;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		if(role == null) {
			throw new IllegalArgumentException("Role cannot be null");
		}
		this.role = role;
	}

	
	public static void addMusicianBand(MusicianBand_BAG musicianBand) {
		try {

			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			String updateString = "INSERT INTO MusicianBand (Band_ID, Musician_ID, role_in_band)" + " VALUES (?,?,?);"; 
			
			PreparedStatement add = null;
			add = connection.prepareStatement(updateString);
			
			ResultSet rs = statement.executeQuery("select id_band from Band where band_name ='"+musicianBand.getBand().getName()+"'");
			
			int band_id = 0;
			int musician_id =0;			
			while(rs.next()) {
				band_id = rs.getInt(1);
			}
			
			ResultSet rs2 = statement.executeQuery("select id_Person from Person where category = 1 AND personname ='"+musicianBand.getMusician().getName()+"' AND surname = '"+musicianBand.getMusician().getSurname()+"'");
			
			while(rs2.next()) {
				musician_id = rs2.getInt(1);
			}
			
			add.setInt(1, band_id);
			add.setInt(2, musician_id);
			add.setString(3, musicianBand.getRole().toString());

			add.executeUpdate();
			connection.commit();
			
			
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	
	public static void getMusicianBand() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from MusicianBand");
			while(result.next()) {
				
				int bandId = result.getInt("Band_ID");
				int musicianId = result.getInt("musician_ID");
				String roleInBand = result.getString("role_in_band");
				Role role = Role.valueOf(roleInBand);
				//odtowrzyc band i musician na podstawie ID
				Band band = Band.allBandsEkstensja.get(bandId);
				
				Musician musician = Musician.allMusiciansEkstensja.get(musicianId-1);
				

				MusicianBand_BAG musicianBand_BAG = new MusicianBand_BAG(band, musician, role);

			}
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	
	
	public static ArrayList<MusicianBand_BAG> getMusicianBandEkstensja() {
		return new ArrayList<MusicianBand_BAG>(musicianBandEkstensja);
	}

	public static void setMusicianBandEkstensja(ArrayList<MusicianBand_BAG> musicianBandEkstensja) {
		MusicianBand_BAG.musicianBandEkstensja = musicianBandEkstensja;
	}

	@Override
	public String toString() {
		return "MusicianBand_BAG [band=" + band + ", musician=" + musician + ", role=" + role + "]";
	}
	
	
	
}
