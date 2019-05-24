package app.controller;

import java.time.LocalDate;
import java.util.LinkedList;

import org.apache.poi.ss.formula.functions.Finance;

public class Loan {
	
	private double dMInterest;
	private double dPrincipal;
	private int nMonths;
	private double dAddPay;
	private LocalDate startDate;
	private static int paymentDay;
	
	private LinkedList<Payment> payments = new LinkedList<Payment>();
	
	private double totalPayment = 0;
	private double totalInterest = 0;
	
	public Loan(double interest, double length, double loan, double extra, LocalDate start) {
		dMInterest=interest/12;
		nMonths=(int) length*12;
		dPrincipal=loan;
		dAddPay=extra;
		startDate = start;
		paymentDay = start.getDayOfMonth();
		
		payments=createPayments();
		
	}
	
	public LinkedList<Payment> createPayments(){
		LinkedList<Payment> payList = new LinkedList<Payment>();
		double remainingBalance = this.dPrincipal;
		int payNum = 1;
		LocalDate payDate = startDate;
		while (remainingBalance>0) {
			Payment pay = new Payment(payNum, dPrincipal, dMInterest, nMonths, dAddPay, remainingBalance, payDate);
			payDate = nextDate(payDate);
			payNum++;
			remainingBalance = pay.getBalance();
			payList.add(pay);
			
			totalPayment = totalPayment + pay.getPayment() + pay.getAdditional();
			totalInterest = totalInterest + pay.getInterest();
		}
		
		return payList;
	}
	
	public static LocalDate nextDate(LocalDate current) {
		int month = current.getMonthValue();
		int year = current.getYear();
		int day = paymentDay;
		
		int nextYear = year;
		int nextMonth = month+1;
		if (nextMonth>12) {
			nextMonth = 1;
			nextYear = year+1;
		}
		if (day==31 || day==30 || day==29) {
			if (nextMonth==4 || nextMonth==6 || nextMonth==9 || nextMonth==11) {
				if (day==31) {
					day=30;
				}
			}
			else if (nextMonth==2) {
				if (nextYear%4==0) {
					day=29;
				}
				else {
					day=28;
				}
				if (nextYear%100==0 && nextYear%400!=0){
					day=28;
				}
				
			}
		}
		
		
		LocalDate next = current.withMonth(nextMonth).withYear(nextYear).withDayOfMonth(day);
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
