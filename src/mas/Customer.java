package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import functionality.Database;

public class Customer extends Person{
	
	private int discount = 0;
	
	public static final int dyscriminator = 4;
	
	public static ArrayList<Customer> allCustomersEkstensja = new ArrayList<Customer>();
	
	public Customer(int category,String name, String surname,String email, String phoneNumber, int discount) {
		super(dyscriminator,name, surname, email, phoneNumber);
		setDiscount(discount);
		allCustomersEkstensja.add(this);
	}

	
	
	public  int getDyscriminator() {
		return dyscriminator;
	}



	public int getDiscount() {
		return discount;
	}
	
	public void setDiscount(int discount) {
		if(discount < 0) {
			throw new IllegalArgumentException("discount cannot be smaller than 0% !");
		}
		if(discount > 20) {
			throw new IllegalArgumentException("discount cannot be bigger than 20% !");
		}
		this.discount = discount;
	}

	
	  private void validateString(String str) {
			if (str == null) {
				throw new IllegalArgumentException("Name cannot be null!");
			}
			if (str.isEmpty()) {
				throw new IllegalArgumentException("Name must have 1 character or more");
			}
	    }
	
	  public static void addCustomer(Customer customer) {
			try {

				Connection connection = Database.openConnection();

				String updateString = "INSERT INTO Customer (category, customer_name, customer_surname,customer_email,customer_address,phone_number,discount,customer_order_ID)" + " VALUES (?,?,?,?,?,?,?,?,?,?);"; 
				
				PreparedStatement add = null;
				add = connection.prepareStatement(updateString);

				add.setInt(1, customer.getDyscriminator());
				add.setString(2, customer.getName());
				add.setString(3, customer.getSurname());
				add.setString(4, customer.getEmail());
				add.setString(5, customer.getPhoneNumber());
				add.setInt(6, customer.getDiscount());
				add.executeUpdate();
				connection.commit();
				
				
			}catch(Exception e) {
				System.out.println("Connection to database failed.");
				e.printStackTrace();
			}
	  }
	  
	@Override
	public String toString() {
		return "Customer [discount=" + discount + "]";
	}
	
	
	
}
