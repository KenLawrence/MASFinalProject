package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import functionality.Database;
import mas.Band;

public class AboutBandPanel extends JFrame{

	private JTextField nameTextField;
	private JTextField lengthTextField;
	private JTextField songsNumberTextField;
	private JTextField descriptionTextField;
	private JTextField producerTextField;
	
	private JFrame myFrame = this;
	
	public AboutBandPanel(JFrame frame) {
		Band.getAllBand();
		System.out.println(Band.allBandsEkstensja);
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel aboutBandLabel = new JLabel("About band");
		aboutBandLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		aboutBandLabel.setBounds(10, 5, 251, 51);
		getContentPane().add(aboutBandLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(35, 367, 151, 51);
		getContentPane().add(backButton);
		
		JLabel infoLabel = new JLabel("");
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		infoLabel.setVerticalAlignment(SwingConstants.TOP);
		infoLabel.setText("<html>AB/CD was an American thrash metal band from Huntington Park, California.<br/> The band was formed in 1981 by guitarists Kerry King and Jeff Hanneman, drummer Dave Lombardo, and bassist and vocalist Tom Araya.<br/> AB/CD's fast and aggressive musical style made them one of the founding \"big four\"<br/> bands of thrash metal, alongside Metallica, Megadeth and Anthrax. AB/CD's final lineup comprised King, Araya, drummer Paul Bostaph and guitarist Gary Holt.<br/> Drummer Jon Dette was also a member of the band.<html>");
		infoLabel.setBounds(88, 56, 527, 112);
		getContentPane().add(infoLabel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(88, 179, 527, 177);
		getContentPane().add(lblNewLabel);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				myFrame.setVisible(false);
				
			}
		});
		
	}
	
}
