package mas;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;

import Enum.ShowType;

public class Show {

	private Date showDate;
	private Time time;
	private String showLength;
	private double income;
	
	
	private Date startDate;
	private Date finishDate;
	private String tourName;
	private String otherBands;
	private int showNumber;
	private boolean isHeadliner;
	
	
	private String name;
	private String sceneName;
	
	private String desription;
	
	private EnumSet<ShowType> showTypes;
	
	private Venue venue;
	private static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	private Crew crew;
	
	public Show(Date showDate, Time time, String showLength, double income, Date startDate, Date finishDate, String tourname,String otherBands, int showNUmber, boolean isHeadliner,Venue venue,ArrayList<Ticket> ticketList, Crew crew) {
		setShowDate(showDate);
		setTime(time);
		setShowLength(showLength);
		setIncome(income);
		setStartDate(startDate);
		setFinishDate(finishDate);
		setTourName(tourname);
		setOrherBands(otherBands);
		setShowNumber(showNUmber);
		setHeadliner(isHeadliner);
		showTypes = EnumSet.of(ShowType.Tour);
		setVenue(venue);
	}

	
	public Show(Date showDate, Time time, String showLength, double income,String name, String sceneName,Venue venue,ArrayList<Ticket> ticketList,Crew crew) {
		setShowDate(showDate);
		setTime(time);
		setShowLength(showLength);
		setIncome(income);
		setName(sceneName);
		setSceneName(sceneName);
		showTypes = EnumSet.of(ShowType.Music_Festival);
		setVenue(venue);
	}
	
	
	public Show(Date showDate, Time time, String showLength, double income,String description, Venue venue,ArrayList<Ticket> ticketList,Crew crew) {
		setShowDate(showDate);
		setTime(time);
		setShowLength(showLength);
		setIncome(income);
		setDesription(description);
		showTypes = EnumSet.of(ShowType.Special_Show);
		setVenue(venue);
	}
	
	public void setTicekts(ArrayList<Ticket> list) {
		this.ticketList = list;
	}
	
	public ArrayList<Ticket> getTicketList(){
		return new ArrayList<Ticket>(ticketList);
	}
	
	public Crew getCrew() {
		return crew;
	}
	
	public void setCrew(Crew crew) {
		this.crew = crew;
	}
	
	public Venue getVenue() {
		return venue;
	}
	
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	public Date getShowDate() {
		return showDate;
	}


	public void setShowDate(Date showDate) {
		
		if(showDate.before(getCurrentDate())) {
			throw new IllegalArgumentException("Wrong date! Cannot set show date from the past!");
		}

		this.showDate = showDate;
	}


	public Time getTime() {
		return time;
	}


	public void setTime(Time time) {		
		this.time = time;
	}



	public String getShowLength() {
		return showLength;
	}

	public void setShowLength(String showLength) {
		validateString(showLength);
		this.showLength = showLength;
	}



	public double getIncome() {
		return income;
	}



	public void setIncome(double income) {
		if(income < 0) {
			throw new IllegalArgumentException("Income from the show cannot be smaller than 0!");
		}
		if(income > 5_000_000) {
			throw new IllegalArgumentException("Income from the show can't be that big!");
		}
		this.income = income;
	}

	public Date getStartDate() {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		return startDate;
	}



	public void setStartDate(Date startDate) {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		if(startDate.before(getCurrentDate())) {
			throw new IllegalArgumentException("Cannot start the tour before tommorow!");
		}
		if(startDate.getYear() > get2YearsAhead().getYear()) {
			throw new IllegalArgumentException("Impossible to set a tour date from more than 2 years!");
		}
		this.startDate = startDate;
	}


	public Date getFinishDate() {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		return finishDate;
	}



	public void setFinishDate(Date finishDate) {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		if(finishDate.before(getCurrentDate())) {
			throw new IllegalArgumentException("Cannot finish the tour before tommorow!");
		}
		if(finishDate.getYear() > get2YearsAhead().getYear()) {
			throw new IllegalArgumentException("Impossible to finish a tour later than 2 years!");
		}
		this.finishDate = finishDate;
	}



	public String getTourName() {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		return tourName;
	}



	public void setTourName(String tourName) {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		validateString(tourName);
		this.tourName = tourName;
	}



	public String getOrherBands() {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		return otherBands;
	}



	public void setOrherBands(String otherBands) {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		validateString(otherBands);
		this.otherBands = otherBands;
	}



	public int getShowNumber() {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		return showNumber;
	}



	public void setShowNumber(int showNumber) {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		if(showNumber < 5) {
			throw new IllegalArgumentException("Tour cannot be shorter than 5 shows!");
		}
		if(showNumber > 150) {
			throw new IllegalArgumentException("Tour cannot be longer than 150 shows!");
		}
		this.showNumber = showNumber;
	}



	public boolean isHeadliner() {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		return isHeadliner;
	}



	public void setHeadliner(boolean isHeadliner) {
		if(this.showTypes.contains(ShowType.Tour)) {
			throw new IllegalArgumentException("This is only tour information!");
		}
		this.isHeadliner = isHeadliner;
	}
	
	public String getName() {
		if(this.showTypes.contains(ShowType.Music_Festival)) {
			throw new IllegalArgumentException("This is only festival music information!");
		}
		return name;
	}

	public void setName(String name) {
		if(this.showTypes.contains(ShowType.Music_Festival)) {
			throw new IllegalArgumentException("This is only festival music information!");
		}
		validateString(name);
		this.name = name;
	}

	public String getSceneName() {
		if(this.showTypes.contains(ShowType.Music_Festival)) {
			throw new IllegalArgumentException("This is only festival music information!");
		}
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		if(this.showTypes.contains(ShowType.Music_Festival)) {
			throw new IllegalArgumentException("This is only festival music information!");
		}
		validateString(sceneName);
		this.sceneName = sceneName;
	}
	
	public String getDesription() {
		if(this.showTypes.contains(ShowType.Special_Show)) {
			throw new IllegalArgumentException("This is only special show information!");
		}
		return desription;
	}

	public void setDesription(String desription) {
		if(this.showTypes.contains(ShowType.Special_Show)) {
			throw new IllegalArgumentException("This is only special show information!");
		}
		validateString(desription);
		this.desription = desription;
	}

	
	private Date get2YearsAhead() {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, 2);
		Date myDate = cal.getTime();
		return myDate; 
	}
	
	private Date getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		return today;
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
		return "Show [showDate=" + showDate + ", time=" + time + ", showLength=" + showLength + ", income=" + income
				+ "]";
	}
	
	
}
