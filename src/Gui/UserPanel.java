package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;

import functionality.Database;

public class UserPanel extends JFrame{
	private JFrame myFrame = this;
	
	public UserPanel(JFrame frame, String userName) {
//		Database.getAllGoods();
//		Venue.
//		Database.getAllOrder();
//		Database.getAllCrew();
//		Database.getAllTickets();
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel WelcomeLabel = new JLabel("Welcome ");
		WelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		WelcomeLabel.setBounds(10, 11, 105, 51);
		getContentPane().add(WelcomeLabel);
		
		JLabel UserNameLabel = new JLabel("");
		UserNameLabel.setText(userName+"!");
		UserNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		UserNameLabel.setBounds(125, 11, 221, 51);
		getContentPane().add(UserNameLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton searchShopButton = new JButton("Search shop");
		searchShopButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchShopButton.setBounds(34, 73, 151, 51);
		getContentPane().add(searchShopButton);
		
		JButton buyTicketButton = new JButton("Buy ticket");
		buyTicketButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buyTicketButton.setBounds(34, 135, 151, 51);
		getContentPane().add(buyTicketButton);
		
		JButton checkShowButton = new JButton("Check show");
		checkShowButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkShowButton.setBounds(34, 197, 151, 51);
		getContentPane().add(checkShowButton);
		
		JButton aboutBandButton = new JButton("About band");
		aboutBandButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		aboutBandButton.setBounds(34, 259, 151, 51);
		getContentPane().add(aboutBandButton);
		
		JButton backButton = new JButton("Log out");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(34, 366, 151, 51);
		getContentPane().add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				myFrame.setVisible(false);
				
				LoginPanel.loginTextField.setText("");
				LoginPanel.passwordField.setText("");
				
			}
		});
		
		searchShopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ShopPanel shopPanel = new ShopPanel(myFrame);
				shopPanel.setSize(705, 460);
				shopPanel.setDefaultCloseOperation(shopPanel.EXIT_ON_CLOSE);
				shopPanel.setVisible(true);
				shopPanel.setResizable(false);
				
				myFrame.setVisible(false);
				
			}
		});
		
		buyTicketButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BuyTicketPanel buyTicketPanel = new BuyTicketPanel(myFrame);
				buyTicketPanel.setSize(705, 460);
				buyTicketPanel.setDefaultCloseOperation(buyTicketPanel.EXIT_ON_CLOSE);
				buyTicketPanel.setVisible(true);
				buyTicketPanel.setResizable(false);
				
				myFrame.setVisible(false);
			}
		});
		
		checkShowButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckShowPanel checkShowPanel = new CheckShowPanel(myFrame);
				checkShowPanel.setSize(705, 460);
				checkShowPanel.setDefaultCloseOperation(checkShowPanel.EXIT_ON_CLOSE);
				checkShowPanel.setVisible(true);
				checkShowPanel.setResizable(false);
				
				myFrame.setVisible(false);
			}
		});

		aboutBandButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AboutBandPanel aboutBandPanel = new AboutBandPanel(myFrame);
				aboutBandPanel.setSize(705, 460);
				aboutBandPanel.setDefaultCloseOperation(aboutBandPanel.EXIT_ON_CLOSE);
				aboutBandPanel.setVisible(true);
				aboutBandPanel.setResizable(false);
				
				myFrame.setVisible(false);
				
			}
		});
	}
}
