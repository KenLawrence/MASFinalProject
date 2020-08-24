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

public class SetSpecialEventPanel extends JFrame{


	private JTextField specialShowDescriptionTextField;

	private JFrame thisFrame = this;
	
	public SetSpecialEventPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel setSpecialEventLabel = new JLabel("Set special event");
		setSpecialEventLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		setSpecialEventLabel.setBounds(10, 11, 251, 51);
		getContentPane().add(setSpecialEventLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(34, 366, 151, 51);
		getContentPane().add(backButton);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		descriptionLabel.setBounds(34, 73, 151, 38);
		getContentPane().add(descriptionLabel);
		
		specialShowDescriptionTextField = new JTextField();
		specialShowDescriptionTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		specialShowDescriptionTextField.setBounds(190, 73, 186, 38);
		getContentPane().add(specialShowDescriptionTextField);
		specialShowDescriptionTextField.setColumns(10);
		
		JButton OKButton = new JButton("OK");
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		OKButton.setBounds(230, 366, 151, 51);
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
