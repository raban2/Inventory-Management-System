package com.service;


import java.util.List;

import com.model.Bill;
import com.model.Cashier;


public interface CashierService {
	
	//Cashier
	void addCashier(Cashier cash);
	boolean Login(String un, String psw);	
	int deleteCashier(int id);
	int updateCashier(Cashier cash);
	List<Cashier> getAllCashier();
	
	//Bill 
	int generateBill(Bill bill);
	List<Bill> getAllBill();
	List<Bill> searchBill(int billNo);

}
