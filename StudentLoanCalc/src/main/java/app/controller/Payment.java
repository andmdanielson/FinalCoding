package app.controller;

import java.time.LocalDate;
import org.apache.poi.ss.formula.functions.*;

public class Payment {
	
	private int num;
	private double dPayment;
	private double dAdd;
	private double dInterest;
	private double dPrincipal;
	private double dBalance;
	private LocalDate date;
	
	public Payment(int n, double loan, double rate, double time, double additional, double balance, LocalDate payDate) {
		num=n;
		date=payDate;
		double amount = Math.abs(FinanceLib.pmt(rate, time, loan, 0, false));
		dPayment = amount+additional;
		dAdd=additional;
		dInterest=rate*balance;
		
		dPrincipal=amount-dInterest;
		dBalance=balance-dPrincipal;
		
		double check = dInterest+balance;
		if (dPayment>=check) {
			dPayment = check;
			dPrincipal = balance;
			dBalance = 0.0;
		}
		
	}
	
	public int getNumber() {
		return num;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public double getPayment() {
		return Math.round(dPayment*100.0)/100.0;
	}
	
	public double getAdditional() {
		return Math.round(dAdd*100.0)/100.0;
	}
	
	public double getInterest() {
		return Math.round(dInterest*100.0)/100.0;
	}
	
	public double getPrincipal() {
		return Math.round(dPrincipal*100.0)/100.0;
	}
	
	public double getBalance() {
		return Math.round(dBalance*100.0)/100.0;
	}
}
