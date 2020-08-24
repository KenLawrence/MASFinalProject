package mas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.omg.CORBA.Current;

public class Ticket {

	private double price;
	private Date buyingDate;
	private String vipPrice;
	private String eePrice;
	private String regularPrice;
	private boolean isAvaiable;
	
	public static ArrayList<Ticket> allTickets = new ArrayList<Ticket>();
	
	private final static Date systemStartDate = new Date(2018, 1, 1); 
	
	private Show show;
	
	public Ticket(double price, Date buyingDate, String vipPrice, String eePrice, String regularPrice, boolean isAvaiable) {
		setPrice(price);
		setBuyingDate(buyingDate);
		setVipPrice(vipPrice);
		setEePrice(eePrice);
		setRegularPrice(regularPrice);
		setAvaiable(isAvaiable);
	}

	
	public String getVipPrice() {
		return vipPrice;
	}


	public void setVipPrice(String vipPrice) {
		validateString(vipPrice);
		this.vipPrice = vipPrice;
	}


	public String getEePrice() {
		return eePrice;
	}


	public void setEePrice(String eePrice) {
		validateString(eePrice);
		this.eePrice = eePrice;
	}


	public String getRegularPrice() {
		return regularPrice;
	}


	public void setRegularPrice(String regularPrice) {
		validateString(regularPrice);
		this.regularPrice = regularPrice;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price < 0) {
			throw new IllegalArgumentException("Price cannot be smaller than 0!");
		}
		if(price > 15_000) {
			throw new IllegalArgumentException("Price cannot be bigger than 0!");
		}
		this.price = price;
	}
	public Date getBuyingDate() {
		return buyingDate;
	}

	public void setBuyingDate(Date buyingDate) {
		
		if(buyingDate.getYear() > get2YearsAhead().getYear()) {
			throw new IllegalArgumentException("Impossible to set a date from more than 2 years!");
		}
		this.buyingDate = buyingDate;
	}


	

	public boolean isAvaiable() {
		return isAvaiable;
	}

	public void setAvaiable(boolean isAvaiable) {
		this.isAvaiable = isAvaiable;
	}


	private Date get2YearsAhead() {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, 2);
		Date myDate = cal.getTime();
		return myDate; 
	}
	
	
	   private void validateString(String str) {
			if (str == null) {
				throw new IllegalArgumentException("Name cannot be null!");
			}
			if (str.isEmpty()) {
				throw new IllegalArgumentException("Name must have 1 character or more");
			}
	    }
	
		public Show getShow() {
			return show;
		}
		
		public void setShow(Show show) {
			this.show = show;
		}
	@Override
	public String toString() {
		return "Ticket [price=" + price + ", buyingDate=" + buyingDate + ", isAvaiable=" + isAvaiable
				+ "]";
	}
	
	
	
	
	
}
