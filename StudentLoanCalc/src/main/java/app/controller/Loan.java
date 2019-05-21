package app.controller;

import java.time.LocalDate;
import java.util.LinkedList;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Loan {
	
	private double dMInterest;
	private double dPrincipal;
	private double dMonths;
	private double dAddPay;
	private LocalDate startDate;
	
	private LinkedList<Payment> payments = new LinkedList<Payment>();
	
	private double totalPayment = 0;
	private double totalInterest = 0;
	
	public Loan(double interest, double length, double loan, double extra, LocalDate start) {
		dMInterest=interest/12;
		dMonths=length*12;
		dPrincipal=loan;
		dAddPay=extra;
		startDate = start;
		
		payments=createPayments();
		
	}
	
	public LinkedList<Payment> createPayments(){
		LinkedList<Payment> payList = new LinkedList<Payment>();
		double remainingBalance = this.dPrincipal;
		int payNum = 1;
		LocalDate payDate = startDate;
		while (remainingBalance>0) {
			Payment pay = new Payment(payNum, dPrincipal, dMInterest, dMonths, dAddPay, remainingBalance, payDate);
			payDate = nextDate(payDate);
			payNum++;
			remainingBalance = pay.getBalance();
			payList.add(pay);
			
			totalPayment = totalPayment + pay.getPayment();
			totalInterest = totalInterest + pay.getInterest();
		}
		
		return payList;
	}
	
	public static LocalDate nextDate(LocalDate current) {
		int month = current.getMonthValue();
		int year = current.getYear();
		
		int nextYear = year;
		int nextMonth = month+1;
		if (nextMonth>12) {
			nextMonth = 1;
			nextYear = year+1;
		}
		
		LocalDate next = current.withMonth(nextMonth).withYear(nextYear);
		return next;
	}
	
	public double getTotalPayment() {
		return totalPayment;
	}
	
	public double getTotalInterest() {
		return totalInterest;
	}
	
	public LinkedList<Payment> getPayments(){
		return payments;
	}

}
