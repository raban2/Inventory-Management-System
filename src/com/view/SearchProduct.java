package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Bill;
import com.model.Cashier;
import com.model.Product;
import com.service.CashierService;
import com.service.CashierServiceImpl;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;


import java.awt.Font;

public class SearchProduct extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton_2;
	private JTextField searchtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchProduct frame = new SearchProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ProductId", "ProductName", "Available", "Mrp"}));
		contentPane.setLayout(null); // Use a layout manager instead of null layout

		// You need to add the table to a JScrollPane to make it scrollable
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(191, 182, 620, 261); // Adjust these values as needed
		contentPane.add(scrollPane);

		lblNewLabel = new JLabel("Search bill");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(403, 43, 137, 28);
		contentPane.add(lblNewLabel);

		btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int searchId = Integer.parseInt(searchtxt.getText());
				displaySearchedProduct(searchId);
				
				
				
				
			}
		});
		btnNewButton_2.setBackground(new Color(0, 255, 64));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(585, 120, 127, 30);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Product");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(255, 120, 82, 28);
		contentPane.add(lblNewLabel_1);
		
		searchtxt = new JTextField();
		searchtxt.setBounds(373, 120, 153, 30);
		contentPane.add(searchtxt);
		searchtxt.setColumns(10);
		
		JButton Back = new JButton("Back");
		Back.setBackground(new Color(255, 255, 128));
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new  Home().setVisible(true);
				dispose();
				
			}
		});
		Back.setBounds(908, 10, 66, 20);
		contentPane.add(Back);
	
		displayAllSearchedProduct();
	

	}
	private void displaySearchedProduct(int sid) {

		ProductService ps = new ProductServiceImpl();
		List<Product> plist = ps.searchProduct(sid);
		

		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);

		for (Product prod : plist) {

			tmodel.addRow(new Object[] { prod.getProductId(), prod.getProductName(), prod.getQuantity_available(), prod.getMrp()});

		}
	}
	
	
	private void displayAllSearchedProduct() {

		ProductService ps = new ProductServiceImpl();
		List<Product> plist = ps.getAllProducts();
		

		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);

		for (Product prod : plist) {

			tmodel.addRow(new Object[] { prod.getProductId(), prod.getProductName(), prod.getQuantity_available(), prod.getMrp()});

		}
	}

	
}
