package com.bank.main;

import java.util.Scanner;

import com.bank.dao.Bankdao;
import com.bank.dao.BankdaoImp;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;

public class Deposite {
	
	public static void GetDeposite(Customer c) {
		Scanner in = new Scanner(System.in);
		Bankdao bdao = new BankdaoImp();
		System.out.println("Enter the Amount");
		double amount = in.nextDouble();
		System.out.println("Enter pin");
		int pin = in.nextInt();
		if (c.getPin() == pin) {
			c.setBal(amount + c.getBal());
			boolean result = bdao.updateCustomer(c);
			if(result) {
				System.out.println("Deposite Successful");
				Transaction t = new Transaction(c.getAccno(), 0,"DEPOSITE", amount, c.getPin());
				boolean result2 = bdao.insertTransaction(t);
				if(result2 == false) {
					System.out.println("Failed to Insert into DB");
				}
			}
		}else {
			System.out.println("Invalide Pin");
		}
		
	}
}
