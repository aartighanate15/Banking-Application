package com.bank.main;

import java.util.Scanner;

import com.bank.dto.Customer;

public class Options {
	public static void GetOptions(Customer c) {
		boolean flag = true;
		while (flag) {
			System.out.println("1 : Deposite");
			System.out.println("2 : WithDraw");
			System.out.println("3 : Balance");
			System.out.println("4 : ResetPin");
			System.out.println("5 : Transfer");
			System.out.println("6 : PassBook");
			System.out.println("7 : Main menu");
			System.out.println("8 : EXIT");

			Scanner in = new Scanner(System.in);
			int option = in.nextInt();
			switch (option) {
			case 1:
				Deposite.GetDeposite(c);
				break;
			case 2:
				Withdraw.getWithdraw(c);
				break;
			case 3:
				Balance.Getbalance(c);
				break;
			case 4:
				Resetpin.Getresetpin(c);
				break;
			case 5:
				Transfer.Gettransfer(c);
				break;
			case 6:
				Passbook.Getpassbook(c);
				break;
			case 7:
				Main.main(null);
				break;
			case 8:
				flag = false;
				break;
			}
		}
	}
}
