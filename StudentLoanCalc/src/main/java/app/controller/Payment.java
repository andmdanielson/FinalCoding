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
		double amount = Math.round(Math.abs(Finance.pmt(rate, time, loan, 0, 0))*100.0)/100.0;
		
		dPayment = amount;
		dAdd=additional;
		
		double InterestCalc = rate*balance*100.0;
		if (InterestCalc%10>5) {
			InterestCalc = Math.ceil(InterestCalc);
		}
		else {
			InterestCalc = Math.floor(InterestCalc);
		}
		dInterest = InterestCalc/100.0;
				
		dPrincipal=amount+additional-dInterest;
		dBalance=balance-dPrincipal;
		
		double check = dInterest+balance;
		if ((dPayment+dAdd)>=check) {
			if (dAdd==0) {
				dPayment =check;
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
		return Math.round(dPayment*100.0)/100.0;
	}
	
	
	public double getAdditional() {
		return Math.round(dAdd*100.0)/100.0;
	}
	
	public double getInterest() {
		return dInterest;
	}
	
	public double unroundedInterest() {
		return dInterest;
	}
	
	public double getPrincipal() {
		return Math.round(dPrincipal*100.0)/100.0;
	}
	
	public double getBalance() {
		return Math.round(dBalance*100.0)/100.0;
	}
	
	public double unroundedBalance() {
		return dBalance;
	}
}
