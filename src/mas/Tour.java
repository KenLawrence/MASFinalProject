package mas;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import javax.print.attribute.standard.MediaSize.Other;

public class Tour{ 	// to musi dziedziczyc po show !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	private Date startDate;
	private Date finishDate;
	private String tourName;
	private String otherBands;
	private int showNumber;
	private boolean isHeadliner;

	public Tour() {

	}
	
	
	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		if(startDate.before(getCurrentDate())) {
			throw new IllegalArgumentException("Cannot start the tour before tommorow!");
		}
		if(startDate.getYear() > get2YearsAhead().getYear()) {
			throw new IllegalArgumentException("Impossible to set a tour date from more than 2 years!");
		}
		this.startDate = startDate;
	}


	public Date getFinishDate() {
		return finishDate;
	}



	public void setFinishDate(Date finishDate) {
		if(finishDate.before(getCurrentDate())) {
			throw new IllegalArgumentException("Cannot finish the tour before tommorow!");
		}
		if(finishDate.getYear() > get2YearsAhead().getYear()) {
			throw new IllegalArgumentException("Impossible to finish a tour later than 2 years!");
		}
		this.finishDate = finishDate;
	}



	public String getTourName() {
		return tourName;
	}



	public void setTourName(String tourName) {
		validateString(tourName);
		this.tourName = tourName;
	}



	public String getOrherBands() {
		return otherBands;
	}



	public void setOrherBands(String otherBands) {
		validateString(otherBands);
		this.otherBands = otherBands;
	}



	public int getShowNumber() {
		return showNumber;
	}



	public void setShowNumber(int showNumber) {
		if(showNumber < 5) {
			throw new IllegalArgumentException("Tour cannot be shorter than 5 shows!");
		}
		if(showNumber > 150) {
			throw new IllegalArgumentException("Tour cannot be longer than 150 shows!");
		}
		this.showNumber = showNumber;
	}



	public boolean isHeadliner() {
		return isHeadliner;
	}



	public void setHeadliner(boolean isHeadliner) {
		this.isHeadliner = isHeadliner;
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
		
		private Date get2YearsAhead() {
			Calendar cal = Calendar.getInstance();
			Date today = cal.getTime();
			cal.add(Calendar.YEAR, 2);
			Date myDate = cal.getTime();
			return myDate; 
		}
	@Override
	public String toString() {
		return "Tour [startDate=" + startDate + ", finishDate=" + finishDate + ", tourName=" + tourName
				+ ", orherBands=" + otherBands + ", showNumber=" + showNumber + ", isHeadliner=" + isHeadliner + "]";
	}
	
	
	
}
