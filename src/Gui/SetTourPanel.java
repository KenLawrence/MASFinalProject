package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class SetTourPanel extends JFrame{

	private JTextField nameTextField;
	private JTextField startDateTextField;
	private JTextField lengthTextField;
	private JTextField finishDateTextField;
	private JTextField songsNumberTextField;
	private JTextField tourNameTextField;
	private JTextField descriptionTextField;
	private JTextField otherBandsTextField;
	private JTextField producerTextField;
	private JTextField showNumberTextField;
	
	private JFrame thisFrame = this;
	
	public SetTourPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel setTourLabel = new JLabel("Set tour");
		setTourLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		setTourLabel.setBounds(10, 11, 251, 51);
		getContentPane().add(setTourLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(34, 366, 151, 51);
		getContentPane().add(backButton);
		
		JLabel startDateLabel = new JLabel("Start date");
		startDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startDateLabel.setBounds(34, 73, 151, 38);
		getContentPane().add(startDateLabel);
		
		JLabel finishDateLabel = new JLabel("Finish date");
		finishDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		finishDateLabel.setBounds(34, 122, 151, 38);
		getContentPane().add(finishDateLabel);
		
		JLabel tourNameLabel = new JLabel("Tour name");
		tourNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tourNameLabel.setBounds(34, 171, 151, 38);
		getContentPane().add(tourNameLabel);
		
		JLabel otherBandsLabel = new JLabel("Other bands");
		otherBandsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		otherBandsLabel.setBounds(34, 220, 151, 38);
		getContentPane().add(otherBandsLabel);
		
		JLabel showNumberLabel = new JLabel("Show number");
		showNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		showNumberLabel.setBounds(34, 269, 151, 38);
		getContentPane().add(showNumberLabel);
		
		startDateTextField = new JTextField();
		startDateTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		startDateTextField.setBounds(190, 73, 186, 38);
		getContentPane().add(startDateTextField);
		startDateTextField.setColumns(10);
		
		finishDateTextField = new JTextField();
		finishDateTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		finishDateTextField.setColumns(10);
		finishDateTextField.setBounds(190, 122, 186, 38);
		getContentPane().add(finishDateTextField);
		
		tourNameTextField = new JTextField();
		tourNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tourNameTextField.setColumns(10);
		tourNameTextField.setBounds(190, 171, 186, 38);
		getContentPane().add(tourNameTextField);
		
		otherBandsTextField = new JTextField();
		otherBandsTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		otherBandsTextField.setColumns(10);
		otherBandsTextField.setBounds(190, 220, 186, 38);
		getContentPane().add(otherBandsTextField);
		
		showNumberTextField = new JTextField();
		showNumberTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		showNumberTextField.setColumns(10);
		showNumberTextField.setBounds(190, 269, 186, 38);
		getContentPane().add(showNumberTextField);
		
		JLabel headlinerLabel = new JLabel("Headliner?");
		headlinerLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		headlinerLabel.setBounds(34, 317, 151, 38);
		getContentPane().add(headlinerLabel);
		
		JRadioButton yesRadioButton = new JRadioButton("Yes");
		yesRadioButton.setBounds(190, 321, 71, 38);
		getContentPane().add(yesRadioButton);
		
		JRadioButton noRadioButton = new JRadioButton("No");
		noRadioButton.setBounds(305, 321, 71, 38);
		getContentPane().add(noRadioButton);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(true);
				thisFrame.setVisible(false);
				
				
			}
		});
	}
}
