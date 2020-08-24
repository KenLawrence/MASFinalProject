package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import functionality.Database;
import mas.BandInfo;

public class SetBandInformationPanel extends JFrame{

	private JTextField nameTextField;
	private JTextField foundYearTextField;
	private JTextField songsNumberTextField;
	private JTextField musicStyleTextField;
	private JTextField descriptionTextField;
	private JTextField producerTextField;
	
	private JFrame thisFrame = this;
	
	public SetBandInformationPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel setBandInfoLabel = new JLabel("Set band information");
		setBandInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		setBandInfoLabel.setBounds(10, 11, 251, 51);
		getContentPane().add(setBandInfoLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(34, 362, 151, 51);
		getContentPane().add(backButton);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setBounds(34, 73, 151, 38);
		getContentPane().add(nameLabel);
		
		JLabel foundYearLabel = new JLabel("Found year");
		foundYearLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		foundYearLabel.setBounds(34, 122, 151, 38);
		getContentPane().add(foundYearLabel);
		
		JLabel musicStyleLabel = new JLabel("Music style");
		musicStyleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		musicStyleLabel.setBounds(34, 171, 151, 38);
		getContentPane().add(musicStyleLabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTextField.setBounds(190, 73, 186, 38);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		foundYearTextField = new JTextField();
		foundYearTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		foundYearTextField.setColumns(10);
		foundYearTextField.setBounds(190, 122, 186, 38);
		getContentPane().add(foundYearTextField);
		
		musicStyleTextField = new JTextField();
		musicStyleTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		musicStyleTextField.setColumns(10);
		musicStyleTextField.setBounds(190, 171, 186, 38);
		getContentPane().add(musicStyleTextField);
		
		JButton OKButton = new JButton("OK");
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		OKButton.setBounds(225, 362, 151, 51);
		getContentPane().add(OKButton);
		
		JButton addMusicianButton = new JButton("add Musician");
		addMusicianButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addMusicianButton.setBounds(406, 362, 151, 51);
		getContentPane().add(addMusicianButton);
		
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
				
				String name = nameTextField.getText();
				String foundYear = foundYearTextField.getText();
				String musicStyle = musicStyleTextField.getText();
				
				BandInfo bandInfo = new BandInfo(name, foundYear, musicStyle);
				BandInfo.addBandInfo(bandInfo);
				
			}
		});
		
		addMusicianButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CreateMusicianPanel createMusicianPanel = new CreateMusicianPanel(thisFrame);

				createMusicianPanel.setSize(705, 600);
				createMusicianPanel.setDefaultCloseOperation(createMusicianPanel.EXIT_ON_CLOSE);
				createMusicianPanel.setVisible(true);
				createMusicianPanel.setResizable(false);
				
				thisFrame.setVisible(false);
			}
		});
		
	}
	
}
