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
		
	}
	
	public int getNumber() {
		return num;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public double getPayment() {
		return dPayment;
	}
	
	public double getAdditional() {
		return dAdd;
	}
	
	public double getInterest() {
		return dInterest;
	}
	
	public double getPrincipal() {
		return dPrincipal;
	}
	
	public double getBalance() {
		return dBalance;
	}
}
