package mas;

import java.sql.Date;

import Enum.Role;
import Gui.LoginPanel;
import functionality.Database;

public class Main {
	
	public static void main(String[] args) {
		openLoginPanel();	
		//Database.addMusicianBand();
	//	Database.getAllBand();
		//System.out.println(Band.getAllBandsEkstensja());
		
//		Person p2 = new Musician(1,"Marcin","Nowak","abcd@xDD.pl","112332412",7000,"lead guitar");
//		Database.addMusician(p2);
		
		//Database.getPerson();
		//System.out.println(Band.allBandsEkstensja);
		
//		Band band = new Band("Metallica", 1981, "metal");
//		Musician musician = new Musician(1, "Adam", "Kowalski", "aa@o2.pl", "123123329", 6000, "Bassssss");
//		Role role =Role.Bassist;
//		
//		Database.addMusicianBand(band, musician, role);
//		 Musician m = new Musician(1, "Jan", "Kowalski", "abc@.pl", "123123123", 13444, "gitarka");
//		Database.getMusicianBand();
//		System.out.println(MusicianBand_BAG.musicianBandEkstensja);
		
//		Venue venue = new Venue("Atlas", "Jasna", false,3000);
//		Venue.addVenue(venue);
//		Venue.getAllVenue();
//		Venue.getAllVenue();
//		System.out.println(Venue.showExtent());
//		Person p2 = new CrewWorker(2,"Sebastian","Wysocki","seba@wtf.pl","999888777",3000,5);
//		Database.addCrewWorker(p2);
//		Database.getPerson();
//		System.out.println(CrewWorker.allCrewWorkersEkstensja);
//		ShopItem shopItem = new ShopItem("item", 34.2, 24.0, false, "good t shirt");
//		ShopItem.allShopItemsEkstensja.add(shopItem);
//		System.out.println(ShopItem.allShopItemsEkstensja);
//		Musician.getMusicianEkstensja();
//		System.out.println(Person.allPersonsEkstensja);
		
//		Order.getAllOrder();
//		System.out.println(Order.allOrdersEkstensja);
		
//		Good good = new Good(3, "test", 12.2, 60.0, true, "działaja PLS");
//		Order order = new Order("2234",new Date(2020,10,8),new Date(2020,10,12),"wyszogrodzka strit",good);;
//		Order.addOrder(order, good);
	}

	
	public static void openLoginPanel() {
		LoginPanel loginPanel = new LoginPanel();
		loginPanel.setSize(1920, 1080);
		loginPanel.setDefaultCloseOperation(loginPanel.EXIT_ON_CLOSE);
		loginPanel.setVisible(true);
		loginPanel.setResizable(false);
	}
	
}
