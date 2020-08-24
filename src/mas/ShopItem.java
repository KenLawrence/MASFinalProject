package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import functionality.Database;

public class ShopItem {

	private String name;
	private Double weight;
	private Double price;
	private boolean isLimitedEdition;
	private String description;
	
	public static ArrayList<ShopItem> allShopItemsEkstensja = new ArrayList<ShopItem>();
	
	public ShopItem(String name, Double weight, Double price, boolean isLimitedEdition, String description) {
		setName(name);
		setWeight(weight);
		setPrice(price);
		setIsLimitedEdition(isLimitedEdition);
		setDescription(description);
		allShopItemsEkstensja.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		validateString(name);
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		if(weight < 0) {
			throw new IllegalArgumentException("Weight cannot be negative");
		}
		if(weight > 10000) {
			throw new IllegalArgumentException("Weight is too big!");
		}
		this.weight = weight;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		if(price < 0 ) {
			throw new IllegalArgumentException("Price cannot be negative");
		}
		if(price > 100000) {
			throw new IllegalArgumentException("Price is too big!");
		}
		this.price = price;
	}

	public boolean getIsLimitedEdition() {
		return isLimitedEdition;
	}

	public void setIsLimitedEdition(boolean isLimitedEdition) {
		this.isLimitedEdition = isLimitedEdition;
	}

	public String getDescription() {
		return description;
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

		public static void addNewShopItem(ShopItem item) {
			
			try {

				Connection connection = Database.openConnection();

				String updateString = "INSERT INTO ShopItem (itemName,weight,price,limitedEdition,description)" + " VALUES (?,?,?,?,?);"; 
				
				PreparedStatement add = null;
				
					connection.setAutoCommit(false);
					add = connection.prepareStatement(updateString);
					
					add.setString(1, item.getName());
					add.setDouble(2, item.getWeight());
					add.setDouble(3, item.getPrice());
					add.setBoolean(4, item.getIsLimitedEdition());
					add.setString(3, item.getDescription());
				
					add.executeUpdate();
					connection.commit();

					
			}catch(Exception e) {
				System.out.println("Connection to database failed.");
				e.printStackTrace();
			}
			
		}
	   
	@Override
	public String toString() {
		return "ShopItem [name=" + name + ", weight=" + weight + ", price=" + price + ", isLimitedEdition="
				+ isLimitedEdition + ", description=" + description + "]";
	}
	
	   
	   
}
