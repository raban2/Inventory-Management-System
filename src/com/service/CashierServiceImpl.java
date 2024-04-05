package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.database.ConnectionDb;
import com.model.Bill;
import com.model.Cashier;
import com.model.Customer;
import com.model.Product;
import com.view.NewBill;

public class CashierServiceImpl implements CashierService {
	PreparedStatement ps = null;
	ResultSet rs = null;

	// ADD METHODS
	@Override
	public void addCashier(Cashier cash) {

		try {
			// INSERT QUERY
			final String query = "INSERT INTO cashier(cashierId,Cashier_Name,Mobile_Number,Address,Email_ID,Password) VALUES(?,?,?,?,?,?)";

			// PREPARING STATEMENT
			ps = ConnectionDb.getDbConnection().prepareStatement(query);

			// POSITIONAL MAPPING OF ATTRIBUTES
			ps.setInt(1, cash.getCashierId());
			ps.setString(2, cash.getcName());
			ps.setString(3, cash.getMobileNumber());
			ps.setString(4, cash.getAddress());
			ps.setString(5, cash.getEmailId());
			ps.setString(6, cash.getPassword());

			// EXECUTING THE QUERY
			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println("Cashier Registered!!");
			} else {
				System.out.println("Failed to Register");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// LOGIN METHOD
	@Override
	public boolean Login(String un, String psw) {
		final String query = "SELECT * FROM cashier WHERE  Email_ID ='"+un+"' AND Password = '" + psw + "'";
		try {
			PreparedStatement ps = ConnectionDb.getDbConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Cashier> getAllCashier() {
		List<Cashier> clist = new ArrayList<Cashier>();
		String query = "SELECT * FROM cashier";
		try {
			PreparedStatement ps = ConnectionDb.getDbConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cashier c = new Cashier();
				c.setCashierId(rs.getInt("cashierId"));
				c.setcName(rs.getString("Cashier_Name"));
				c.setMobileNumber(rs.getString("Mobile_Number"));
				c.setAddress(rs.getString("Address"));
				c.setEmailId(rs.getString("Email_Id"));
				c.setPassword(rs.getString("Password"));
				clist.add(c);
			}
			return clist;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// Generate Bill
	@Override
	public int generateBill(Bill bill) {
		try {

			// Check if the customer exists before inserting the bill
			int customerId = getCustomerIdByName(bill.getCustomer().getCustomer_name());
			if (customerId == -1) {
				// Customer does not exist,
				System.out.println("Customer does not exist.");
				return 0;
			}

			String query = "INSERT INTO bill(billNo, productId, customerId, purchaseDate, purchQuantity, discount, amount) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = ConnectionDb.getDbConnection().prepareStatement(query);
			ps.setInt(1, bill.getBillNo());
			ps.setInt(2, bill.getProduct().getProductId());
			ps.setInt(3, customerId); // Accessing customer ID directly
			ps.setString(4, bill.getPurchaseDate());
			ps.setInt(5, bill.getPurchQuantity());
			ps.setInt(6, bill.getDiscount());
			ps.setInt(7, bill.getAmount());

			int status = ps.executeUpdate();
			if (status > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace(); // Print the exception for debugging purposes
		}
		return 0;
	}

	// GetcustomerID
	private int getCustomerIdByName(String Customer_name) {
		int customerId = -1; // Default value if customer is not found
		try {
			String query = "SELECT customerId FROM customer WHERE customerName = ?";
			PreparedStatement ps = ConnectionDb.getDbConnection().prepareStatement(query);
			ps.setString(1, Customer_name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customerId = rs.getInt("customerId");
			}
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
		return customerId;
	}

	@Override
	public List<Bill> getAllBill() {
		List<Bill> blist = new ArrayList<>();
		String query = "SELECt ProductName,PurchQuantity,mrp,amount from bill b  JOIN product p ON b.productId = p.ProductId";
		try {
			Statement stm = ConnectionDb.getDbConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Product p = new Product();
				p.setProductName(rs.getString("ProductName"));
				Bill bill = new Bill();
				p.setMrp(rs.getInt("Mrp"));
				bill.setPurchQuantity(rs.getInt("purchQuantity"));
				bill.setAmount(rs.getInt("amount"));
				bill.setProduct(p);
				blist.add(bill);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return blist;
	}

	@Override
	public List<Bill> searchBill(int billNo) {
		List<Bill> cbList = new ArrayList<Bill>();
		String query = "SELECT b.billNo, c.customerName, b.amount, b.purchaseDate FROM bill b JOIN customer c ON b.customerId = c.customerId WHERE b.billNo ='"
				+ billNo + "'";
		Statement stm;
		try {
			stm = ConnectionDb.getDbConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Customer c = new Customer();
				c.setCustomer_name(rs.getString("customerName"));
				Bill bill = new Bill();
				bill.setBillNo(rs.getInt("billNo"));
				bill.setAmount(rs.getInt("amount"));
				bill.setPurchaseDate(rs.getString("purchaseDate"));

				// setting the Customer in bill
				bill.setCustomer(c);

				// adding bill object into list
				cbList.add(bill);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
              
		return cbList;  //returning the list of bill
	}

	@Override
	public int deleteCashier(int id) {
		  String query = "DELETE  FROM  CASHIER WHERE cashierId ='"+id+"'";
		  
		  try {
			PreparedStatement ps = ConnectionDb.getDbConnection().prepareStatement(query);
			int status = ps.executeUpdate(query);
			if(status>0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCashier(Cashier cash) {
		  String query = "update cashier set Cashier_Name ='"+cash.getcName()+"' ,Mobile_Number ='"+cash.getMobileNumber()+"',Address ='"+cash.getAddress()+"',Email_ID ='"+cash.getEmailId()+"',Password ='"+cash.getPassword()+"' WHERE cashierId = '"+cash.getCashierId()+"'";
		  try {
			PreparedStatement stm = ConnectionDb.getDbConnection().prepareStatement(query);
			int status = stm.executeUpdate();
			
			if(status >0) {
				return 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		  
		  return 0;
	}

}
