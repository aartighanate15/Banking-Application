package com.bank.main;

import java.util.Scanner;

import com.bank.dao.Bankdao;
import com.bank.dao.BankdaoImp;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;

public class Transfer {
	public static void Gettransfer(Customer c) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Accout number of Benificiery");
		long acc = in.nextLong();
		Transaction t1 = null;
		Transaction t2 = null;
		System.out.println("Enter the Amount to be transfered");
		double amount = in.nextDouble();
		
		Bankdao bdao = new BankdaoImp();
		Customer c2 = bdao.getCustomer(acc);
		if (c.getAccno() != c2.getAccno() && c.getBal() >= amount && c.getBal() >0 && amount >0) {
			
			System.out.println("Enter PIN");
			int pin = in.nextInt();
			if (pin == c.getPin()) {
				c.setBal(c.getBal() - amount);
				System.out.println(c);
				boolean res = bdao.updateCustomer(c);
				
				if(res == true ) {
					t1 = new  Transaction();
					t1.setUser(c.getAccno());
					t1.setRec_acc(c2.getAccno());
					t1.setTransactionId(TransactionId.CreateTransactionId());
					t1.setTransaction("DEBITE");
					t1.setAmount(amount);
					t1.setBalance(c.getBal());	
					t1.setDate();
				    bdao.insertTransaction(t1);
				}
				c2.setBal(amount + c2.getBal());

				boolean res1 = bdao.updateCustomer(c2);
				if(res1 == true) {
					t2 = new  Transaction();
					t2.setUser(c2.getAccno());
					t2.setRec_acc(c.getAccno());
					t2.setTransactionId(t1.getTransactionId());
					t2.setTransaction("CREDIT");
					t2.setAmount(amount);
					t2.setBalance(c2.getBal());	
					t2.setDate();
				    bdao.insertTransaction(t2);
				}
				System.out.println("Transection Succefull");	

			}else {
				System.out.println("Invalid PIN");

			}			
		} else {
			System.out.println("Account Number not Found or Invalid Balance Or Invalid Amount");
		}
	}
}
