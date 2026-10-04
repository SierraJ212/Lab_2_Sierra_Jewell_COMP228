package com.sj.week4.bankaccount;
import java.util.Scanner;

public class DriverMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("===========================");
		System.out.println("=== BANK ACCOUNT SYSTEM ===");
		System.out.println("===========================");
		
		BankAccount[] accounts = new BankAccount[3];
		
		for (int i = 0; i < accounts.length; i++) {
            System.out.println("\nEnter information for Account " + (i + 1));

            while (accounts[i] == null) {
                System.out.print("Account Number: ");
                String accountNumber = scanner.nextLine();

                System.out.println("Initial Balance: $");
                double balance = scanner.nextDouble();
                scanner.nextLine();
                
                System.out.print("Name: ");
                String name = scanner.nextLine();
                
                System.out.println("press enter to confirm.");
                scanner.nextLine(); //clears line

                try {
                    accounts[i] = new BankAccount(accountNumber, balance, name);
                    System.out.println("Account created.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + " Please try again.");
                }
            }
        }

        // Transactions
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("\n=== Transactions for Account " + (i + 1) + " ===");

            // Deposit
            while (true) {
                System.out.println("Enter deposit amount: ");
                double amt = scanner.nextDouble();
                try {
                    accounts[i].deposit(amt);
                    System.out.println("Deposit successful.");
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } finally {
                    System.out.println("Deposit transaction processed.");
                }
            }

            // Withdrawal
            while (true) {
                System.out.println("Enter withdrawl amount: ");
                double amt = scanner.nextDouble();
                try {
                    accounts[i].withdraw(amt);
                    System.out.println("Withdrawal successful.");
                    break;
                } catch (InsufficentFundsException | IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } finally {
                    System.out.println("Withdrawal transaction processed.");
                }
            }
        }

        System.out.println("\n=== FINAL BALANCES ===");
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }

        scanner.close();
    	}
			
	}


