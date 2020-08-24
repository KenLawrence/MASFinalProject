package mas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import functionality.Database;
import interfaces.IEmployee;

public abstract class Employee extends Person implements IEmployee{

	private double salary;
	
	private String instrument;
	private int maxSubordinates;
	private int expYears;
	private boolean b = false;
	
	public static final int dyscriminator = 4;
	
	public static  ArrayList<Employee> allEmployesEkstensja = new ArrayList<Employee>();
	
	public Employee(int category,String name, String surname, String email, String phoneNumber, double salary) {
		super(dyscriminator,name, surname, email, phoneNumber,salary);
		allEmployesEkstensja.add(this);
	}
	

	public Employee(int category,String name, String surname, String email, String phoneNumber, double salary,String instrument) {
		super(dyscriminator,name, surname, email, phoneNumber,salary);
		setInstrument(instrument);
		allEmployesEkstensja.add(this);
	}
	
	public Employee(int category,String name, String surname, String email, String phoneNumber, double salary, int maxSubordinates) {
		super(dyscriminator,name, surname, email, phoneNumber,salary);
		setMaxSubordinates(maxSubordinates);
		allEmployesEkstensja.add(this);
	}
	public Employee(int category,String name, String surname, String email, String phoneNumber, double salary, int expYears,boolean b) {
		super(dyscriminator,name, surname, email, phoneNumber,salary);
		setExperienceYears(expYears);
		allEmployesEkstensja.add(this);
	}
	
	@Override
	public double getSalary() {
		return salary;
	}

	@Override
	public void setSalary(double salary) {
		if(salary < 1800) {
			throw new IllegalArgumentException("Salary must be bigger!");
		}
		if(salary > 180000) {
			throw new IllegalArgumentException("Salary is too big!");
		}
		this.salary = salary;
	}
	
	private void validateString(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Name cannot be null!");
		}
		if (str.isEmpty()) {
			throw new IllegalArgumentException("Name must have 1 character or more");
		}
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


	public int getExpYears() {
		return expYears;
	}


	public void setExpYears(int expYears) {
		if(expYears < 0) {
			throw new IllegalArgumentException("Experience years cannot be negative");
		}
		if(expYears > 60) {
			throw new IllegalArgumentException("Experience years are too big!");
		}
		this.expYears = expYears;
	}


	public int getDyscriminator() {
		return dyscriminator;
	}


	public static void addEmployee(Employee employee) {
		try {


			Connection connection = Database.openConnection();
			String updateString = "INSERT INTO Employee (category,personName,surname,email,phoneNumber,salary)"
					+ " VALUES (?,?,?,?,?,?);";

			PreparedStatement add = null;

			connection.setAutoCommit(false);
			add = connection.prepareStatement(updateString);

			add.setInt(1, employee.getDyscriminator());
			add.setString(2, employee.getName());
			add.setString(3, employee.getSurname());
			add.setString(4, employee.getEmail());
			add.setString(5, employee.getPhoneNumber());
			add.setDouble(6, employee.getSalary());

			add.executeUpdate();
			connection.commit();

		
		}
	
		catch (Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	
	public static void getAllEmployees() {
		try {
			Connection connection = Database.openConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			
			String getAllData = "select * from Employee";
			preparedStatement = connection.prepareStatement(getAllData);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int category = rs.getInt("category");
				String personName = rs.getString("personName");
				String surname = rs.getString("surname");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				double salary = rs.getDouble("salary");
				String instrument = rs.getString("instrument");
				int maxSubordinates = rs.getInt("maxSubordinates");
				int experienceYears = rs.getInt("experienceYears");
				
				if(dyscriminator == 1) {
					Employee employee_musician = new Musician(dyscriminator,personName,surname,email,phoneNumber,salary,instrument);
				}
				if(dyscriminator == 2) {
					Employee employee_manager = new Manager(dyscriminator, personName, surname, email, phoneNumber, salary, maxSubordinates);
				}
				if(dyscriminator == 3) {
					Employee employee_Crew_Worker = new CrewWorker(dyscriminator, personName, surname, email, phoneNumber, salary, experienceYears);
				}				
			}
			rs.close();
			preparedStatement.close();

		
		
		}catch(Exception e) {
			System.out.println("Connection to database failed.");
			e.printStackTrace();
		}
	}
	
	
	@Override
	public String toString() {
		return super.toString() + salary + "]";
	}
	
	
	
	
}
