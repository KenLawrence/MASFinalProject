package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mas.Ticket;

public class TicketDetailsPanel extends JFrame{

	public JTextField vipPriceTextField;
	public JTextField eeTextField;
	private JTextField songsNumberTextField;
	public JTextField regularPriceTextField;
	private JTextField descriptionTextField;
	private JTextField producerTextField;
	public static String vipPrice;
	public static String eePrice;
	public static String regularPrice;
	
	private JFrame thisFrame = this;
	
	public TicketDetailsPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel ticketDetailsLabel = new JLabel("Ticket details");
		ticketDetailsLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ticketDetailsLabel.setBounds(10, 11, 251, 51);
		getContentPane().add(ticketDetailsLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(34, 362, 151, 51);
		getContentPane().add(backButton);
		
		JLabel VIPPriceLabel = new JLabel("VIP price");
		VIPPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		VIPPriceLabel.setBounds(34, 73, 151, 38);
		getContentPane().add(VIPPriceLabel);
		
		JLabel eeLabel = new JLabel("E.E. price");
		eeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eeLabel.setBounds(34, 122, 151, 38);
		getContentPane().add(eeLabel);
		
		JLabel regularPriceLabel = new JLabel("Regular Price");
		regularPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regularPriceLabel.setBounds(34, 171, 151, 38);
		getContentPane().add(regularPriceLabel);
		
		vipPriceTextField = new JTextField();
		vipPriceTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		vipPriceTextField.setBounds(190, 73, 186, 38);
		getContentPane().add(vipPriceTextField);
		vipPriceTextField.setColumns(10);
		
		eeTextField = new JTextField();
		eeTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eeTextField.setColumns(10);
		eeTextField.setBounds(190, 122, 186, 38);
		getContentPane().add(eeTextField);
		
		regularPriceTextField = new JTextField();
		regularPriceTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		regularPriceTextField.setColumns(10);
		regularPriceTextField.setBounds(190, 171, 186, 38);
		getContentPane().add(regularPriceTextField);
		
		JButton OKButton = new JButton("OK");
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		OKButton.setBounds(225, 362, 151, 51);
		getContentPane().add(OKButton);
		
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
				vipPrice = vipPriceTextField.getText();
				eePrice = eeTextField.getText();
				regularPrice = regularPriceTextField.getText();
				
				//Ticket ticket = new Ticket(price, buyingDate, type, isAvaiable, show)
				
			}
		});
	}
	
}
