package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
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
	public AdminDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 0));
		frame.setBounds(100, 100, 1221, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Dashboard");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBackground(new Color(64, 128, 128));
		lblNewLabel.setBounds(35, 62, 112, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnStock = new JButton("Stock");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Stock().setVisible(true);
			}
		});
		btnStock.setBounds(35, 156, 101, 21);
		frame.getContentPane().add(btnStock);
		
		JButton btnNewButton = new JButton("Cashier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Table().setVisible(true);
			    
			}
		});
		btnNewButton.setForeground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setBounds(35, 125, 101, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCustomer = new JButton("Seach Bill");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Search().setVisible(true);
			}
		});
		btnCustomer.setBounds(35, 187, 101, 21);
		frame.getContentPane().add(btnCustomer);
		
		JButton btnSales = new JButton("Sales");
		btnSales.setBounds(35, 234, 101, 21);
		frame.getContentPane().add(btnSales);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(35, 278, 101, 21);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(35, 320, 101, 21);
		frame.getContentPane().add(button_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setForeground(new Color(255, 255, 128));
		panel.setBounds(186, 0, 1033, 618);
		frame.getContentPane().add(panel);
	}
}
