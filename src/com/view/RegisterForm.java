package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




import com.model.Employee;
import com.service.CashierService;
import com.service.CashierServiceImpl;

public class RegisterForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fname1;
	private JTextField lname1;
	private JTextField username1;
	private JTextField password2;
	private JTextField dob1;
	private JTextField address1;
	private JTextField password1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
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
	public RegisterForm() {
		setType(Type.POPUP);
		setFont(new Font("Agency FB", Font.BOLD, 27));
		setTitle("Register Form");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(55, 69, 118, 13);
		contentPane.add(lblNewLabel);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(55, 110, 118, 13);
		contentPane.add(lblLastName);

		fname1 = new JTextField();
		fname1.setBounds(200, 66, 192, 19);
		contentPane.add(fname1);
		fname1.setColumns(10);

		lname1 = new JTextField();
		lname1.setColumns(10);
		lname1.setBounds(200, 109, 192, 19);
		contentPane.add(lname1);

		username1 = new JTextField();
		username1.setColumns(10);
		username1.setBounds(200, 145, 192, 19);
		contentPane.add(username1);

		password2 = new JTextField();
		password2.setColumns(10);
		password2.setBounds(200, 229, 192, 19);
		contentPane.add(password2);

		dob1 = new JTextField();
		dob1.setColumns(10);
		dob1.setBounds(200, 273, 192, 19);
		contentPane.add(dob1);

		address1 = new JTextField();
		address1.setColumns(10);
		address1.setBounds(200, 316, 192, 51);
		contentPane.add(address1);

		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(55, 185, 118, 13);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Username:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(55, 146, 118, 13);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Retype Pass:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(55, 224, 118, 24);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("BirthDate");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(55, 274, 118, 13);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_4_1 = new JLabel("Address:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4_1.setBounds(55, 317, 118, 13);
		contentPane.add(lblNewLabel_1_4_1);

		password1 = new JTextField();
		password1.setColumns(10);
		password1.setBounds(200, 184, 192, 19);
		contentPane.add(password1);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DashBoard().setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(135, 405, 85, 21);
		contentPane.add(btnCancel);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Capturing values from the form
				String fname = fname1.getText();
				String lname = lname1.getText();
				String username = username1.getText();
				String password3 = password1.getText();
				String retypepass = password2.getText();
				String stringdate = dob1.getText();
				String address = address1.getText();

				// validation
				if (!fname.isEmpty() && !lname.isEmpty() && !username.isEmpty() && !password3.isEmpty()
						&& !stringdate.isEmpty() && !address.isEmpty()) {
					
					Employee emp = new Employee();
					emp.setFname(fname);
					emp.setLname(lname);
					emp.setUsername(username);
					if (password3.equals(retypepass)) {
						emp.setPassword(password3);
					} else {
						password2.setText("Not Matched!!");
					}
					emp.setDob(stringdate);
					emp.setAddress(address);

					CashierService es = new CashierServiceImpl();
					//es.addEmployee(emp);
					JOptionPane.showMessageDialog(null, "New Employee Registed!!!");

				} else {
					JOptionPane.showMessageDialog(null, "Please Fill  the form!!!");
				}
			}
		});
		
		btnRegister.setBackground(new Color(23, 201, 232));
		btnRegister.setBounds(262, 405, 85, 21);
		contentPane.add(btnRegister);

		JLabel lblNewLabel_1 = new JLabel("click here to login");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginForm().setVisible(true);
				dispose();

			}
		});
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(200, 450, 147, 19);
		contentPane.add(lblNewLabel_1);
	}
}
