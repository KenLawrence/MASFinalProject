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
import mas.Musician;
import mas.Person;

public class CreateMusicianPanel extends JFrame{

	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField songsNumberTextField;
	private JTextField emailTextField;
	private JTextField descriptionTextField;
	private JTextField producerTextField;
	private JTextField phoneNumberTextField;
	private JTextField salaryTextField;
	private JTextField instrumentTextField;
	
	private JFrame myFrame = this;
	
	public CreateMusicianPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel setBandInfoLabel = new JLabel("Create musician");
		setBandInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		setBandInfoLabel.setBounds(10, 11, 251, 51);
		getContentPane().add(setBandInfoLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(10, 438, 151, 51);
		getContentPane().add(backButton);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setBounds(34, 73, 151, 38);
		getContentPane().add(nameLabel);
		
		JLabel Surname = new JLabel("surname");
		Surname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Surname.setBounds(34, 122, 151, 38);
		getContentPane().add(Surname);
		
		JLabel email = new JLabel("email");
		email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		email.setBounds(34, 171, 151, 38);
		getContentPane().add(email);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTextField.setBounds(190, 73, 186, 38);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		surnameTextField = new JTextField();
		surnameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(190, 122, 186, 38);
		getContentPane().add(surnameTextField);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailTextField.setColumns(10);
		emailTextField.setBounds(190, 171, 186, 38);
		getContentPane().add(emailTextField);
		
		JButton OKButton = new JButton("OK");
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		OKButton.setBounds(225, 438, 151, 51);
		getContentPane().add(OKButton);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(34, 220, 151, 38);
		getContentPane().add(lblPhoneNumber);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(190, 220, 186, 38);
		getContentPane().add(phoneNumberTextField);
		
		JLabel salary = new JLabel("Salary");
		salary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salary.setBounds(34, 275, 151, 38);
		getContentPane().add(salary);
		
		salaryTextField = new JTextField();
		salaryTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salaryTextField.setColumns(10);
		salaryTextField.setBounds(190, 269, 186, 38);
		getContentPane().add(salaryTextField);
		
		JLabel Instrument = new JLabel("Instruments");
		Instrument.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Instrument.setBounds(34, 324, 151, 38);
		getContentPane().add(Instrument);
		
		instrumentTextField = new JTextField();
		instrumentTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		instrumentTextField.setColumns(10);
		instrumentTextField.setBounds(190, 324, 186, 38);
		getContentPane().add(instrumentTextField);
		
		OKButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				String name = nameTextField.getText();
				String surname = surnameTextField.getText();
				String email = emailTextField.getText();
				String phoneNumber = phoneNumberTextField.getText();
				double salary = Double.parseDouble(salaryTextField.getText());
				String instrument = instrumentTextField.getText();
				
				Person person = new Musician(Musician.dyscriminator,name,surname,email,phoneNumber,salary,instrument);
				Person.addPerson(person); //  CZY TU NAPEWNO DODAJEMY PERONS A NIE MUSICIAN ? ? ? ? ? ?? ?? ? ? ? ? ? ? ? ? ?
				//Database.getAllPersons();
				//Database.getAllPlaysIn();
				
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(true);
				myFrame.setVisible(false);
				
			}
		});
	}
	
}
