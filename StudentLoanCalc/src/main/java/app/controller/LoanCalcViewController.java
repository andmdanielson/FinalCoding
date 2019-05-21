package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



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
	
	@FXML
	private TableView<Payment> LoanTable;
	
	@FXML
	private TableColumn<Payment, Integer> PayNum;
		
	@FXML
	private TableColumn<Payment, LocalDate> DueDate;
	
	@FXML
	private TableColumn<Payment, Double> PayAmount;
	
	@FXML
	private TableColumn<Payment, Double> AdditionalPay;
	
	@FXML
	private TableColumn<Payment, Double> Interest;
	
	@FXML
	private TableColumn<Payment, Double> Principle;
	
	@FXML
	private TableColumn<Payment, Double> Balance;
	
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
		
		LinkedList<Payment> paymentList = loanDetails.getPayments();
		
		ObservableList<Payment> finalData = FXCollections.observableArrayList();
		
		for (Payment p : paymentList) {
			finalData.add(p);
		}
		
		PayNum.setCellValueFactory(new PropertyValueFactory<Payment,Integer>("number"));
		DueDate.setCellValueFactory(new PropertyValueFactory<Payment,LocalDate>("date"));
		PayAmount.setCellValueFactory(new PropertyValueFactory<Payment,Double>("payment"));
		AdditionalPay.setCellValueFactory(new PropertyValueFactory<Payment,Double>("additional"));
		Interest.setCellValueFactory(new PropertyValueFactory<Payment,Double>("interest"));
		Principle.setCellValueFactory(new PropertyValueFactory<Payment,Double>("principal"));
		Balance.setCellValueFactory(new PropertyValueFactory<Payment,Double>("balance"));
		
		LoanTable.setItems(finalData);
	 
		System.out.println(localDate);
		
	}
}
