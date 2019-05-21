package app.controller;

import java.time.LocalDate;

public class Loan {
	
	private double dYInterest;
	private double dMInterest;
	private double dPrincipal;
	private double dYears;
	private double dMonths;
	private double dAddPay;
	private double dFutureVal;
	private LocalDate startDate;
	
	public Loan(double interest, double length, double loan, double extra, LocalDate start) {
		dFutureVal=0;
		dYInterest=interest;
		dMInterest=dYInterest/12;
		dYears=length;
		dMonths=dYears*12;
		dPrincipal=loan;
		dAddPay=extra;
		startDate=start;
	}
	

}
