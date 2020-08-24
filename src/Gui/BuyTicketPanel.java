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

public class BuyTicketPanel extends JFrame{

	private JTextField nameTextField;
	private JTextField lengthTextField;
	private JTextField songsNumberTextField;
	private JTextField descriptionTextField;
	private JTextField producerTextField;
	
	private JFrame myFrame = this;
	
	public BuyTicketPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel buyTicketLabel = new JLabel("Buy ticket");
		buyTicketLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		buyTicketLabel.setBounds(10, 5, 251, 51);
		getContentPane().add(buyTicketLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(34, 366, 151, 51);
		getContentPane().add(backButton);
		
		JButton buyButton = new JButton("Buy");
		buyButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buyButton.setBounds(505, 366, 151, 51);
		getContentPane().add(buyButton);
		
		JList list = new JList();
		list.setBounds(10, 67, 671, 289);
		getContentPane().add(list);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				myFrame.setVisible(false);
				
			}
		});
		
	}
	
}
