package com.bank.main;

import java.util.Scanner;

import com.bank.dao.Bankdao;
import com.bank.dao.BankdaoImp;
import com.bank.dto.Customer;

public class Login {
	public static Customer GetLogin() {
		Scanner in = new Scanner(System.in);
		Bankdao Bdao = new BankdaoImp();
		System.out.println("Enter the Account Number");
		long accno = in.nextLong();
		System.out.println("Enter Pin");
		int pass = in.nextInt(); 
		Customer c = Bdao.getCustomer(accno, pass);
		if (c != null) {
			System.out.println("Succefully Loggedin");
			System.out.println("Welcome " + c.getName() + " ");
			Options.GetOptions(c);
		}
		return c;
	}
}
