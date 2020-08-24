package mas;

import java.util.ArrayList;

public class PlaysIn {

	String role;
	Person p;
	Band band;
	
	public static ArrayList<PlaysIn> playsInExtence = new ArrayList<PlaysIn>();
	
	public PlaysIn(String role,Person p,Band band) {
		setPerson(p);
		setBand(band);
		this.role = role;
	}

	
	
	public Person getp() {
		return p;
	}

	public void setPerson(Person p) {
		this.p=p;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}
	
	
	
}
