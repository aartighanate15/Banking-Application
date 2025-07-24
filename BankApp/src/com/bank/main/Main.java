package com.bank.main;

import java.util.Scanner;

import com.bank.dao.Bankdao;
import com.bank.dao.BankdaoImp;
import com.bank.dto.Customer;

public class Main {
	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			Bankdao Bdao = new BankdaoImp();
			
			System.out.println("-------------- WELCOME TO STANDARD CHARTED BANK -----------------");
			System.out.println("1 : LOGIN");
			System.out.println("2 : CREATE NEW ACCOUNT");
			System.out.println("3 : EXIT");
			int num1= in.nextInt();
			switch(num1) {
			case 1:
					Login.GetLogin();
					break;
			case 2: 
					CreateAcc.createAcc();
					break;
		
			case 3:
					System.out.println("Thank You for visiting SCB!!!");
					System.exit(0);

			}

	}
}
