package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminPanel extends JFrame{

	private JFrame myFrame = this;
	
	public AdminPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel addNewAlbumLabel = new JLabel("Admin");
		addNewAlbumLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		addNewAlbumLabel.setBounds(10, 11, 251, 51);
		getContentPane().add(addNewAlbumLabel);
		
		JLabel BandNameLabel = new JLabel("AB/CD");
		BandNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BandNameLabel.setBounds(607, 11, 80, 38);
		getContentPane().add(BandNameLabel);
		
		JButton addNewAlbumButton = new JButton("Add new album");
		addNewAlbumButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addNewAlbumButton.setBounds(34, 73, 227, 51);
		getContentPane().add(addNewAlbumButton);
		
		JButton addNewShopItemButton = new JButton("Add new shop item");
		addNewShopItemButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addNewShopItemButton.setBounds(34, 135, 227, 51);
		getContentPane().add(addNewShopItemButton);
		
		JButton setShowsButton = new JButton("Set shows");
		setShowsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setShowsButton.setBounds(34, 197, 227, 51);
		getContentPane().add(setShowsButton);
		
		JButton setBandInfoButton = new JButton("Set band information");
		setBandInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setBandInfoButton.setBounds(34, 259, 227, 51);
		getContentPane().add(setBandInfoButton);
		
		JButton signOutButton = new JButton("Sign out");
		signOutButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signOutButton.setBounds(34, 366, 151, 51);
		getContentPane().add(signOutButton);
		
		signOutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				myFrame.setVisible(false);
				LoginPanel.loginTextField.setText("");
				LoginPanel.passwordField.setText("");
				
			}
		});
		
		addNewAlbumButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AddNewAlbumPanel addNewAlbumPanel = new AddNewAlbumPanel(myFrame);
				addNewAlbumPanel.setSize(705, 460);
				addNewAlbumPanel.setDefaultCloseOperation(addNewAlbumPanel.EXIT_ON_CLOSE);
				addNewAlbumPanel.setVisible(true);
				addNewAlbumPanel.setResizable(false);
				
				myFrame.setVisible(false);
			}
		});
		
		addNewShopItemButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AddNewShopItemPanel addNewShopItemPanel = new AddNewShopItemPanel(myFrame);
				addNewShopItemPanel.setSize(705, 460);
				addNewShopItemPanel.setDefaultCloseOperation(addNewShopItemPanel.EXIT_ON_CLOSE);
				addNewShopItemPanel.setVisible(true);
				addNewShopItemPanel.setResizable(false);
				
				myFrame.setVisible(false);
				
			}
		});
		
		setShowsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SetShowPanel setShowPanel = new SetShowPanel(myFrame);
				setShowPanel.setSize(805, 460);
				setShowPanel.setDefaultCloseOperation(setShowPanel.EXIT_ON_CLOSE);
				setShowPanel.setVisible(true);
				setShowPanel.setResizable(false);
				
				myFrame.setVisible(false);
				
			}
		});
		
		
		setBandInfoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SetBandInformationPanel setBandInformationPanel = new SetBandInformationPanel(myFrame);
				setBandInformationPanel.setSize(705, 460);
				setBandInformationPanel.setDefaultCloseOperation(setBandInformationPanel.EXIT_ON_CLOSE);
				setBandInformationPanel.setVisible(true);
				setBandInformationPanel.setResizable(false);
				
				myFrame.setVisible(false);
			}
		});
		
	}
	
}
