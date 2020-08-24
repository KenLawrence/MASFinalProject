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
import mas.Album;

public class AddNewAlbumPanel extends JFrame{
	private JTextField nameTextField;
	private JTextField lengthTextField;
	private JTextField songsNumberTextField;
	private JTextField descriptionTextField;
	private JTextField producerTextField;

	private JFrame thisFrame = this;
	
	public AddNewAlbumPanel(JFrame frame) {
	getContentPane().setBackground(new Color(218, 112, 214));
	getContentPane().setLayout(null);
	
	JLabel addNewAlbumLabel = new JLabel("Add new Album");
	addNewAlbumLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
	addNewAlbumLabel.setBounds(10, 11, 251, 51);
	getContentPane().add(addNewAlbumLabel);
	
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
	
	JLabel lengthLabel = new JLabel("Length");
	lengthLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lengthLabel.setBounds(34, 122, 151, 38);
	getContentPane().add(lengthLabel);
	
	JLabel songNumberLabel = new JLabel("Songs number");
	songNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	songNumberLabel.setBounds(34, 171, 151, 38);
	getContentPane().add(songNumberLabel);
	
	JLabel descriptionLabel = new JLabel("Description");
	descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	descriptionLabel.setBounds(34, 220, 151, 38);
	getContentPane().add(descriptionLabel);
	
	JLabel producerLabel = new JLabel("Producer");
	producerLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	producerLabel.setBounds(34, 269, 151, 38);
	getContentPane().add(producerLabel);
	
	nameTextField = new JTextField();
	nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
	nameTextField.setBounds(190, 73, 186, 38);
	getContentPane().add(nameTextField);
	nameTextField.setColumns(10);
	
	lengthTextField = new JTextField();
	lengthTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lengthTextField.setColumns(10);
	lengthTextField.setBounds(190, 122, 186, 38);
	getContentPane().add(lengthTextField);
	
	songsNumberTextField = new JTextField();
	songsNumberTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
	songsNumberTextField.setColumns(10);
	songsNumberTextField.setBounds(190, 171, 186, 38);
	getContentPane().add(songsNumberTextField);
	
	descriptionTextField = new JTextField();
	descriptionTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
	descriptionTextField.setColumns(10);
	descriptionTextField.setBounds(190, 220, 186, 38);
	getContentPane().add(descriptionTextField);
	
	producerTextField = new JTextField();
	producerTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
	producerTextField.setColumns(10);
	producerTextField.setBounds(190, 269, 186, 38);
	getContentPane().add(producerTextField);
	
	JButton okButton = new JButton("OK");
	okButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
	okButton.setBounds(223, 366, 151, 51);
	getContentPane().add(okButton);
	
	backButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			frame.setVisible(true);
			thisFrame.setVisible(false);
		}
	});
	
	okButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String name = nameTextField.getText();
			String length = lengthTextField.getText();
			String songsNumber = songsNumberTextField.getText();
			String description = descriptionTextField.getText();
			String producer = producerTextField.getText();
			
			Album album = new Album(name, length, songsNumber, description, producer);
			Album.addNewAlbum(album);
			
		}
	});
	
	}	
}
