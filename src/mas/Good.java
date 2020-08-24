package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import functionality.Database;

public class Good {

	private String name;
	private double weight;
	private double price;
	private boolean isLimitedEdition;
	private String description;
	private int goodID;
	
	public static ArrayList<Good> allGoods = new ArrayList<Good>();
	
	public Good(int goodID,String name, double weigh,double price, boolean isLimitedEdition, String description) {
		setGoodID(goodID);
		setName(name);
		setWeight(weigh);
		setPrice(price);
		setLimitedEdition(isLimitedEdition);
		setDescription(description);
		allGoods.add(this);
	}

	public int getGoodID() {
		return goodID;
	}
	
	public void setGoodID(int goodID) {
		this.goodID = goodID;
	}


	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		validateString(name);
		this.name = name;
	}

	
	public double getWeight() {
		return weight;
	}

	
	public void setWeight(double weight) {
		if(weight < 0) {
			throw new IllegalArgumentException("Weight cannot be smaller than 0kg !");
		}
		if(weight > 20) {
			throw new IllegalArgumentException("Weight cannot be bigger than 20kg !");
		}
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		if(price < 0) {
			throw new IllegalArgumentException("Price cannot be smaller than 0$ !");
		}
		if(price > 2000) {
			throw new IllegalArgumentException("Price cannot be bigger than 2000$ ");
		}
		this.price = price;
	}



	public boolean isLimitedEdition() {
		return isLimitedEdition;
	}



	public void setLimitedEdition(boolean isLimitedEdition) {
		this.isLimitedEdition = isLimitedEdition;
	}



	public String getDescription() {
		return description;
	}

	public static void addGood(Good good) {
		try {

			Connection connection = Database.openConnection();

			String updateString = "INSERT INTO Good (Good_Name, weigh, price,Is_Limited_edition,description)" + " VALUES (?,?,?,?,?);"; 
			
			PreparedStatement add = null;
			add = connection.prepareStatement(updateString);

			add.setString(1, good.getName());
			add.setDouble(2, good.getWeight());
			add.setDouble(3, good.getPrice());
			add.setBoolean(4, good.isLimitedEdition());
			add.setString(5,good.getDescription());

			add.executeUpdate();
			connection.commit();
			
			
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	public static void getAllGoods() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Good";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String good_Name = rs.getString("Venue_name");
				double weigh = rs.getDouble("weigh");
				double price = rs.getDouble("price");
				boolean isLimited = rs.getBoolean("Is_Limited_edition");
				String description= rs.getString("description");
				
				
				Good good = new Good(getMaxIDByGood(), good_Name, weigh, price, isLimited, description);
				
			}
			rs.close();
			preparedStatement.close();

			
		
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	public static int getMaxIDByGood() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Good";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			int x = 0;
			while(rs.next()) {
				x = x+1;
			}
			
			return x;
			
		}	
		catch(Exception e) {	
			e.printStackTrace();
		}
		return 0;
	}
	
	public static Good getGoodByID(int id) {
		
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Good where good_id ='"+id+"'";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String Good_Name = rs.getString("Good_Name");
				double weigh = rs.getDouble("weigh");
				double price = rs.getDouble("price");
				boolean Is_Limited_edition = rs.getBoolean("Is_Limited_edition");
				String description = rs.getString("description");
				rs.close();
				preparedStatement.close();
				
				Good good = new Good(id,Good_Name,weigh,price,Is_Limited_edition,description);
				
				return good;
		}
		
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
		return null;
		
	}
	

	public void setDescription(String description) {
		validateString(description);
		this.description = description;
	}

	  private void validateString(String str) {
			if (str == null) {
				throw new IllegalArgumentException("Name cannot be null!");
			}
			if (str.isEmpty()) {
				throw new IllegalArgumentException("Name must have 1 character or more");
			}
	    }

	@Override
	public String toString() {
		return "Good [name=" + name + ", weight=" + weight + ", price=" + price + ", isLimitedEdition="
				+ isLimitedEdition + ", description=" + description + ", goodID=" + goodID + "]";
	}


	
	
	
}
