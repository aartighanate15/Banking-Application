package com.bank.main;

import java.util.Scanner;

import com.bank.dto.Customer;

public class Balance {
	public static void Getbalance(Customer c) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter pin");
		int pin = in.nextInt();
		if (c.getPin() == pin) {
			System.out.println("Current Balance :"+c.getBal());
		}else {
			System.out.println("Invalide Pin");
		}
	}
}
