package pkgUT;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import app.controller.Loan;

public class LoanTest {
	@Test
	public void dateTest() {
		LocalDate today = LocalDate.now();
		System.out.println(today);
		System.out.println(Loan.nextDate(today));
		System.out.println(today.plusMonths(7));
		System.out.println(Loan.nextDate(today.plusMonths(7)));
	}

}
