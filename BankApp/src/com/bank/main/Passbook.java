package com.bank.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bank.connector.*;
import com.bank.dao.Bankdao;
import com.bank.dao.BankdaoImp;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;


public class Passbook {
	public static void Getpassbook(Customer c) {
		Bankdao bdao = new BankdaoImp();
		List<Transaction> trans = new ArrayList<>();
		trans = bdao.getTransaction(c.getAccno());
		Iterator<Transaction> it =  trans.iterator();
		
		while(it.hasNext()) {
			Transaction t1 = it.next();
			System.out.println("Transation ID              : "+ t1.getTransactionId());
			System.out.println("Customer Account Number    : "+ t1.getUser());
			System.out.println("Beneficiery Account Number : "+ t1.getRec_acc());
			System.out.println("DATE	                   : "+t1.getDate());
			System.out.println("Transaction Type           : "+t1.getTransaction());
			System.out.println("Amount                     : "+t1.getAmount());
			System.out.println("Balance                    : "+t1.getBalance());
			System.out.println("-----------------------------------------------------------------------");

		}
				
	}
}
