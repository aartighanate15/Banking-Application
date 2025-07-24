package com.bank.main;

import java.util.Scanner;

import com.bank.dao.Bankdao;
import com.bank.dao.BankdaoImp;
import com.bank.dto.Customer;

public class Resetpin {
	public static void Getresetpin(Customer c) {
		Scanner in = new Scanner(System.in);
		Bankdao bdao = new BankdaoImp();
		System.out.println("Enter pin");
		int pin = in.nextInt();
		if (c.getPin() == pin) {
			System.out.println("Enter New Pin");
			int pin1 = in.nextInt();
			c.setPin(pin1);
			boolean result = bdao.updateCustomer(c);
			if(result) {
				System.out.println("Pin updated Successfuly");
			}else {
				System.out.println("Din't updated to DB");
			}
		} else {
			System.out.println("Invalide Pin");
		}
	}
}
