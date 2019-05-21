package pkgUT;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import app.controller.Payment;

public class paymentTest {
	@Test
	public void pay_test() {
		double rate = 0.07/12;
		double time = 20*12;
		double amount = 100000;
		double add = 0;
		LocalDate date = LocalDate.now();
		
		Payment pay = new Payment(1,amount,rate,time,add,amount,date);
				
		double PMTactual = pay.getPayment();
		double PMTexpected = 775.30;
		assertEquals(PMTexpected,PMTactual,0.01);
		
	}
	
	@Test
	public void balance_test() {
		double rate = 0.07/12;
		double time = 20*12;
		double amount = 100000;
		double add = 0;
		LocalDate date = LocalDate.now();
		
		Payment pay = new Payment(1,amount,rate,time,add,amount,date);
		
		double bal = pay.getBalance();
		double balExpected = 99808.03;
		assertEquals(balExpected,bal,0.01);	
	}
	@Test
	public void principalTest() {
		double rate = 0.07/12;
		double time = 20*12;
		double amount = 100000;
		double add = 0;
		LocalDate date = LocalDate.now();
		
		Payment pay = new Payment(1,amount,rate,time,add,amount,date);
		
		double prin = pay.getPrincipal();
		double prinExpected = 191.97;
		assertEquals(prinExpected,prin,0.01);	
	}
	@Test
	public void interestTest() {
		double rate = 0.07/12;
		double time = 20*12;
		double amount = 100000;
		double add = 0;
		LocalDate date = LocalDate.now();
		
		Payment pay = new Payment(1,amount,rate,time,add,amount,date);
		
		double interest = pay.getInterest();
		double interExpected = 583.33;
		assertEquals(interExpected,interest,0.01);
	}

}
