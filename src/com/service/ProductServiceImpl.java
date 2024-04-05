package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.database.ConnectionDb;
import com.model.Bill;
import com.model.Customer;
import com.model.Product;

public class ProductServiceImpl implements ProductService {

	@Override
	public int addProduct(Product prod) {
		Product p = new Product();
		String query = "INSERT INTO PRODUCT(ProductName,Available,Mrp) VALUES('" + prod.getProductName() + "','"
				+ prod.getQuantity_available() + "','" + prod.getMrp() + "')";

		try {
			PreparedStatement ps = ConnectionDb.getDbConnection().prepareStatement(query);
			int status = ps.executeUpdate(query);

			if (status > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> plist = new ArrayList<Product>();
		String query = "SELECT * FROM product";
		try {
			Statement stm = ConnectionDb.getDbConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Product prod = new Product();
				prod.setProductId(rs.getInt("ProductId"));
				prod.setProductName(rs.getString("ProductName"));
				prod.setQuantity_available(rs.getInt("Available"));
				prod.setMrp(rs.getInt("Mrp"));
				plist.add(prod);
			}

			return plist;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateProduct(Product prod) {
		String query = "Update Product SET ProductName = '" + prod.getProductName() + "', Available = '"
				+ prod.getQuantity_available() + "', Mrp= '" + prod.getMrp() + "' WHERE ProductId = '"
				+ prod.getProductId() + "'";

		try {
			PreparedStatement ps = ConnectionDb.getDbConnection().prepareStatement(query);
			int status = ps.executeUpdate(query);

			if (status > 0) {
				return 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}
     //Search Product
	@Override
	public List<Product> searchProduct(int sid) {
		List<Product> plist = new ArrayList<>();
		String query = "SELECT  * FROM product where ProductId = '" + sid + "'";

		PreparedStatement ps;
		try {
			ps = ConnectionDb.getDbConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt("ProductId"));
				p.setProductName(rs.getString("ProductName"));
				p.setQuantity_available(rs.getInt("Available"));
				p.setMrp(rs.getInt("Mrp"));

				plist.add(p);
				return plist;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	//Get Product By ID
	@Override
	public Product getProductById(int productId) {
		 
	  List<Product> plist = getAllProducts();
	  
	  for(Product product : plist) {
		  if(product.getProductId() == productId) {
			  return product;  //return product if found
		  }
	  }
		
		
		return null; //return null if not found
	}

}
