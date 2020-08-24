package Gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import functionality.Database;
import mas.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class NewAccountPanel extends JFrame{

	private JTextField loginTextField;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField emailTextField;
	private JTextField phoneNumberTextField;
	
	private JFrame myFrame = this;
	private JTextField addressTextField;
	private JPasswordField passwordField;
	
	public NewAccountPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel loginLabel = new JLabel("New account");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		loginLabel.setBounds(23, 11, 148, 44);
		getContentPane().add(loginLabel);
		
		loginTextField = new JTextField();
		loginTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginTextField.setBounds(163, 72, 176, 36);
		getContentPane().add(loginTextField);
		loginTextField.setColumns(10);
		
		JButton backButton = new JButton("Back");

		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(10, 366, 115, 30);
		getContentPane().add(backButton);
		
		JButton createButton = new JButton("Create");
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		createButton.setBounds(185, 366, 148, 30);
		getContentPane().add(createButton);
		
		JLabel loginLabel1 = new JLabel("Login");
		loginLabel1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		loginLabel1.setBounds(10, 72, 115, 36);
		getContentPane().add(loginLabel1);
		
		JLabel PasswordLabel1 = new JLabel("Password");
		PasswordLabel1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PasswordLabel1.setBounds(10, 113, 115, 36);
		getContentPane().add(PasswordLabel1);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nameLabel.setBounds(10, 156, 115, 36);
		getContentPane().add(nameLabel);
		
		JLabel surnameLabel = new JLabel("Surname");
		surnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		surnameLabel.setBounds(10, 195, 115, 36);
		getContentPane().add(surnameLabel);
		
		JLabel emailLabel = new JLabel("e-mail");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		emailLabel.setBounds(10, 234, 115, 36);
		getContentPane().add(emailLabel);
		
		JLabel phoneNumberlabel = new JLabel("Phone numb.");
		phoneNumberlabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		phoneNumberlabel.setBounds(10, 273, 148, 36);
		getContentPane().add(phoneNumberlabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTextField.setColumns(10);
		nameTextField.setBounds(163, 156, 176, 36);
		getContentPane().add(nameTextField);
		
		surnameTextField = new JTextField();
		surnameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(163, 195, 176, 36);
		getContentPane().add(surnameTextField);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailTextField.setColumns(10);
		emailTextField.setBounds(163, 234, 176, 36);
		getContentPane().add(emailTextField);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(163, 273, 176, 36);
		getContentPane().add(phoneNumberTextField);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		addressLabel.setBounds(10, 319, 148, 36);
		getContentPane().add(addressLabel);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addressTextField.setColumns(10);
		addressTextField.setBounds(163, 319, 176, 36);
		getContentPane().add(addressTextField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 113, 176, 36);
		getContentPane().add(passwordField);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				myFrame.dispose();
				frame.setVisible(true);
			}
		});
		
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(checkIfFilled(loginTextField, passwordField,
								 nameTextField, surnameTextField, 
								 emailTextField, phoneNumberTextField, addressTextField) == false){
					
					JOptionPane.showMessageDialog(myFrame, "Please fill all the fields!");
					
				}
				
				String login= loginTextField.getText();
				String password = passwordField.getText();
				String name = nameTextField.getText();
				String surname = surnameTextField.getText();
				String email = emailTextField.getText();
				String phoneNumber = phoneNumberTextField.getText();
				String address = addressTextField.getText();
				
			
				Customer customer = new Customer(Customer.dyscriminator,name ,surname,email,phoneNumber,0);
				Customer.addCustomer(customer);
				
				
			}
		});
		
		
	}
	
	private boolean checkIfFilled(JTextField tf1,JTextField tf2,JTextField tf3,JTextField tf4,JTextField tf5,JTextField tf6, JTextField tf7) {
		if(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty() || tf5.getText().isEmpty() || tf6.getText().isEmpty() || tf7.getText().isEmpty()) {
			return false;
		}
		return true;
	}
}
