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
import mas.ShopItem;
import javax.swing.JSlider;

public class AddNewShopItemPanel extends JFrame{
	private JTextField nameTextField;
	private JTextField weightTextField;
	private JTextField priceTextField;
	private JTextField limitedEditionTextField;
	private JTextField descriptionTextField;

	private JFrame thisFrame = this;
	
	public AddNewShopItemPanel(JFrame frame) {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(null);
		
		JLabel addNewShopItemLabel = new JLabel("Add new shop item");
		addNewShopItemLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		addNewShopItemLabel.setBounds(10, 11, 251, 51);
		getContentPane().add(addNewShopItemLabel);
		
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
		
		JLabel weightLabel = new JLabel("Weight");
		weightLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		weightLabel.setBounds(34, 122, 151, 38);
		getContentPane().add(weightLabel);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		priceLabel.setBounds(34, 171, 151, 38);
		getContentPane().add(priceLabel);
		
		JLabel limitedEditionLabel = new JLabel("Limited edition ?");
		limitedEditionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		limitedEditionLabel.setBounds(34, 220, 151, 38);
		getContentPane().add(limitedEditionLabel);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		descriptionLabel.setBounds(34, 269, 151, 38);
		getContentPane().add(descriptionLabel);
		
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTextField.setBounds(196, 73, 194, 38);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		weightTextField = new JTextField();
		weightTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		weightTextField.setColumns(10);
		weightTextField.setBounds(195, 122, 194, 38);
		getContentPane().add(weightTextField);
		
		priceTextField = new JTextField();
		priceTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		priceTextField.setColumns(10);
		priceTextField.setBounds(195, 171, 194, 38);
		getContentPane().add(priceTextField);
		
		limitedEditionTextField = new JTextField();
		limitedEditionTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		limitedEditionTextField.setColumns(10);
		limitedEditionTextField.setBounds(196, 220, 194, 38);
		getContentPane().add(limitedEditionTextField);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		descriptionTextField.setColumns(10);
		descriptionTextField.setBounds(195, 269, 194, 38);
		getContentPane().add(descriptionTextField);
		
		JButton addButton = new JButton("Add new item");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addButton.setBounds(219, 366, 171, 51);
		getContentPane().add(addButton);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(true);
				thisFrame.setVisible(false);
			}
		});
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = nameTextField.getText();
				Double weight = Double.parseDouble(weightTextField.getText());
				Double price = Double.parseDouble(priceTextField.getText());
				boolean limitedEdition = Boolean.parseBoolean(limitedEditionTextField.getText());
				String description = descriptionTextField.getText();
				
				ShopItem shopItem = new ShopItem(name, weight, price, limitedEdition, description);
				
				ShopItem.addNewShopItem(shopItem);
				
			}
		});
	}
}
