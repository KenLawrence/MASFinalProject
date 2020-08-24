package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import functionality.Database;

public class Order {
	
	public static ArrayList<Order> allOrdersEkstensja = new ArrayList<Order>();
	
	private String orderNumber;
	private Date postingDate;
	private Date deliveryDate;
	private String addressTo;
	private Good good;
	
	public Order(String orderNumber,Date postingDate, Date deliveryDate, String addressTo,Good good) {
		setOrderNumber(orderNumber);
		setPostingDate(postingDate);
		setDeliveryDate(deliveryDate);
		setAddressTo(addressTo);
		setGood(good);
		allOrdersEkstensja.add(this);
	}

	
	public String getOrderNumber() {
		return orderNumber;
	}
	
	
	public void setOrderNumber(String orderNumber) {
		validateString(orderNumber);
		this.orderNumber = orderNumber;
	}


	public Date getPostingDate() {
		return postingDate;
	}




	public void setPostingDate(Date postingDate) {
//		if(postingDate.before(getCurrentDate())) {
//			throw new IllegalArgumentException("Wrong posting date!");
//		}
//		if(postingDate.after(get2DaysAhead())) {
//			throw new IllegalArgumentException("Wrong posting date!");	
//		}
		this.postingDate = postingDate;
	}


	public Good getGood() {
		return good;
	}


	public void setGood(Good good) {
		if(good == null) {
			throw new IllegalArgumentException("Good cannot be null");
		}
		this.good = good;
	}


	public Date getDeliveryDate() {
		return deliveryDate;
	}




	public void setDeliveryDate(Date deliveryDate) {
//		if(deliveryDate.before(getCurrentDate())) {
//			throw new IllegalArgumentException("Wrong delivery date!");
//		}
		this.deliveryDate = deliveryDate;
	}

	public String getAddressTo() {
		return addressTo;
	}


	public void setAddressTo(String addressTo) {
		validateString(addressTo);
		this.addressTo = addressTo;
	}

	  private void validateString(String str) {
			if (str == null) {
				throw new IllegalArgumentException("Name cannot be null!");
			}
			if (str.isEmpty()) {
				throw new IllegalArgumentException("Name must have 1 character or more");
			}
	    }
	  
		private Date getCurrentDate() {
			Calendar cal = Calendar.getInstance();
			Date today = cal.getTime();
			return today;
		}
	  
		
		private Date get2DaysAhead() {
			Calendar cal = Calendar.getInstance();
			Date today = cal.getTime();
			cal.add(Calendar.DAY_OF_YEAR, 2);
			Date myDate = cal.getTime();
			return myDate; 
		}
		
		public static void addOrder(Order order,Good good) {
			try {		
				Connection connection = Database.openConnection();
				String updateString = "INSERT INTO Customer_order (Order_Number,Posting_Date,Delivery_Date,Address,Good_Id)" + " VALUES (?,?,?,?,?);"; 
				
				PreparedStatement add = null;
				
					connection.setAutoCommit(false);
					add = connection.prepareStatement(updateString);

					add.setString(1, order.getOrderNumber());
					add.setDate(2, (java.sql.Date) order.getPostingDate());
					add.setDate(3, (java.sql.Date) order.getDeliveryDate());
					add.setString(4, order.getAddressTo());
					add.setInt(5, good.getGoodID());
					
					add.executeUpdate();
					connection.commit();

					
					
			}catch(Exception e) {
				System.out.println("Connection to database failed.");
				e.printStackTrace();
			}
		}
		
		
		public static void getAllOrder() {

			
			try {
				Connection connection = Database.openConnection();
				Statement statement = connection.createStatement();
				PreparedStatement preparedStatement = null;
				
				String getAllData = "select * from Customer_order";
				preparedStatement = connection.prepareStatement(getAllData);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					
					String oderNumber = rs.getString("Order_Number");
					Date postingDate = rs.getDate("Posting_Date");
					Date deliveryDate = rs.getDate("Delivery_Date");
					String address = rs.getString("Address");
					int goodID = rs.getInt("Good_Id");
					
					mas.Order order = new mas.Order(oderNumber,postingDate,deliveryDate,address,Good.getGoodByID(goodID));
				}
			}catch(Exception e) {
				System.out.println("Connection to database failed.");
				e.printStackTrace();
			}
			
			
			
		}


		@Override
		public String toString() {
			return "Order [orderNumber=" + orderNumber + ", postingDate=" + postingDate + ", deliveryDate="
					+ deliveryDate + ", addressTo=" + addressTo + ", goodID=" + good.getGoodID() + "]";
		}
		
	
	
	
	
}
