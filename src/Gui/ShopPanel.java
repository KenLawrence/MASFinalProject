package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import functionality.Database;

import javax.swing.JList;

public class ShopPanel extends JFrame{

	private JTextField nameTextField;
	private JTextField lengthTextField;
	private JTextField songsNumberTextField;
	private JTextField descriptionTextField;
	private JTextField producerTextField;
	
	private JFrame myFrame = this;
	
	public ShopPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel shopLabel = new JLabel("Shop");
		shopLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		shopLabel.setBounds(10, 11, 251, 51);
		getContentPane().add(shopLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(34, 366, 151, 51);
		getContentPane().add(backButton);
		
		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addButton.setBounds(505, 366, 151, 51);
		getContentPane().add(addButton);
		
		DefaultListModel listModel;
		listModel = new DefaultListModel();
		JList list = new JList(listModel);
		Database.addToItemList(listModel);
		Database.addAlbumItemList(listModel);
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
