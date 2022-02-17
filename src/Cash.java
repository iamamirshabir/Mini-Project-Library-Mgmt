

import java.util.Scanner;

public class Cash {
static	Scanner input=new Scanner(System.in);
public static double balance,stockprice;
public static double expense,funds;

public Cash() {
balance=0.000;
stockprice=0.000;
}
public static void  addFunds() {
	System.out.println("Enter the amount of funds received.");
	double temp=input.nextDouble();
	balance=balance+temp;
	funds=funds+temp;
}
public static void minusExp() {
	System.out.println("Enter the amount of expenses.");
	double temp=input.nextDouble();
	balance=balance-temp;
	expense=expense+temp;
}
public static double calStock() {
	for(int i=0;i<Book.books.size();i++) {
		stockprice=stockprice+Book.books.get(i).getPrice();
	}
	return stockprice;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public double getStockprice() {
	return stockprice;
}
public void setStockprice(double stockprice) {
	this.stockprice = stockprice;
}
public double getExpense() {
	return expense;
}
public void setExpense(double expense) {
	this.expense = expense;
}
public double getFunds() {
	return funds;
}
public void setFunds(double funds) {
	this.funds = funds;
}
}
