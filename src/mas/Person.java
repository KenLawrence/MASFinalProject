package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import functionality.Database;

@MappedSuperclass
public abstract class Person {
	
	private int dyscriminator;
	private String name;
	private String surname;
	private String email;
	private String phoneNumber;
	
	private double salary;
	
	private String instrument;
	private int maxSubordinates;
	private int experienceYears;
	
	private int discount;

	public static ArrayList<Person> allPersonsEkstensja = new ArrayList<Person>();
	
	public Person(int dyscriminator,String name, String surname,String email, String phoneNumber,double salary,String instrument,int maxSubordinates, int experienceYears, int discount) {
		setDyscriminator(dyscriminator);
		setName(name);
		setSurname(surname);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setSalary(salary);
		setInstrument(instrument);
		setMaxSubordinates(maxSubordinates);
		setExperienceYears(experienceYears);
		setDiscount(discount);
		allPersonsEkstensja.add(this);
		// dorobic konstruktory dla reszty.
	}

	public Person(int category,String name, String surname, String email, String phoneNumber, double salary) {
		setDyscriminator(dyscriminator);
		setName(name);
		setSurname(surname);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setSalary(salary);
	}
	
	public Person(int category,String name, String surname,String email, String phoneNumber, int discount) {
		setDyscriminator(dyscriminator);
		setName(name);
		setSurname(surname);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setDiscount(discount);
	}
	public Person(int category,String name, String surname,String email, String phoneNumber) {
		setDyscriminator(dyscriminator);
		setName(name);
		setSurname(surname);
		setEmail(email);
		setPhoneNumber(phoneNumber);
	}
	
	public int getDyscriminator() {
		return dyscriminator;
	}


	public void setDyscriminator(int dyscriminator) {
		this.dyscriminator = dyscriminator;
	}


	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		validateString(name);
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		validateString(surname);
		this.surname = surname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		validateString(email);
		validateEmail(email);
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		validateString(phoneNumber);
		validatePhoneNumber(phoneNumber);
		this.phoneNumber = phoneNumber;
	}

	
	
	
	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		if(salary < 0) {
			throw new IllegalArgumentException("Salary cannot be negative!");
		}
		if(salary > 1000000) {
			throw new IllegalArgumentException("Salary is too big!");
		}
		this.salary = salary;
	}


	public String getInstrument() {
		return instrument;
	}


	public void setInstrument(String instrument) {
		validateString(instrument);
		this.instrument = instrument;
	}


	public int getMaxSubordinates() {
		return maxSubordinates;
	}


	public void setMaxSubordinates(int maxSubordinates) {
		if(maxSubordinates < 0 ) {
			throw new IllegalArgumentException("Max subordinates cannot be negative");
		}
		if(maxSubordinates > 250) {
			throw new IllegalArgumentException("Max subordinates is too big!");
		}
		this.maxSubordinates = maxSubordinates;
	}

	
	
	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		if(discount < 0) {
			throw new IllegalArgumentException("Discount cannot be negative!");
		}
		if(discount > 50) {
			throw new IllegalArgumentException("Discount is too big!");			
		}
		this.discount = discount;
	}


	public int getExperienceYears() {
		return experienceYears;
	}


	public void setExperienceYears(int experienceYears) {
		if(experienceYears < 0) {
			throw new IllegalArgumentException("Experience years cannot be negative");
		}
		if(experienceYears > 60) {
			throw new IllegalArgumentException("Experience years are too big!");
		}
		this.experienceYears = experienceYears;
	}


	public static void addPerson(Person person) {
		try {
			Connection connection = Database.openConnection();

			String updateString = "INSERT INTO Person(Category,PersonName, Surname,email,phoneNumber,salary,instrument,maxSubordinates,experienceYears,discount)" + " VALUES (?,?,?,?,?,?,?,?,?,?);"; 
			
			PreparedStatement add = null;
			add = connection.prepareStatement(updateString);
			
			add.setInt(1, person.getDyscriminator());
			add.setString(2, person.getName());
			add.setString(3, person.getSurname());
			add.setString(4, person.getEmail());
			add.setString(5, person.getPhoneNumber());
			add.setDouble(6, person.getSalary());
			add.setString(7, person.getInstrument());
			add.setInt(8, person.getMaxSubordinates());
			add.setInt(9, person.getExperienceYears());
			add.setInt(10, person.getDiscount());

			add.executeUpdate();
			connection.commit();
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	public static void getAllPerson() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Person";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int dyscriminator =  rs.getInt("Category");
				String personName = rs.getString("PersonName");
				String surname = rs.getString("Surname");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				double  salary  = rs.getDouble("salary");
				String instrument = rs.getString("instrument");
				int maxSubordinates = rs.getInt("maxSubordinates");
				int experienceYears = rs.getInt("experienceYears");
				int discount = rs.getInt("discount");
				
				if(dyscriminator == 1) {
					Person person_musician = new Musician(dyscriminator,personName,surname,email,phoneNumber,salary,instrument);
				}
				if(dyscriminator == 2) {
					Person person_manager = new Manager(dyscriminator, personName, surname, email, phoneNumber, salary, maxSubordinates);
				}
				if(dyscriminator == 3) {
					Person person_Crew_Worker = new CrewWorker(dyscriminator, personName, surname, email, phoneNumber, salary, experienceYears);
				}
				if(dyscriminator == 4) {
					Person person_customer = new Customer(dyscriminator,personName ,surname, email, phoneNumber, discount);
				}
				
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
	
	private void validateEmail(String email) {
		if(!email.contains("@")) {
			throw new IllegalArgumentException("Wrong email! (no '@') ");
		}
		if(!email.contains(".")) {
			throw new IllegalArgumentException("Wrong email! (no '.') ");
		}
	}
	
	private void validatePhoneNumber(String phoneNumber) {
		if(phoneNumber.length() < 9) {
			throw new IllegalArgumentException("Phone number is too short!");
		}
		if(phoneNumber.length() > 9) {
			throw new IllegalArgumentException("Phone number is too long!");
		}
		if(!phoneNumber.matches("[0-9]+")) {
			throw new IllegalArgumentException("Phone number contains letter!");
		}
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}

}
