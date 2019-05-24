package pkgUT;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import app.helper.Loan;

public class LoanTest {
	@Test
	public void dateTest() {
		LocalDate today = LocalDate.now();
		Loan testLoan = new Loan(0.15, 5, 10000, 0, today);
		System.out.println(today);
		System.out.println(testLoan.nextDate(today));
		System.out.println(today.plusMonths(7));
		System.out.println(testLoan.nextDate(today.plusMonths(7)));
	}

}
