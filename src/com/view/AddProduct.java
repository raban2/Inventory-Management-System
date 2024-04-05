package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProduct {

	private JFrame frame;
	private JTextField name1;
	private JTextField quantity1;
	private JTextField mrp1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct window = new AddProduct();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1063, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Add New Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(418, 40, 209, 29);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(287, 113, 130, 21);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(287, 157, 130, 21);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Mrp");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(287, 204, 130, 21);
		frame.getContentPane().add(lblNewLabel_1_2);

		name1 = new JTextField();
		name1.setBounds(484, 115, 143, 23);
		frame.getContentPane().add(name1);
		name1.setColumns(10);

		quantity1 = new JTextField();
		quantity1.setColumns(10);
		quantity1.setBounds(484, 159, 143, 23);
		frame.getContentPane().add(quantity1);

		mrp1 = new JTextField();
		mrp1.setColumns(10);
		mrp1.setBounds(484, 206, 143, 23);
		frame.getContentPane().add(mrp1);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Captuing fields from the form
				String pname = name1.getText();
				int quantity = Integer.parseInt(quantity1.getText());
				int mrp = Integer.parseInt(mrp1.getText());

				// setting into object to insert the product
				Product prod = new Product();
				prod.setProductName(pname);
				prod.setQuantity_available(quantity);
				prod.setMrp(mrp);

				// CREATING OBJECT OF PRODUCT AND CALLING addProduct() Method
				ProductService ps = new ProductServiceImpl();
				if (ps.addProduct(prod) > 0) {
					JOptionPane.showMessageDialog(null, "New Product Added!");
				}else {
					JOptionPane.showMessageDialog(null, "Failed to add Product!");
				}
			}
		});
		btnNewButton.setBounds(472, 295, 85, 21);
		frame.getContentPane().add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				name1.setText(null);
				quantity1.setText(null);
				mrp1.setText(null);
			}
		});
		btnClear.setBounds(343, 295, 85, 21);
		frame.getContentPane().add(btnClear);
	}
	
	public JFrame getFrame() {
		return frame;
	}

}
