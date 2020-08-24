package functionality;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

import javax.enterprise.inject.Stereotype;
import javax.swing.DefaultListModel;

import com.mysql.cj.xdevapi.PreparableStatement;

import mas.Album;
import mas.Band;
import mas.BandInfo;
import mas.Crew;
import mas.CrewWorker;
import mas.Customer;
import mas.Good;
import mas.Musician;
import mas.MusicianBand_BAG;
import mas.Order;
import mas.Person;
import mas.PlaysIn;
import Enum.Role;
import mas.ShopItem;
import mas.Ticket;
import mas.Venue;
import mas.Warehouse;

public class Database {

	private static int id;
	
	private static String getString(String arg) {
		return "\'" + arg + "\'";
	}
	
	public static Connection openConnection () {
		
		try {	
			Class.forName("org.postgresql.Driver");	
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			return connection;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void addCustomerToDatabase(Customer customer) {
		try {

			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			
			statement.executeUpdate("INSERT INTO USERS (login,user_password,user_name,surname,email,phoneNumber,address)"
					+ " VALUES ("
					+ getString(customer.getName())	    + ","
					+ getString(customer.getPassword())    + ","
					+ getString(customer.getName())       + ","
					+ getString(customer.getSurname())     + ","
					+ getString(customer.getEmail())      + ","
					+ getString(customer.getPhoneNumber()) + ","
					+ getString(customer.getAddress())     + ");");
			
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
//	public static void addMusician(Person person) {
//		try {
//
//			if(person instanceof Musician) {
//				Musician m = ((Musician)person);
//			
//			Connection connection = Database.openConnection();
//			String updateString =  "INSERT INTO PERSON (Category,PersonName,Surname,email,phoneNumber,salary,instrument)"
//					+ " VALUES (?,?,?,?,?,?,?);"; 
//
//			PreparedStatement add = null;
//			
//			connection.setAutoCommit(false);
//			add = connection.prepareStatement(updateString);
//			
//			add.setInt(1, m.getDyscriminator());
//			add.setString(2, m.getName());
//			add.setString(3, m.getSurname());
//			add.setString(4, m.getEmail());
//			add.setString(5, m.getPhoneNumber());
//			add.setDouble(6, m.getSalary());
//			add.setString(7,m.getInstrument());
//			
//			add.executeUpdate();
//			connection.commit();
//			
//			Musician musician = new Musician(m.getDyscriminator(),m.getName(), m.getSurname(),m.getEmail(), m.getPhoneNumber(), m.getSalary(),m.getInstrument());
//			Musician.allMusiciansEkstensja.add(musician);
//			}	
//		}
//			
//		catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//	}
		
	
	public static boolean authorize(String login, String password) {
		try {

			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from users");
			while(result.next()) {
				if(login.equals(result.getString("login"))) {
					System.out.println(password.equals(result.getString("user_password")));
					return password.equals(result.getString("user_password"));
				}
			}
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
		return false;
	}
	
	public static void getPerson() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from Person");
			
			while(result.next()) {
				int category = Integer.parseInt(result.getString("category"));
				String name = result.getString("personname");
				String surname = result.getString("surname");
				String email = result.getString("email");
				String phoneNumber = result.getString("phonenumber");
				String discount = result.getString("discount");
				double salary = Double.parseDouble(result.getString("salary"));
				String instrument = result.getString("instrument");
				int subordinates = result.getInt("maxsubordinates");
				int expYears = result.getInt("experienceyears");
				int extraSalary = result.getInt("extra_salary");
				
				if(category==1) {
					Musician musician = new Musician(category, name, surname, email, phoneNumber, salary, instrument);
					//System.out.println(p+"??????????????????????");
					Person.allPersonsEkstensja.add(musician);
					Musician.allMusiciansEkstensja.add(musician);

				}
				
				if(category == 2) {
					CrewWorker crewWorker = new CrewWorker(category, name, surname, email, phoneNumber, salary, expYears);
					Person.allPersonsEkstensja.add(crewWorker);
					CrewWorker.allPersonsEkstensja.add(crewWorker);
				}
				
					
			}
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	
	public static void addBand(Band band) {
		try {

			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from Band");
			int x = 0;
			while(rs.next()) {
				x = x+1;
			}
			
			statement.executeUpdate("INSERT INTO Band (ID_Band,Band_name,Found_year,Music_style)"
					+ " VALUES ("
					+ getString(x+1+"")	    + ","
					+ getString(band.getName())	    + ","
					+ getString(band.getFoundYear()+"")    + ","
					+ getString(band.getMusicStyle())     + ");");
			Band.allBandsEkstensja().add(band);
			
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	
//	public static void getAllBand() {
//		try {
//			Connection connection = Database.openConnection();
//			Statement statement = connection.createStatement();
//			PreparedStatement preparedStatement = null;
//			
//			String getAllData = "select * from Band";
//			preparedStatement = connection.prepareStatement(getAllData);
//			ResultSet rs = preparedStatement.executeQuery();
//			while(rs.next()) {
//				String name = rs.getString("Band_name");
//				int foundYear = rs.getInt("Found_year");
//				String musicStyle = rs.getString("Music_Style");
//				
//				Band band = new Band(name, foundYear, musicStyle);
//				Band.allBandsEkstensja.add(band);
//			
//			}
//			rs.close();
//			preparedStatement.close();
//		}catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//	}
	
	public static void getAllWarehouse() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from Warehouse");
			while(result.next()) {
				
				String address = result.getString("address");
				double surface = result.getDouble("surface");
				
				Warehouse warehouse = new Warehouse(address,surface);
				Warehouse.warehouseEkstensja.add(warehouse);
				
			}
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	

//	public static void addVenue(Venue venue) {
//		try {
//
//			Class.forName("org.postgresql.Driver");
//			
//			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
//			Statement statement = connection.createStatement();
//			
//			ResultSet rs = statement.executeQuery("select * from Person");
//			int x = 0;
//			while(rs.next()) {
//				x = x+1;
//			}
//			
//
//
//			String updateString = "INSERT INTO Venue (Venue_id,Venue_name,street,is_Open_air,capacity)" + " VALUES (?,?,?,?,?);"; 
//			
//			PreparedStatement add = null;
//			
//			try {
//				connection.setAutoCommit(false);
//				add = connection.prepareStatement(updateString);
//				
//				add.setInt(1, x);
//				add.setString(2, venue.getName());
//				add.setString(3, venue.getStreet());
//				add.setBoolean(4, venue.isOpenAir());
//				add.setInt(5, venue.getCapacity());
//				
//				add.executeUpdate();
//				connection.commit();
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//
//		}catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//	}
//	

	public static void getAllGoods() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from ShopItem");
			while(result.next()) {
				
				String name = result.getString("Good_Name");
				double weight = result.getDouble("weight");
				double price = result.getDouble("price");
				boolean b = result.getBoolean("Is_Limited_edition");
				String description = result.getString("description");
				
				Good good = new Good(name,weight,price,b,description);
				Good.allGoods.add(good);
			}
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	
	public static void getAllShows() {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from Band_Show");
			while(result.next()) {
				
				int category = result.getInt("Category");
				Date date = result.getDate("Show_Date");
				Time time = result.getTime("time");
				String showLength = result.getString("Show_Length");
				double income = result.getDouble("income");
				Date startDate = result.getDate("Start_Date");
				Date finishDate = result.getDate("Finish_Date");
				String tourName = result.getString("Tour_Name");
				String otherBands = result.getString("Other_Bands");
				String showNumber = result.getString("Show_Number");
				boolean isHeadliner = result.getBoolean("Is_Headliner");
				String festivalname = result.getString("Festival_Name");
				String sceneName = result.getString("Scene_Name");
				String description = result.getString("Description");
				int venueId = result.getInt("Venue_Id");
				int bandId = result.getInt("Band_Id");
				int crewId = result.getInt("Crew_Id");
				
				if(category == 1) {
					//Show show = new Show(date, time, showLength, income, startDate, finishDate, tourName, otherBands, showNumber, isHeadliner, Venue.allVenues.get(venueId), ticketList, crew);
				}
				
				
			}
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
		
	}
	
//	public static void addCrewWorker(Person person) {
//		try {
//
//			if(person instanceof CrewWorker) {
//				CrewWorker crewWorker = ((CrewWorker)person);
//			
//				Connection connection = Database.openConnection();
//
//				String updateString = "INSERT INTO PERSON (Category,PersonName,Surname,email,phoneNumber,salary,experienceYears)" + " VALUES (?,?,?,?,?,?,?);"; 
//				
//				PreparedStatement add = null;
//				
//					connection.setAutoCommit(false);
//					add = connection.prepareStatement(updateString);
//					
//					add.setInt(1, crewWorker.getDyscryminator());
//					add.setString(2, crewWorker.getName());
//					add.setString(3, crewWorker.getSurname());
//					add.setString(4, crewWorker.getPhoneNumber());
//					add.setDouble(5, crewWorker.getSalary());
//					add.setInt(6, crewWorker.getExperienceYears());
//					
//					add.executeUpdate();
//					connection.commit();
//					
//					CrewWorker my_crew_worker = new CrewWorker(crewWorker.getDyscryminator(), crewWorker.getName(), crewWorker.getSurname(), crewWorker.getEmail(), crewWorker.getPhoneNumber(), crewWorker.getSalary(), crewWorker.getExperienceYears());
//					CrewWorker.allCrewWorkersEkstensja.add(my_crew_worker);
//			}
//		}catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//	}
	
	
	public static void addCrew(Crew crew, CrewWorker worker) {
		
		try {

			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from Crew");
			int x = 0;
			while(rs.next()) {
				x = x+1;
			}
			
			statement.executeUpdate("INSERT INTO Crew (ID_Crew,Crew_Size, Person_ID)"
					+ " VALUES ("
					+ getString(x+1+"")	    + ","
					+ getString(crew.getSize()+"")	    + ","
					+ getString(venue.getStreet())    + ","
					+ getString(venue.isOpenAir()+"")       + ","
					+ getString(venue.getCapacity()+"")     + ");");

			
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
		
	}
	
	
	public static void getAllCrew() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from Crew");
			while(result.next()) {
				
				int size = result.getInt("Crew_Size");
				Crew crew = new Crew(size);
				Crew.crewList.add(crew);
			}
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	public static void saveTicketToDataBase(Ticket ticket) {
		try {
			Connection connection = Database.openConnection();

			String updateString = "INSERT INTO Ticekt (price,BuyingDate,vipPrice,eePrice,regularPrice,isAvaiable)" + " VALUES (?,?,?,?,?,?);"; 
			
			PreparedStatement add = null;
			
				connection.setAutoCommit(false);
				add = connection.prepareStatement(updateString);
		
		
		
	}catch(Exception e) {
		System.out.println("Connection to database failed.");
		e.printStackTrace();
	}
	
	}
	
	public static void getAllTickets() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from Venue");
			while(result.next()) {
				
				double price = result.getDouble("price");
				Date buyingDate = result.getDate("BuyingDate");
				String vipPrice = result.getString("vipPrice");
				String eePrice = result.getString("eePrice");
				String regular = result.getString("regularPrice");
				boolean isAvaiable = result.getBoolean("isAvaiable");
				
				Ticket ticket = new Ticket(price, buyingDate, vipPrice, eePrice, regular, isAvaiable);
				Ticket.allTickets.add(ticket);

				
			}
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
//	public static void getAllVenue() {
//		try {
//			Class.forName("org.postgresql.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
//			Statement statement = connection.createStatement();
//			ResultSet result = statement.executeQuery("select * from Venue");
//			while(result.next()) {
//				
//				String venueName = result.getString("Venue_name");
//				String street = result.getString("street");
//				boolean isOpenAir = result.getBoolean("is_Open_air");
//				int capacity = result.getInt("capacity");
//				
//				Venue venue = new Venue(venueName, street, isOpenAir, capacity);
//				Venue.allVenues.add(venue);
//				
//			}
//		}catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//	}
	
	
//	public static void getAllOrder() {
//
//		
//		try {
//			Connection connection = Database.openConnection();
//			Statement statement = connection.createStatement();
//			PreparedStatement preparedStatement = null;
//			
//			String getAllData = "select * from Customer_order";
//			preparedStatement = connection.prepareStatement(getAllData);
//			ResultSet rs = preparedStatement.executeQuery();
//			
//			while(rs.next()) {
//				
//				String oderNumber = rs.getString("Order_Number");
//				Date postingDate = rs.getDate("Posting_Date");
//				Date deliveryDate = rs.getDate("Delivery_Date");
//				String address = rs.getString("Address");
//				
//				mas.Order order = new mas.Order(oderNumber,postingDate,deliveryDate,address);
//				Order.allOrders.add(order);
//			}
//		}catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//		
//		
//		
//	}
	
	public static void getAllPlaysIn() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from Band");
			while(result.next()) {
				
				String role = result.getString("Role_In_Band");
				int personId = result.getInt("Person_ID");
				int bandId = result.getInt("Band_Id");
				
				
				
				PlaysIn playsIn = new PlaysIn("Drummer",Person.allPersonsEkstensja.get(personId), Band.getAllBandsEkstensja().get(bandId));
				PlaysIn.playsInExtence.add(playsIn);
				System.out.println(PlaysIn.playsInExtence);
			}
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	
	
	
	public static String addToItemList(DefaultListModel listModel) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from ShopItem");
			while(result.next()) {
				listModel.addElement(
					"Name: "+	result.getString("itemName") + " | " 
					+"Weight: "+	 result.getString("weight") + "| "
					+"Price: "	+ result.getString("price") + " | "
					+"Limited Edition?: "	+ result.getString("limitedEdition") + " | "
					+"Description: "	+ result.getString("description")
						
				);
			}
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
		return "";
	}
	
	public static String addAlbumItemList(DefaultListModel listModel) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from Album");
			while(result.next()) {
				listModel.addElement(
					"Name: "+	result.getString("albumName") + " | " 
					+"Weight: "+	 result.getString("albumLength") + "| "
					+"Price: "	+ result.getString("songsNumber") + " | "
					+"Limited Edition?: "	+ result.getString("description") + " | "
					+"Description: "	+ result.getString("producer")
						
				);
			}
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
		return "";
	}
	

	
//	public static void addNewAlbum(Album album) {
//	
//		try {
//
//			Connection connection = Database.openConnection();
//
//			String updateString = "INSERT INTO Album (albumName,albumLength,songsNumber,description,producer)" + " VALUES (?,?,?,?,?);"; 
//			
//			PreparedStatement add = null;
//			
//				connection.setAutoCommit(false);
//				add = connection.prepareStatement(updateString);
//				
//				add.setString(1, album.getName());
//				add.setString(2, album.getLength());
//				add.setString(3, album.getSongsNumber());
//				add.setString(4, album.getDescription());
//				add.setString(5,album.getProducer());
//				
//				add.executeUpdate();
//				connection.commit();
//				
//				Album my_album = new Album(album.getName(),album.getLength(),album.getSongsNumber(),album.getDescription(),album.getProducer());;
//				Album.allAlbumsEkstensja.add(my_album);
//			
//		}catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public static void addNewShopItem(ShopItem item) {
//		
//		try {
//
//			Connection connection = Database.openConnection();
//
//			String updateString = "INSERT INTO ShopItem (itemName,weight,price,limitedEdition,description)" + " VALUES (?,?,?,?,?);"; 
//			
//			PreparedStatement add = null;
//			
//				connection.setAutoCommit(false);
//				add = connection.prepareStatement(updateString);
//				
//				add.setString(1, item.getName());
//				add.setDouble(2, item.getWeight());
//				add.setDouble(3, item.getPrice());
//				add.setBoolean(4, item.getIsLimitedEdition());
//				add.setString(3, item.getDescription());
//			
//				add.executeUpdate();
//				connection.commit();
//				
//				ShopItem shopItem = new ShopItem(item.getName(), item.getWeight(), item.getPrice(), item.getIsLimitedEdition(), item.getDescription());
//				ShopItem.allShopItemsEkstensja.add(shopItem);
//				
//		}catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//		
//	}
	
	
//	public static void addMusicianBand(Band band, Musician musician,Role role) {
//		
//		try {
//			//przejsc po ekstensji i kazdy obiekt zapisac
//			Class.forName("org.postgresql.Driver");
//			
//			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
//			Statement statement = connection.createStatement();
//			
//			
//			ResultSet rs = statement.executeQuery("select id_band from Band where band_name ='"+band.getName()+"'");
//		
//			int band_id = 0;
//			int musician_id =0;
//			
//			while(rs.next()) {
//				band_id = rs.getInt(1);
//			}
//			
//			ResultSet rs2 = statement.executeQuery("select id_Person from Person where category = 1 AND personname ='"+musician.getName()+"' AND surname = '"+musician.getSurname()+"'");
//			
//			while(rs2.next()) {
//				musician_id = rs2.getInt(1);
//			}
//			
//			//for(MusicianBand_BAG musicianBand_BAG : MusicianBand_BAG.getMusicianBandEkstensja()) {
//				statement.executeUpdate("INSERT INTO MusicianBand (Band_ID, Musician_ID,role_in_band)"
//						+ " VALUES ("
//						+ band_id	    + ","
//						+ musician_id    + ","
//						+ "'"+role+"'"       + ");");
//			//}
//			
//			MusicianBand_BAG musicianBand_BAG = new MusicianBand_BAG(band, musician, role);
//				
//			System.out.println(statement);
//		}catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//		
//	}
	
	
//	public static void getMusicianBand() {
//		try {
//			Class.forName("org.postgresql.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","leno1044");
//			Statement statement = connection.createStatement();
//			ResultSet result = statement.executeQuery("select * from MusicianBand");
//			while(result.next()) {
//				
//				int bandId = result.getInt("Band_ID");
//				int musicianId = result.getInt("musician_ID");
//				String roleInBand = result.getString("role_in_band");
//				Role role = Role.valueOf(roleInBand);
//				//odtowrzyc band i musician na podstawie ID
//				Band band = Band.allBandsEkstensja.get(bandId);
//				
//				Musician musician = Musician.allMusiciansEkstensja.get(musicianId-1);
//				
//
//				MusicianBand_BAG musicianBand_BAG = new MusicianBand_BAG(band, musician, role);
//				//MusicianBand_BAG.musicianBandEkstensja.add(musicianBand_BAG);
////				PlaysIn playsIn = new PlaysIn("Drummer",Person.allPersons.get(personId), Band.allBands.get(bandId));
////				PlaysIn.playsInExtence.add(playsIn);
////				System.out.println(PlaysIn.playsInExtence);
//			}
//		}catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//	}
	
//	public static void addBandInfoToDatabase(BandInfo bandInfo) {
//		
//		try {
//
//			Connection connection = Database.openConnection();
//
//			String updateString = "INSERT INTO BandInfo (bandName, foundYear, musicStyle)" + " VALUES (?,?,?);"; 
//			
//			PreparedStatement add = null;
//			add = connection.prepareStatement(updateString);
//
//			add.setString(1, bandInfo.getName());
//			add.setString(2, bandInfo.getFoundYear());
//			add.setString(3, bandInfo.getMusicStyle());
//
//			add.executeUpdate();
//			connection.commit();
//			
//			BandInfo my_band_info = new BandInfo(bandInfo.getName(), bandInfo.getFoundYear(), bandInfo.getMusicStyle());
//			BandInfo.allBandInfoEkstensja.add(my_band_info);
//			
//		}catch(Exception e) {
//			System.out.println("Connection to database failed.");
//			e.printStackTrace();
//		}
//		
//	}
	
}
