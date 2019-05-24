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
	
	public Payment(int n, double loan, double rate, int time, double additional, double balance, LocalDate payDate) {
		num=n;
		date=payDate;
		double amount = roundIt(Math.abs(Finance.pmt(rate, time, loan, 0, 0)));
		
		
		
		dPayment = amount;
		dAdd=additional;
		
		dInterest = roundIt(rate*balance);
				
		dPrincipal=amount+additional-dInterest;
		dBalance=balance-dPrincipal;
		
		double check = dInterest+balance;
		if ((dPayment+dAdd)>=check) {
			if (dAdd==0) {
				dPayment =check;
			}
			else if (dPayment>check) {
				dAdd=0;
				dPayment=check;
			}
			else {
				dAdd=check-dPayment;
			}
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
		return dPayment;
	}
	
	
	public double getAdditional() {
		return roundIt(dAdd);
	}
	
	public double getInterest() {
		return dInterest;
	}
	
	public double getPrincipal() {
		return roundIt(dPrincipal);
	}
	
	public double getBalance() {
		return roundIt(dBalance);
	}
	
	public static double roundIt(double value) {
		double a = value*100.0;
		if (a%1>=0.5) {
			a=Math.ceil(a);
		}
		else {
			a=Math.floor(a);
		}
		return a/100.0;
	}
}
