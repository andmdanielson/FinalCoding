package pkgUT;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import app.controller.Payment;

public class PaymentTest {
	@Test
	public void pay_test() {
		double rate = 0.07/12;
		int time = 20*12;
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
		int time = 20*12;
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
		int time = 20*12;
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
		int time = 20*12;
		double amount = 100000;
		double add = 0;
		LocalDate date = LocalDate.now();
		
		Payment pay = new Payment(1,amount,rate,time,add,amount,date);
		
		double interest = pay.getInterest();
		double interExpected = 583.33;
		assertEquals(interExpected,interest,0.01);
	}
	
	@Test
	public void round_test_1() {
		double test = Payment.roundIt(122.5149);
		double expected = 122.51;
		assertEquals(test,expected,0);
	}
	
	@Test
	public void round_test_2() {
		double test = Payment.roundIt(122.5153);
		double expected = 122.52;
		assertEquals(expected,test,0);
	}
	
	@Test
	public void round_test_3() {
		double test = Payment.roundIt(122.528);
		double expected = 122.53;
		assertEquals(expected,test,0);
	}

}

