package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class setFestivalPanel extends JFrame{
	private JTextField nameTextField;
	private JTextField sceneNameTextField;

	private JFrame thisFrame = this;
	
	public setFestivalPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel setFestivalLabel = new JLabel("Set festival");
		setFestivalLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		setFestivalLabel.setBounds(10, 11, 251, 51);
		getContentPane().add(setFestivalLabel);
		
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
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTextField.setBounds(185, 73, 237, 38);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		sceneNameTextField = new JTextField();
		sceneNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sceneNameTextField.setColumns(10);
		sceneNameTextField.setBounds(185, 136, 237, 38);
		getContentPane().add(sceneNameTextField);
		
		JLabel sceneNameLabel = new JLabel("Scene name");
		sceneNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sceneNameLabel.setBounds(34, 132, 151, 38);
		getContentPane().add(sceneNameLabel);
		
		JButton OKButton = new JButton("OK");
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		OKButton.setBounds(274, 366, 151, 51);
		getContentPane().add(OKButton);
		
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				thisFrame.setVisible(false);
				
			}
		});
		
	}
	
}
