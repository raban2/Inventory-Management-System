package com.service;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.database.ConnectionDb;
import com.model.Customer;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public void addCustomer(Customer customer) {
		 String query = "INSERT INTO CUSTOMER(customerName) VALUES('"+customer.getCustomer_name()+"')";
		try {
			Statement stm = ConnectionDb.getDbConnection().createStatement();
			stm.execute(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
