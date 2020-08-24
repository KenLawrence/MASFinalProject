package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import functionality.Database;
import mas.Show;
import mas.Ticket;

public class SetShowPanel extends JFrame{

	
	private JTextField dateTextField;
	private JTextField timeTextField;
	private JTextField showTimeTextField;
	private JTextField incomeTextField;
	
	private JFrame thisFrame = this;
	private JTextField priceTextField;
	
	Show show;
	
	public String price;
	
	public SetShowPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel setShowLabel = new JLabel("Set show");
		setShowLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		setShowLabel.setBounds(10, 11, 251, 51);
		getContentPane().add(setShowLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(34, 366, 171, 51);
		getContentPane().add(backButton);
		
		JLabel dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateLabel.setBounds(34, 58, 151, 38);
		getContentPane().add(dateLabel);
		
		JLabel timeLabel = new JLabel("Time");
		timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		timeLabel.setBounds(34, 107, 151, 38);
		getContentPane().add(timeLabel);
		
		JLabel showTimeLabel = new JLabel("Show time");
		showTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		showTimeLabel.setBounds(34, 156, 151, 38);
		getContentPane().add(showTimeLabel);
		
		JLabel incomeLabel = new JLabel("Income");
		incomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		incomeLabel.setBounds(34, 205, 151, 38);
		getContentPane().add(incomeLabel);
		
		
		dateTextField = new JTextField();
		dateTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dateTextField.setBounds(195, 60, 194, 38);
		getContentPane().add(dateTextField);
		dateTextField.setColumns(10);
		
		timeTextField = new JTextField();
		timeTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		timeTextField.setColumns(10);
		timeTextField.setBounds(195, 109, 194, 38);
		getContentPane().add(timeTextField);
		
		showTimeTextField = new JTextField();
		showTimeTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		showTimeTextField.setColumns(10);
		showTimeTextField.setBounds(195, 158, 194, 38);
		getContentPane().add(showTimeTextField);
		
		incomeTextField = new JTextField();
		incomeTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		incomeTextField.setColumns(10);
		incomeTextField.setBounds(195, 207, 194, 38);
		getContentPane().add(incomeTextField);
		
		JButton OKButton = new JButton("OK");
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		OKButton.setBounds(219, 366, 171, 51);
		getContentPane().add(OKButton);
		
		JButton ticketDetailsButton = new JButton("Ticket details");
		ticketDetailsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ticketDetailsButton.setBounds(34, 302, 171, 51);
		getContentPane().add(ticketDetailsButton);
		
		JButton setTourButton = new JButton("Set tour");
		setTourButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setTourButton.setBounds(219, 302, 171, 51);
		getContentPane().add(setTourButton);
		
		JButton setSpecialEventButton = new JButton("Special event");
		setSpecialEventButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setSpecialEventButton.setBounds(405, 366, 171, 51);
		getContentPane().add(setSpecialEventButton);
		
		JButton setVenueButton = new JButton("Set venue");
		setVenueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setVenueButton.setBounds(405, 302, 171, 51);
		getContentPane().add(setVenueButton);
		
		JButton setFestivalButton = new JButton("Festival");
		setFestivalButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setFestivalButton.setBounds(584, 366, 171, 51);
		getContentPane().add(setFestivalButton);
		
		JLabel lblTicketPrice = new JLabel("ticket price");
		lblTicketPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTicketPrice.setBounds(34, 254, 151, 38);
		getContentPane().add(lblTicketPrice);
		
		priceTextField = new JTextField();
		priceTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		priceTextField.setColumns(10);
		priceTextField.setBounds(195, 253, 194, 38);
		getContentPane().add(priceTextField);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(true);
				thisFrame.setVisible(false);
				
			}
		});
		
		setTourButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SetTourPanel tourPanel = new SetTourPanel(thisFrame);
				tourPanel.setSize(705,460);
				tourPanel.setDefaultCloseOperation(tourPanel.EXIT_ON_CLOSE);
				tourPanel.setVisible(true);
				tourPanel.setResizable(false);
				tourPanel.setVisible(true);
				thisFrame.setVisible(false);
				
			}
		});
		
		
		setFestivalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setFestivalPanel setFestivalPanel = new setFestivalPanel(thisFrame);
				setFestivalPanel.setSize(705,460);
				setFestivalPanel.setDefaultCloseOperation(setFestivalPanel.EXIT_ON_CLOSE);
				setFestivalPanel.setVisible(true);
				setFestivalPanel.setResizable(false);
				setFestivalPanel.setVisible(true);
				thisFrame.setVisible(false);
			}
		});
		
		setSpecialEventButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SetSpecialEventPanel setSpecialEventPanel = new SetSpecialEventPanel(thisFrame);
				setSpecialEventPanel.setSize(705,460);
				setSpecialEventPanel.setDefaultCloseOperation(setSpecialEventPanel.EXIT_ON_CLOSE);
				setSpecialEventPanel.setVisible(true);
				setSpecialEventPanel.setResizable(false);
				setSpecialEventPanel.setVisible(true);
				thisFrame.setVisible(false);
			}
		});
		
		ticketDetailsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TicketDetailsPanel ticketDetailsPanel = new TicketDetailsPanel(thisFrame);
				ticketDetailsPanel.setSize(705,460);
				ticketDetailsPanel.setDefaultCloseOperation(ticketDetailsPanel.EXIT_ON_CLOSE);
				ticketDetailsPanel.setVisible(true);
				ticketDetailsPanel.setResizable(false);
				ticketDetailsPanel.setVisible(true);
				thisFrame.setVisible(false);
			}
		});
		
		setVenueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SetVenuePanel setVenuePanel = new SetVenuePanel(thisFrame);
				setVenuePanel.setSize(705,460);
				setVenuePanel.setDefaultCloseOperation(setVenuePanel.EXIT_ON_CLOSE);
				setVenuePanel.setVisible(true);
				setVenuePanel.setResizable(false);
				setVenuePanel.setVisible(true);
				thisFrame.setVisible(false);
				
			}
		});
		OKButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				price = priceTextField.getText();
				double p = Double.parseDouble(price);
				String vip = TicketDetailsPanel.vipPrice;
				String ee = TicketDetailsPanel.eePrice;
				String regular = TicketDetailsPanel.regularPrice;
				LocalDate now = LocalDate.now();
				ZoneId defaultZoneId = ZoneId.systemDefault();
				Date date = Date.from(now.atStartOfDay(defaultZoneId).toInstant());
				
				Ticket ticket = new Ticket(p, date, vip, ee, regular, true);
				Database.saveTicketToDataBase(ticket);
				
			}
		});
	}
}
