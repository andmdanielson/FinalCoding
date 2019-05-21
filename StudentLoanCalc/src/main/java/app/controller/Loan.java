package app.controller;

import java.time.LocalDate;
import java.util.LinkedList;

public class Loan {
	
	private double dYInterest;
	private double dMInterest;
	private double dPrincipal;
	private double dYears;
	private double dMonths;
	private double dAddPay;
	private double dFutureVal;
	private LocalDate startDate;
	
	private LinkedList<Payment> payments = new LinkedList<Payment>();
	
	private double totalPayment = 0;
	private double totalInterest = 0;
	
	public Loan(double interest, double length, double loan, double extra, LocalDate start) {
		dFutureVal=0;
		dYInterest=interest;
		dMInterest=dYInterest/12;
		dYears=length;
		dMonths=dYears*12;
		dPrincipal=loan;
		dAddPay=extra;
		startDate = start;
		
		//payments=createPayments();
		
	}
	
	//public LinkedList<Payment> createPayments(){
		
	//}
	
	public LocalDate nextDate(LocalDate current) {
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
	
	
	

}
