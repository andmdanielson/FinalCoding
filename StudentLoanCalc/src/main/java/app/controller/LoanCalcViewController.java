package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;



public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;

	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private Label lblTotalInterest;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField NbrOfYears;
	
	@FXML
	private TextField AdditionalPayment;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		System.out.println("Amount: " + LoanAmount.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		double dInterestRate = Double.parseDouble(InterestRate.getText());
		double dNbrOfYears = Double.parseDouble(NbrOfYears.getText());
		double dAddPayment = Double.parseDouble(AdditionalPayment.getText());
		
		LocalDate localDate = PaymentStartDate.getValue();
		
		Loan loanDetails=new Loan(dInterestRate, dNbrOfYears, dLoanAmount, dAddPayment, localDate);
		
		double payment_sum = loanDetails.getTotalPayment();
		double rounded = Math.round(payment_sum*100.0)/100.0;
		
		double interest_sum = loanDetails.getTotalInterest();
		double rounded_interest = Math.round(interest_sum*100.0)/100.0;
		
		lblTotalPayemnts.setText(""+rounded+"");
		lblTotalInterest.setText(""+rounded_interest+"");
	 
		System.out.println(localDate);
		
	}
}
