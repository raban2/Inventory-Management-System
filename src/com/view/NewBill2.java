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
import com.model.Customer;
import com.model.Product;
import com.service.CashierService;
import com.service.CashierServiceImpl;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Font;
import javax.swing.JComboBox;

public class NewBill2 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton Add;
	private JButton btnNewButton_1;
	private JTextField idtxt;
	private JTextField nametxt;
	private JTextField quantitytxt;
	private JLabel lblNewLabel_7;
	private JTextField datetxt;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField totaltxt;
	private JLabel lblNewLabel_10;
	private JTextField dtxt;
	private JTextField prodname;
	private JTextField prodmrp;
	private JComboBox<String> pId;
	
	List<Bill> blist = new ArrayList<Bill>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBill2 frame = new NewBill2();
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
	public NewBill2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Quantity", "Name", "Mrp", "Price" }));
		contentPane.setLayout(null); // Use a layout manager instead of null layout

		// You need to add the table to a JScrollPane to make it scrollable
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(369, 118, 620, 237); // Adjust these values as needed
		contentPane.add(scrollPane);

		lblNewLabel_1 = new JLabel("Bill No");
		lblNewLabel_1.setBounds(44, 108, 74, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Customer Name :");
		lblNewLabel_2.setBounds(44, 149, 114, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Product ID");
		lblNewLabel_3.setBounds(44, 190, 114, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setBounds(44, 222, 49, 14);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Mrp");
		lblNewLabel_5.setBounds(44, 257, 49, 14);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Discount");
		lblNewLabel_6.setBounds(44, 327, 89, 28);
		contentPane.add(lblNewLabel_6);

		// Product Name
		ProductService ps = new ProductServiceImpl();
		List<Product> plist = ps.getAllProducts();

		// Loop
		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>();
		List<Product> plists = new ArrayList<Product>();
		for (Product p : plist) {
			String proId =   Integer.toString(p.getProductId());
			model1.addElement(proId);

		}

		// For ID
		 pId = new JComboBox();
		pId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                @SuppressWarnings("unchecked")
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selectedProductId = (String) combo.getSelectedItem().toString();
                System.out.println(selectedProductId);

                // Retrieve the product details based on the selected product ID
                ProductService ps = new ProductServiceImpl();
                Product selectedProduct = ps.getProductById(Integer.parseInt(selectedProductId));

             // If the selected product is not null, set its name and MRP in the text fields
                if (selectedProduct != null) {
                	prodname.setText(selectedProduct.getProductName());
                    prodmrp.setText(String.valueOf(selectedProduct.getMrp()));
                } else {
                    // Handle the case when no product is found with the selected ID
                    // For example, you can clear the name and MRP fields
                	prodname.setText(null);
                    prodmrp.setText(null);
                }
            }
        });
		model1.setSelectedItem("Select");
		pId.setModel(model1);
		pId.setBounds(186, 187, 96, 21);
		contentPane.add(pId);
		if(pId.getSelectedItem() != null) {
		
	
		
		
		// Name Of Product
		prodname = new JTextField();
		prodname.setBounds(186, 219, 96, 21);
		contentPane.add(prodname);

		// For Mrp
		 prodmrp = new JTextField();
		 prodmrp.setBounds(186, 254, 96, 21);
		contentPane.add(prodmrp);
		
		}
		 

		Add = new JButton("Add");
		Add.setBackground(Color.BLUE);
		Add.setFont(new Font("Tahoma", Font.BOLD, 10));
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int amount =0;
				
				int billid = Integer.parseInt(idtxt.getText());
				String cname = nametxt.getText();
				int prodId = Integer.parseInt(pId.getSelectedItem().toString());
				String pname = prodname.getText();
				int mrp = Integer.parseInt(prodmrp.getText());
				int quantity = Integer.parseInt(quantitytxt.getText());
				int discount = Integer.parseInt(dtxt.getText());
				String pdate = datetxt.getText();

				 if(discount != 0 || quantity >1) {
					 
					 amount  = (mrp *quantity)-discount;
 
				 }
				 		
				try {
					
					// Create Customer
					Customer customer = new Customer();
					customer.setCustomer_name(cname);

					CustomerService cs = new CustomerServiceImpl();
					cs.addCustomer(customer);

					// Create Product
					Product p = new Product();
					p.setProductId(prodId);
					p.setMrp(mrp);
					p.setProductName(pname);

					// Create Bill
					Bill bill = new Bill();
					bill.setBillNo(billid);
					bill.setProduct(p);
					bill.setCustomer(customer);
					bill.setPurchaseDate(pdate);
					bill.setPurchQuantity(quantity);
					bill.setDiscount(discount);
					bill.setAmount(amount);
				      
					
					//Adding bill object into the List
					blist.add(bill);
					
					
				
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numeric values.");
				} 
				
				//for calculating the total amount of the product
				int totalAmount = 0;
		        for (Bill bill : blist) {
		            totalAmount += bill.getAmount();
		        }

		        // Set the total amount in the totaltxt field
		        totaltxt.setText(Integer.toString(totalAmount));
				 displayBill();
			   
			}
			
		});
		Add.setBackground(new Color(15, 20, 1));
		Add.setForeground(new Color(255, 255, 255));
		Add.setBounds(44, 387, 89, 23);
		contentPane.add(Add);

		btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(158, 387, 89, 23);
		contentPane.add(btnNewButton_1);

		idtxt = new JTextField();
		idtxt.setBounds(186, 106, 96, 20);
		contentPane.add(idtxt);
		idtxt.setColumns(5);

		nametxt = new JTextField();
		nametxt.setBounds(186, 147, 96, 20);
		contentPane.add(nametxt);
		nametxt.setColumns(10);

		quantitytxt = new JTextField();
		quantitytxt.setBounds(186, 295, 96, 20);
		contentPane.add(quantitytxt);
		quantitytxt.setColumns(10);

		lblNewLabel_7 = new JLabel("Date");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(724, 67, 66, 23);
		contentPane.add(lblNewLabel_7);

		datetxt = new JTextField();
		datetxt.setBounds(800, 57, 209, 28);
		contentPane.add(datetxt);
		datetxt.setColumns(10);

		lblNewLabel_8 = new JLabel("Grand Total");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(710, 356, 109, 23);
		contentPane.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("Print");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(923, 428, 66, 23);
		contentPane.add(lblNewLabel_9);

		totaltxt = new JTextField();
		totaltxt.setColumns(10);
		totaltxt.setBounds(843, 351, 146, 28);
		contentPane.add(totaltxt);

		lblNewLabel_10 = new JLabel("Quantity");
		lblNewLabel_10.setBounds(44, 297, 49, 14);
		contentPane.add(lblNewLabel_10);

		dtxt = new JTextField();
		dtxt.setColumns(10);
		dtxt.setBounds(186, 332, 96, 20);
		contentPane.add(dtxt);
		
		JButton Back = new JButton("Back");
		Back.setBackground(new Color(255, 255, 128));
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new  Home().setVisible(true);
				dispose();
				
			}
		});
		Back.setBounds(973, 10, 66, 20);
		contentPane.add(Back);
		
		

		// Calling display methods
		 displayBill();
	}

	private void displayBill() {

		
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		CashierService cs = new CashierServiceImpl();
		List<Bill> bList = blist;
	
		tmodel.setRowCount(0);

		for (Bill b : blist) {
			// Quantity", "Name", "Mrp", "Price"
			tmodel.addRow(new Object[] { b.getPurchQuantity(), b.getProduct().getProductName(), b.getProduct().getMrp(),
					b.getAmount() });
			
		   

		}
		
	}
}
