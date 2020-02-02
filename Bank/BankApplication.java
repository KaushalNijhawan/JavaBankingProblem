package com.classes.Bank;

public class BankApplication {
	private long bankBalanace = 1200000;
	String savingsName;
	long savingsContacnumber;
	String savingsEmail;
	private long savingsNumber;
	private long savingsBalance;
	private long currentBalance;
	String currentCompName;
	String currentRepresentativeName;
	long currentContactNumber;
	String currentEmail;
	String currentBussinessType;
    private long currentNumber;
    
    public BankApplication() {
    	
    }
    
    public BankApplication(String savingsname , long savingsContactNumber , String savingsEmail , long savingsNumber) {
    	this.savingsName = savingsname;
    	this.savingsContacnumber = savingsContactNumber;
    	this.savingsEmail = savingsEmail;
    	this.savingsBalance = savingsNumber;
    }
    public BankApplication(String currentCompName , String RepresentativeName , long currentContactnumber  , String currentEmail , String currentBusinessType , long currentNumber ) {
          this.currentCompName = currentCompName;
          this.currentRepresentativeName = RepresentativeName;
          this.currentContactNumber = currentContactnumber;
          this.currentEmail = currentEmail;
          this.currentBussinessType = currentBusinessType;
          this.currentBalance = currentNumber;
          
    }

	public long getBankBalanace() {
		return bankBalanace;
	}

	public void setBankBalanace(long bankBalanace) {
		this.bankBalanace = bankBalanace;
	}

	public String getSavingsName() {
		return savingsName;
	}

	public void setSavingsName(String savingsName) {
		this.savingsName = savingsName;
	}

	public long getSavingsContacnumber() {
		return savingsContacnumber;
	}

	public void setSavingsContacnumber(long savingsContacnumber) {
		this.savingsContacnumber = savingsContacnumber;
	}

	public String getSavingsEmail() {
		return savingsEmail;
	}

	public void setSavingsEmail(String savingsEmail) {
		this.savingsEmail = savingsEmail;
	}

	public String getCurrentCompName() {
		return currentCompName;
	}

	public void setCurrentCompName(String currentCompName) {
		this.currentCompName = currentCompName;
	}

	public String getCurrentRepresentativeName() {
		return currentRepresentativeName;
	}

	public void setCurrentRepresentativeName(String currentRepresentativeName) {
		this.currentRepresentativeName = currentRepresentativeName;
	}

	public long getCurrentContactNumber() {
		return currentContactNumber;
	}

	public void setCurrentContactNumber(long currentContactNumber) {
		this.currentContactNumber = currentContactNumber;
	}

	public String getCurrentEmail() {
		return currentEmail;
	}

	public void setCurrentEmail(String currentEmail) {
		this.currentEmail = currentEmail;
	}

	public String getCurrentBussinessType() {
		return currentBussinessType;
	}

	public void setCurrentBussinessType(String currentBussinessType) {
		this.currentBussinessType = currentBussinessType;
	}

	public long getSavingsNumber() {
		return savingsNumber;
	}

	public void setSavingsNumber(long savingsNumber) {
		this.savingsNumber = savingsNumber;
	}

	public long getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(long currentNumber) {
		this.currentNumber = currentNumber;
	}

	public long getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(long savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public long getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(long currentBalance) {
		this.currentBalance = currentBalance;
	}

}
