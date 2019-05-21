package app.controller;

import java.time.LocalDate;

public class Payment {
	
	private double dPayment;
	private double dInterest;
	private LocalDate date;
	
	public Payment(double principal, double rate, double time, LocalDate payDate) {
		date=payDate;
		
	}
}
