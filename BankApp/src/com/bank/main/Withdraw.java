package com.bank.main;

import java.util.Scanner;

import com.bank.dao.Bankdao;
import com.bank.dao.BankdaoImp;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;

public class Withdraw {
public  static void getWithdraw(Customer c) {
	Scanner in = new Scanner(System.in);
	Bankdao bdao = new BankdaoImp();
	System.out.println("Enter the Amount");
	double amount = in.nextDouble();
	System.out.println("Enter pin");
	int pin1 = in.nextInt();
	if (pin1 == c.getPin()) {
		if (c.getBal() > amount) {
			c.setBal(c.getBal() - amount);
			boolean result = bdao.updateCustomer(c);
			if(result) {
				System.out.println("Withdraw Successfull");
				Transaction t = new Transaction(c.getAccno(),0,"Withdraw",amount,c.getBal());
				boolean result2 = bdao.insertTransaction(t);
				if(result2 != true) {
					System.out.println("Faild to Insert into DB");
				}
			}else {
				System.out.println("Dint updated");

			}
			
		} else {
			System.out.println("Insufficent Balance");
		}
	} else {
		System.out.println("Invalid Pin");
	}
	
}
}
