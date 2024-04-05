package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Cashier;
import com.service.CashierService;
import com.service.CashierServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.List;
import java.awt.Font;

public class Table extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton addButton;
	private JButton deleteButton;
	private JButton updateButton;
	private JTextField idtxt;
	private JTextField nametxt;
	private JTextField mobiletxt;
	private JTextField addresstxt;
	private JTextField emailtxt;
	private JTextField passwordtxt;
	private JButton saveButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table();
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
	public Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Mn0", "Address", "Email", "Password" }));
		contentPane.setLayout(null); // Use a layout manager instead of null layout

		// You need to add the table to a JScrollPane to make it scrollable
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(419, 32, 620, 306); // Adjust these values as needed
		contentPane.add(scrollPane);

		lblNewLabel = new JLabel("Add Cashier Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(160, 39, 274, 28);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Cashier Id :");
		lblNewLabel_1.setBounds(44, 108, 74, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Cashier Name :");
		lblNewLabel_2.setBounds(44, 150, 96, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Mobile Number:");
		lblNewLabel_3.setBounds(44, 191, 114, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(44, 232, 49, 14);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Email-Id");
		lblNewLabel_5.setBounds(44, 269, 49, 14);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setBounds(44, 310, 89, 28);
		contentPane.add(lblNewLabel_6);

		addButton = new JButton("Add New");
		addButton.setBackground(Color.BLUE);
		addButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(idtxt.getText());
				String name = nametxt.getText();
				String mobile = mobiletxt.getText();
				String address = addresstxt.getText();
				String email = emailtxt.getText();
				String pass = passwordtxt.getText();

				Cashier cashier = new Cashier();
				cashier.setCashierId(id);
				cashier.setcName(name);
				cashier.setMobileNumber(mobile);
				cashier.setAddress(address);
				cashier.setEmailId(email);
				cashier.setPassword(pass);

				CashierService cs = new CashierServiceImpl();
				cs.addCashier(cashier);
				JOptionPane.showMessageDialog(null, "Cashier Added Successfully");
				display();
			}
		});
		addButton.setBackground(new Color(15, 20, 1));
		addButton.setForeground(new Color(255, 255, 255));
		addButton.setBounds(44, 387, 89, 23);
		contentPane.add(addButton);

		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CashierService cs = new CashierServiceImpl();
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {

					int cashierId = (int) table.getValueAt(selectedRow, 0); // Assuming ID is in the first column

					int count = cs.deleteCashier(cashierId);
					display();

					System.out.println("count " + count);
					if (count > 0) {
						JOptionPane.showMessageDialog(null, "Cashier Deleted Successfully");
					} else {
						JOptionPane.showMessageDialog(null, " Failed to Deleted Cashier!!");
					}

				}

			}

		});
		deleteButton.setBackground(new Color(255, 0, 0));
		deleteButton.setForeground(new Color(255, 255, 255));
		deleteButton.setBounds(158, 387, 89, 23);
		contentPane.add(deleteButton);

		updateButton = new JButton("Update");
		updateButton.setVisible(true);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int id = (int) table.getValueAt(selectedRow, 0);
					String name = (String) table.getValueAt(selectedRow, 1);
					String mobileNo = (String) table.getValueAt(selectedRow, 2);
					String address = (String) table.getValueAt(selectedRow, 3);
					String email = (String) table.getValueAt(selectedRow, 4);
					String password = (String) table.getValueAt(selectedRow, 5);

					// setting this value into the form
					idtxt.setText(String.valueOf(id));
					nametxt.setText(name);
					mobiletxt.setText(mobileNo);
					addresstxt.setText(address);
					emailtxt.setText(email);
					passwordtxt.setText(password);

					updateButton.setVisible(false);
					saveButton.setVisible(true);

				}
			}
		});
		
		updateButton.setBackground(new Color(0, 255, 64));
		updateButton.setForeground(new Color(255, 255, 255));
		updateButton.setBounds(277, 387, 89, 23);
		contentPane.add(updateButton);

		// SAVE BUTTON
		saveButton = new JButton("Save");
		saveButton.setVisible(false);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Retrieve modified data from the text fields
				int id = Integer.parseInt(idtxt.getText());
				String name = nametxt.getText();
				String mobile = mobiletxt.getText();
				String address = addresstxt.getText();
				String email = emailtxt.getText();
				String password = passwordtxt.getText();

				Cashier c = new Cashier();
				c.setCashierId(id);
				c.setcName(name);
				c.setMobileNumber(mobile);
				c.setAddress(address);
				c.setEmailId(email);
				c.setPassword(password);

				CashierService cs = new CashierServiceImpl();
				if (cs.updateCashier(c) > 0) {
					
					display(); // refresh the table
					
					//clear the textfields
					idtxt.setText(null);
					nametxt.setText(null);
					mobiletxt.setText(null);
					addresstxt.setText(null);
					emailtxt.setText(null);
					passwordtxt.setText(null);
                    
					//Visible the button
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
		saveButton.setBounds(277, 387, 89, 23);
		contentPane.add(saveButton);

		

		idtxt = new JTextField();
		idtxt.setBounds(186, 105, 96, 20);
		contentPane.add(idtxt);
		idtxt.setColumns(5);

		nametxt = new JTextField();
		nametxt.setBounds(186, 147, 96, 20);
		contentPane.add(nametxt);
		nametxt.setColumns(10);

		mobiletxt = new JTextField();
		mobiletxt.setBounds(186, 188, 96, 20);
		contentPane.add(mobiletxt);
		mobiletxt.setColumns(10);

		addresstxt = new JTextField();
		addresstxt.setBounds(186, 229, 96, 20);
		contentPane.add(addresstxt);
		addresstxt.setColumns(10);

		emailtxt = new JTextField();
		emailtxt.setBounds(186, 266, 96, 20);
		contentPane.add(emailtxt);
		emailtxt.setColumns(10);

		passwordtxt = new JTextField();
		passwordtxt.setBounds(186, 314, 96, 20);
		contentPane.add(passwordtxt);
		passwordtxt.setColumns(10);

		// Calling display methods
		display();
	}

	// Method to display the table
	private void display() {

		CashierService rs = new CashierServiceImpl();
		List<Cashier> clist = rs.getAllCashier();
		int length = clist.size();
		System.out.println(length);

		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);

		for (Cashier c : clist) {

			tmodel.addRow(new Object[] { c.getCashierId(), c.getcName(), c.getMobileNumber(), c.getAddress(),
					c.getEmailId(), c.getPassword() });

		}
	}

}
