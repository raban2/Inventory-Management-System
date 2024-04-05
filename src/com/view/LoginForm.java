package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.service.CashierService;
import com.service.CashierServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user2;
	private JTextField pass2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public String toString() {
		return "LoginForm [contentPane=" + contentPane + ", user2=" + user2 + ", pass2=" + pass2 + "]";
	}

	/**
	 * Create the frame.
	 */

	public LoginForm() {
		setTitle("Login Form");
		setBackground(new Color(255, 128, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(41, 67, 86));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel userlogin = new JLabel("Username:");
		userlogin.setForeground(Color.white);
		userlogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userlogin.setBounds(75, 64, 102, 13);
		contentPane.add(userlogin);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.white);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(75, 93, 69, 13);
		contentPane.add(lblPassword);

		user2 = new JTextField();
		user2.setBounds(175, 63, 179, 19);
		contentPane.add(user2);
		user2.setColumns(10);

		pass2 = new JTextField();
		pass2.setColumns(10);
		pass2.setBounds(175, 92, 179, 19);
		contentPane.add(pass2);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DashBoard().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(174, 139, 85, 21);
		contentPane.add(btnNewButton);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {

				String username= user2.getText();
				String userpass = pass2.getText();
			
				CashierService cs = new CashierServiceImpl();
				if(cs.Login(username, userpass)) {
					new Home().setVisible(true);
					dispose();
					 JOptionPane.showMessageDialog(null, "Login Success");
					
				}else {
					 JOptionPane.showMessageDialog(null, "Wrong Credentials");
				}
			}
		});
		btnLogin.setBackground(new Color(41, 169, 237));
		btnLogin.setBounds(269, 139, 85, 21);
		contentPane.add(btnLogin);

		JLabel lblNewLabel = new JLabel("click here to create a new account");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RegisterForm().setVisible(true); 
				dispose();
			}
		});
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBounds(132, 190, 222, 13);
		contentPane.add(lblNewLabel);
	}

}
