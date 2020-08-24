package Gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import functionality.Database;

import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;


public class LoginPanel extends JFrame {

	public static JTextField loginTextField;
	private JFrame myFrame = this;
	public static JPasswordField passwordField;

	public LoginPanel() {
		getContentPane().setLayout(null);
		repaint();
		setVisible(true);
		
				loginTextField = new JTextField();
				loginTextField.setBounds(356, 17, 153, 26);
				getContentPane().add(loginTextField);
				loginTextField.setForeground(Color.RED);
				loginTextField.setBackground(Color.WHITE);
				loginTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
				loginTextField.setColumns(10);
		
				passwordField = new JPasswordField();
				passwordField.setBounds(366, 54, 153, 26);
				getContentPane().add(passwordField);
				passwordField.setForeground(Color.RED);
				passwordField.setBackground(Color.WHITE);
				passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
				JLabel passwordLabel = new JLabel("Password");
				passwordLabel.setBounds(262, 53, 105, 31);
				getContentPane().add(passwordLabel);
				passwordLabel.setForeground(Color.RED);
				passwordLabel.setBackground(Color.WHITE);
				passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));

		JLabel label = new JLabel("");
		label.setBounds(940, 7, 0, 0);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(1029, 7, 0, 0);
		getContentPane().add(label_1);

		JButton LoginButton = new JButton("Login");
		LoginButton.setBounds(574, 253, 209, 49);
		getContentPane().add(LoginButton);
		LoginButton.setForeground(Color.RED);
		LoginButton.setBackground(Color.DARK_GRAY);
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 25));

		JButton createNewAccountButton = new JButton("New account");
		createNewAccountButton.setBounds(561, 29, 171, 33);
		getContentPane().add(createNewAccountButton);
		createNewAccountButton.setForeground(Color.RED);
		createNewAccountButton.setBackground(Color.DARK_GRAY);
		createNewAccountButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
				JLabel lblLogin = new JLabel("Login");
				lblLogin.setBounds(252, 11, 105, 31);
				getContentPane().add(lblLogin);
				lblLogin.setForeground(Color.RED);
				lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
				lblLogin.setBackground(Color.WHITE);
		JLabel lblNewLabel = new JLabel("");
		// lblNewLabel = new JLabel(new
		// ImageIcon(getClass().getResource("/images/metallica.jpeg")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/metallica.jpg")));
		getContentPane().add(lblNewLabel);

		createNewAccountButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				NewAccountPanel newAccountPanel = new NewAccountPanel(myFrame);
				newAccountPanel.setSize(705, 460);
				newAccountPanel.setDefaultCloseOperation(newAccountPanel.EXIT_ON_CLOSE);
				newAccountPanel.setVisible(true);
				newAccountPanel.setResizable(false);

				myFrame.setVisible(false);
			}
		});

		LoginButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				if (checkIfFilled(loginTextField, passwordField) == false) {
					JOptionPane.showMessageDialog(myFrame, "Please fill all the fields!");
				}

				if (loginTextField.getText().equals("admin") && passwordField.getText().equals("admin")) {

					AdminPanel adminPanel = new AdminPanel(myFrame);
					adminPanel.setSize(705, 460);
					adminPanel.setDefaultCloseOperation(adminPanel.EXIT_ON_CLOSE);
					adminPanel.setVisible(true);
					adminPanel.setResizable(false);
					myFrame.setVisible(false);
				}

				if (Database.authorize(loginTextField.getText(), passwordField.getText())) {

					UserPanel userPanel = new UserPanel(myFrame, loginTextField.getText());
					userPanel.setSize(705, 460);
					userPanel.setDefaultCloseOperation(userPanel.EXIT_ON_CLOSE);
					userPanel.setVisible(true);
					userPanel.setResizable(false);
					myFrame.setVisible(false);

				}

			}
		});

	}

	private boolean checkIfFilled(JTextField tf1, JTextField tf2) {
		if (tf1.getText().isEmpty() || tf2.getText().isEmpty()) {
			return false;
		}
		return true;
	}

}
