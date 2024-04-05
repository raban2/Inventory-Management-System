package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import java.util.List;
import java.awt.Font;
import java.awt.Window;

public class Stock extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel productid;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton New;
	private JButton updateButton;
	private JTextField pidtxt;
	private JTextField name1;
	private JTextField quantity1;
	private JTextField addedtxt;
	private JTextField mrp1;
	private JButton saveButton ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
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
	public Stock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ProductID", "ProductName", "Available", "Mrp" }));
		contentPane.setLayout(null); // Use a layout manager instead of null layout

		// You need to add the table to a JScrollPane to make it scrollable
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(419, 32, 620, 306); // Adjust these values as needed
		contentPane.add(scrollPane);

		lblNewLabel = new JLabel("Update Stock");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(160, 39, 274, 28);
		contentPane.add(lblNewLabel);

		productid = new JLabel("Product Id :");
		productid.setBounds(44, 108, 74, 14);
		contentPane.add(productid);

		lblNewLabel_2 = new JLabel("Product Name :");
		lblNewLabel_2.setBounds(44, 150, 96, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Quantity Available");
		lblNewLabel_3.setBounds(44, 191, 114, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Quantity Added");
		lblNewLabel_4.setBounds(44, 232, 89, 14);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Mrp");
		lblNewLabel_5.setBounds(44, 269, 49, 14);
		contentPane.add(lblNewLabel_5);

		New = new JButton("Add New");
		New.setBackground(Color.BLUE);
		New.setFont(new Font("Tahoma", Font.BOLD, 10));
		New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddProduct window = new AddProduct();
				window.getFrame().setVisible(true);
				dispose();

			}
		});
		New.setBackground(new Color(15, 20, 1));
		New.setForeground(new Color(255, 255, 255));
		New.setBounds(69, 357, 89, 23);
		contentPane.add(New);

		updateButton = new JButton("Update");
		updateButton.setVisible(true);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int id = (int) table.getValueAt(selectedRow, 0);
					String name = (String) table.getValueAt(selectedRow, 1);
					int available = (int) table.getValueAt(selectedRow, 2);
					int mrp  = (int) table.getValueAt(selectedRow, 3);
					

					// setting this value into the form
					pidtxt.setText(String.valueOf(id));
					name1.setText(name);
					quantity1.setText(String.valueOf(available));  //converting the int into string and setting into the textfild
					addedtxt.setText(String.valueOf(0));
					mrp1.setText(String.valueOf(mrp));
					
				
				    try {
						int quantAdded = Integer.parseInt(addedtxt.getText());
							int quantity = available+ quantAdded;
							System.out.println("Quantity" +quantity);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				    updateButton.setVisible(false);
				    saveButton.setVisible(true);
					
					
					
					
					

				}
			}
		});

		updateButton.setBackground(new Color(0, 255, 64));
		updateButton.setForeground(new Color(255, 255, 255));
		updateButton.setBounds(193, 357, 89, 23);
		contentPane.add(updateButton);
		
		saveButton = new JButton("Save");
		saveButton.setVisible(false);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Retrieve modified data from the text fields
				int id = Integer.parseInt(pidtxt.getText());
				String name = name1.getText();
				int qunatity = Integer.parseInt(quantity1.getText());
				int addp = Integer.parseInt(addedtxt.getText());
				int mrp = Integer.parseInt(mrp1.getText());
				
				
				//Login to add Product Quantity
				int totalProduct = qunatity+addp;
				System.out.println("Total" +totalProduct);
				
				
                //Creating Product
				Product c = new Product();
				
				//Setting properties of Object
				Product prod = new Product();
				prod.setProductId(id);
				prod.setProductName(name);
				prod.setQuantity_available(totalProduct);
				prod.setMrp(mrp);
				
				//Creating object of ProductServiceIml to call updateProduct() method by passing the object of Product
				ProductService ps = new ProductServiceImpl();
				if (ps.updateProduct(prod) > 0) {
					display(); // refresh the table
					//clear the textfields if updation Complete
					pidtxt.setText(null);
					name1.setText(null);
					quantity1.setText(null);
					addedtxt.setText(null);
					mrp1.setText(null);
					
                    
					//Visible update button if saved Success
					saveButton.setVisible(false);
					updateButton.setVisible(true);
					JOptionPane.showMessageDialog(null, "Updated Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Failed to Update!!!");
				} 
			}  

		});
		saveButton.setBackground(new Color(0, 255, 64));
		saveButton.setForeground(new Color(255, 255, 255));
		saveButton.setBounds(193, 357, 89, 23);
		contentPane.add(saveButton);

		pidtxt = new JTextField();
		pidtxt.setBounds(186, 105, 96, 20);
		contentPane.add(pidtxt);
		pidtxt.setColumns(5);

		name1 = new JTextField();
		name1.setBounds(186, 147, 96, 20);
		contentPane.add(name1);
		name1.setColumns(10);

		quantity1 = new JTextField();
		quantity1.setBounds(186, 188, 96, 20);
		contentPane.add(quantity1);
		quantity1.setColumns(10);

		addedtxt = new JTextField();
		addedtxt.setBounds(186, 229, 96, 20);
		contentPane.add(addedtxt);
		addedtxt.setColumns(10);

		mrp1 = new JTextField();
		mrp1.setBounds(186, 266, 96, 20);
		contentPane.add(mrp1);
		mrp1.setColumns(10);

		// Calling display methods
		display();
	}

	// Method to display the table
	private void display() {

		ProductService ps = new ProductServiceImpl();
		List<Product> plist = ps.getAllProducts();

		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);

		for (Product prod : plist) {

			tmodel.addRow(new Object[] { prod.getProductId(), prod.getProductName(), prod.getQuantity_available(),
					prod.getMrp() });

		}
	}

}
