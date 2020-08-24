package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import functionality.Database;
import mas.Venue;

public class SetVenuePanel extends JFrame{

	private JTextField nameTextField;
	private JTextField venueNameTextField;
	private JTextField lengthTextField;
	private JTextField streetTextField;
	private JTextField songsNumberTextField;
	private JTextField descriptionTextField;
	private JTextField capacityTextField;
	private JTextField producerTextField;
	
	private JFrame thisFrame = this;
	
	public SetVenuePanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel venueLabel = new JLabel("Venue");
		venueLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		venueLabel.setBounds(10, 11, 251, 51);
		getContentPane().add(venueLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(34, 366, 151, 51);
		getContentPane().add(backButton);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setBounds(34, 73, 151, 38);
		getContentPane().add(nameLabel);
		
		JLabel streetLabel = new JLabel("Street");
		streetLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		streetLabel.setBounds(34, 122, 151, 38);
		getContentPane().add(streetLabel);
		
		JLabel openAirLabel = new JLabel("Open air ?");
		openAirLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		openAirLabel.setBounds(34, 171, 151, 38);
		getContentPane().add(openAirLabel);
		
		JLabel capacityLabel = new JLabel("Capacity");
		capacityLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		capacityLabel.setBounds(34, 220, 151, 38);
		getContentPane().add(capacityLabel);
		
		venueNameTextField = new JTextField();
		venueNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		venueNameTextField.setBounds(190, 73, 186, 38);
		getContentPane().add(venueNameTextField);
		venueNameTextField.setColumns(10);
		
		streetTextField = new JTextField();
		streetTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		streetTextField.setColumns(10);
		streetTextField.setBounds(190, 122, 186, 38);
		getContentPane().add(streetTextField);
		
		capacityTextField = new JTextField();
		capacityTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		capacityTextField.setColumns(10);
		capacityTextField.setBounds(190, 220, 186, 38);
		getContentPane().add(capacityTextField);
		
		JLabel headlinerLabel = new JLabel("Headliner?");
		headlinerLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		headlinerLabel.setBounds(34, 317, 151, 38);
		getContentPane().add(headlinerLabel);
		
		JRadioButton yesRadioButton = new JRadioButton("Yes");
		yesRadioButton.setBounds(190, 175, 71, 38);
		getContentPane().add(yesRadioButton);
		
		JRadioButton noRadioButton = new JRadioButton("No");
		noRadioButton.setBounds(305, 175, 71, 38);
		getContentPane().add(noRadioButton);
		
		JButton OKButton = new JButton("OK");
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		OKButton.setBounds(225, 366, 151, 51);
		getContentPane().add(OKButton);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {


				frame.setVisible(true);
				thisFrame.setVisible(false);
				
			}
		});
		
		OKButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = venueNameTextField.getText();
				String street = streetTextField.getText();
				boolean isOpenAir = false;
				int capacity = Integer.parseInt(capacityTextField.getText());
				
				Venue venue = new Venue(name, street, isOpenAir, capacity);
				Venue.addVenue(venue);
			}
		});
	}
	
}
