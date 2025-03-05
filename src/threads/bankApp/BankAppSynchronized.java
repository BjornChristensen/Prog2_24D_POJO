package threads.bankApp;
// BankApp2 - Liveprogramming.
// Demo af klasser, objekter, constructor, toString, ArrayList,LocalDate
// Demo af static
// Bjørn Christensen, 11/9-2020

import java.time.LocalDate;
import java.util.ArrayList;

public class BankAppSynchronized {
	public static void main(String[] args) throws InterruptedException {
		Account a1=new Account("Joe Pass", 1.5);
		Customer tom=new Customer(a1);
		Customer jerry=new Customer(a1);
		tom.start();
		jerry.start();

		tom.join();
		jerry.join();
		a1.printTransactions();
	}
}

class Customer extends Thread {
	Account account;
	Customer(Account account){
		this.account=account;
	}
	public void run(){
		account.deposit(1000);
		account.withdraw(10);
		account.deposit(1000);
	}
}

class Account {
	int accountNo;
	String owner;
	double balance;
	double interestRate;	// rente i %
	ArrayList<Transaction> transactions=new ArrayList<Transaction>(); 
	private static int noOfAccounts=0;
	
//	BankApp.Account(String ow, double rate, int aNo){
//		owner=ow;
//		interestRate=rate;
//		accountNo=aNo;
//		balance=0;
//	}

	Account(String ow, double rate){
		noOfAccounts++;
		accountNo=noOfAccounts;
		owner=ow;
		interestRate=rate;
		balance=0;
	}

	synchronized void deposit(double amount) {
		balance=balance+amount;
		transactions.add(new Transaction("Indsat", amount, balance) );
	}

	synchronized void withdraw(double amount) {
		balance=balance-amount;
		transactions.add(new Transaction("Hævet", -amount, balance) );
	}
	
	void printTransactions() {
		System.out.println(this);
		System.out.println("Tekst"+"\t"+"Dato"+"\t\t"+"Beløb"+"\t"+"Saldo");
		for (Transaction t: transactions) {
			System.out.println(t);
		}
		System.out.println();
	}

	void anualInterest() {	// Til brug for BankApp.BankApp3
		double interest=balance*interestRate/100;
		balance=balance+interest;
	  transactions.add(new Transaction("Renter", interest, balance));
	}

	public String toString() {
		return "Konto "+accountNo+": "+owner+" "+balance;
	}
}

class Transaction {
	String text;
	double amount;
	double newBalance;
	LocalDate date;
	
	Transaction(String t, double a, double nb) {
		text=t;
		amount=a;
		newBalance=nb;
		date=LocalDate.now();
	}
	
	public String toString() {
		return text+"\t"+date+"\t"+amount+"\t"+newBalance;
//		return String.format("%s\t%s\t%6.2f\t%6.2f", text, date, amount, newBalance);
	}
}