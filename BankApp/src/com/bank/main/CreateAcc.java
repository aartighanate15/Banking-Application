package com.bank.main;

import java.util.Scanner;

import com.bank.dao.Bankdao;
import com.bank.dao.BankdaoImp;
import com.bank.dto.Customer;

public class CreateAcc {
	public static void createAcc() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Name");
		String name = in.next();
		System.out.println("Phone number");
		long phone = in.nextLong();
		System.out.println("Enter mail");
		String mail = in.next();
		System.out.println("Enter pin");
		int pin=in.nextInt();
		Customer c = new Customer(name, phone, mail, pin);
		Bankdao bdao = new BankdaoImp();
		boolean result = bdao.insertCustomer(c);
		if(result) {
			System.out.println("Succefully Inserted the data");
			System.out.println("Your Account Number is "+c.getAccno());
			Options.GetOptions(c);
		}else {
			System.out.println("Duplicate Entery");

		}
		
	}
}
