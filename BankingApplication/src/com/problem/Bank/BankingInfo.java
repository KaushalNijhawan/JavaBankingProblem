/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.problem.Bank;

/**
 *
 * @author rashikasingh64
 */
public class BankingInfo {
    
        long bankBalanace = 1200000;
	String savingsName;
	String savingsContacnumber;
	String savingsEmail;
	private String savingsNumber;
	private String savingsBalance;
	private String currentBalance;
	String currentCompName;
	String currentRepresentativeName;
	String currentContactNumber;
	String currentEmail;
	String currentBussinessType;
    private String currentNumber;
    
    public BankingInfo() {
    	
    }
    
    public BankingInfo(String savingsname , String savingsContactNumber , String savingsEmail , String savingsNumber) {
    	this.savingsName = savingsname;
    	this.savingsContacnumber = savingsContactNumber;
    	this.savingsEmail = savingsEmail;
    	this.savingsBalance = savingsNumber;
    }
    public BankingInfo(String currentCompName , String RepresentativeName , String currentContactnumber  , String currentEmail , String currentBusinessType , String currentNumber ) {
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

	public String getSavingsContacnumber() {
		return savingsContacnumber;
	}

	public void setSavingsContacnumber(String savingsContacnumber) {
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

	public String getCurrentContactNumber() {
		return currentContactNumber;
	}

	public void setCurrentContactNumber(String currentContactNumber) {
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

	public String getSavingsNumber() {
		return savingsNumber;
	}

	public void setSavingsNumber(String savingsNumber) {
		this.savingsNumber = savingsNumber;
	}

	public String getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(String currentNumber) {
		this.currentNumber = currentNumber;
	}

	public String getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(String savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public String getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}

}
