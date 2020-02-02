package com.classes.Bank;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class BankServices {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static HashMap<Long, BankApplication> savings = new HashMap<>();
	static HashMap<Long, BankApplication> current = new HashMap<>();
	BankApplication bA = new BankApplication();

	public boolean checkCurrent(String email, String cname) {

		for (Map.Entry it : current.entrySet()) {
			BankApplication obj = (BankApplication) it.getValue();
			if (email.equalsIgnoreCase(obj.getCurrentEmail()) || cname.equalsIgnoreCase(obj.getCurrentCompName())) {
				return false;
			}
		}
		return true;
	}

	public boolean checkSavings(String email, long contact) {

		for (Map.Entry it : savings.entrySet()) {
			BankApplication obj = (BankApplication) it.getValue();
			if (email.equalsIgnoreCase(obj.getSavingsEmail())
					|| Long.toString(contact).equals(obj.getSavingsContacnumber())) {
				return false;
			}
		}

		return true;
	}

	public boolean isValidContact(String num) {
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(num);
		return (m.find() && m.group().equals(num));
	}

	public boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public boolean currentAccountValidate(long currentnumber) {
		try {
			@SuppressWarnings("unused")
			Object obj = current.get(currentnumber);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean savingsAccountValidate(long savingsnumber) {
		try {
			@SuppressWarnings("unused")
			Object obj = current.get(savingsnumber);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void reportAccount() throws Exception {
		String choice = "";
		System.out.println("Welcome to the Enquiry Service !!");
		System.out.println("Enter the Type Of Account\nCurrent\nSavings!!");
		choice = in.readLine();
		long num = 0;

		if (current.size() > 0 && choice.equalsIgnoreCase("current")) {
			System.out.println("Enter the Account Number !!");
			num = Long.parseLong(in.readLine());
			if (currentAccountValidate(num)) {
				System.out.println("Your Account is Current Account \nWith Current Bank Account Balance ---> "
						+ current.get(num).getCurrentBalance() + " Cr");
				System.out.println("Your Starting  Balance Was " + "o Cr");
			} else {
				System.err.println("No Current Account with this Number Exists");
			}

		} else if (choice.equalsIgnoreCase("savings") && savings.size() > 0) {
			System.out.println("Enter the Account Number !!");
			num = Long.parseLong(in.readLine());
			if (savingsAccountValidate(num)) {
				System.out.println("Your Account is Savings Account \nWith Current Bank Account Balance ---> "
						+ savings.get(num).getSavingsBalance() + " Cr");
				System.out.println("Your Starting Balance was " + "0 Cr");
			} else {
				System.err.println("No Savings Account with this Number Exists");
			}

		} else {
			System.err.println("No Account Exists");
		}
		return;
	}

	public void depositAmount() throws Exception {
		System.out.println("Enter the Account Type \n1. Savings\n2. Current ");
		String choice = in.readLine();
		long number = 0;
		long amount = 0;
		if (choice.equalsIgnoreCase("current") && current.size() > 0) {
			System.out.println("Enter the Account Number of Yours :");
			number = Long.parseLong(in.readLine());
			if (!currentAccountValidate(number)) {
				System.err.println("Your Account Number Not Found!!");
				depositAmount();
			}
			System.out.println("Enter the Amount to be Deposited :");
			amount = Long.parseLong(in.readLine());
			if (amount > 500000) {
				System.err.println("Amount Depositing Limit is only 5 Lacs per Day");
				return;

			} else {
				long bal = amount + bA.getBankBalanace();
				bA.setBankBalanace(bal);
				long currbalance = current.get(number).getCurrentBalance() + amount;
				current.get(number).setCurrentBalance(currbalance);
				System.out.println("Bank Balance Updated!!");

			}
		} else if (choice.equalsIgnoreCase("savings") && savings.size() > 0) {
			System.out.println("Enter the Account Number of Yours :");
			number = Long.parseLong(in.readLine());
			if (!savingsAccountValidate(number)) {
				System.err.println("Your Account Number Not Found!!");
				depositAmount();
			}
			System.out.println("Enter the Amount to be Deposited :");
			amount = Long.parseLong(in.readLine());
			if (amount > 100000) {
				System.err.println("Amount Depositing Limit is only 5 Lacs per Day");
				return;

			} else {
				long bal = amount + bA.getBankBalanace();
				bA.setBankBalanace(bal);
				long currbalance = savings.get(number).getSavingsBalance() + amount;
				savings.get(number).setSavingsBalance(currbalance);
				System.out.println("Bank Balance Updated!!");

			}
		} else if (current.size() == 0) {
			System.err.println("No Current Account Exists ");
		} else if (savings.size() == 0) {
			System.err.println("No Savings Account Exists ");
		}
		return;
	}

	public void withdrawAmount() throws Exception {
		System.out.println("Enter the Account Type \n1. Savings\n2. Current ");
		String choice = in.readLine();
		if (choice.contentEquals("current") && current.size() > 0) {
			System.out.println("Enter the Account number :");
			long num = Long.parseLong(in.readLine());
			if (!(currentAccountValidate(num))) {
				System.err.println("The Account Number is not Found!!");
				withdrawAmount();
			}
			System.out.println("Enter the Amount to be Withdrawn!!");
			long amount = Long.parseLong(in.readLine());
			if (amount > 300000 || bA.getCurrentBalance() < amount) {
				System.err.println("The amount limit is Exceeding!!");
				return;
			} else {
				long bal = bA.getBankBalanace() - amount;
				bA.setBankBalanace(bal);
				long currbalance = current.get(num).getCurrentBalance() - amount;
				current.get(num).setCurrentBalance(currbalance);
				System.out.println("Bank Balance Updated!!");
			}

		} else if (choice.equalsIgnoreCase("savings") && savings.size() > 0) {
			System.out.println("Enter the Account number :");
			long num = Long.parseLong(in.readLine());
			if (!(savingsAccountValidate(num))) {
				System.err.println("The Account Number is not Found!!");
				withdrawAmount();
			}
			System.out.println("Enter the Amount to be Withdrawn!!");
			long amount = Long.parseLong(in.readLine());
			if (amount > 75000 && bA.getSavingsBalance() < amount) {
				System.err.println("The amount withdrawn limit is Exceeding!!");
				return;
			} else {
				long bal = bA.getBankBalanace() - amount;
				bA.setBankBalanace(bal);
				long currbalance = savings.get(num).getSavingsBalance() - amount;
				savings.get(num).setSavingsBalance(currbalance);
				System.out.println("Bank Balance Updated!!");
			}

		} else if (current.size() == 0) {
			System.err.println("No Current Accounts Exist ");
		} else if (savings.size() == 0) {
			System.err.println("No Savings Account Exist ");
		}
		return;
	}

	public void createCurrentAccount() throws Exception {
		String contact = "";
		String email = "";
		System.out.println("Enter the company Name :");
		bA.setCurrentCompName(in.readLine());
		System.out.println("Enter the Representative Name :");
		bA.setCurrentRepresentativeName(in.readLine());
		System.out.println("Enter the Contact Number :");
		contact = in.readLine();
		if (!isValidContact(contact)) {
			System.err.println("The Contact Number is not Valid!!");
			System.out.println("Enter the Contact Number Again!!");
			contact = in.readLine();
			if (!isValidContact(contact)) {
				System.err.println("Your Attempts Are Over Now!!");
				return;
			}

		}
		bA.setCurrentContactNumber(Long.parseLong(contact));
		System.out.println("Enter the Email :");
		email = in.readLine();
		if (!isValidEmail(email)) {
			System.err.println("The Email is Not Proper !!");
			System.out.println("Enter the Email Again!!");
			email = in.readLine();
			if (!isValidEmail(email)) {
				System.err.println("Your Attempts are Over Now!!");
				return;
			}

		}
		bA.setCurrentEmail(email);
		System.out.println("Enter the Type of Business :");
		bA.setCurrentBussinessType(in.readLine());
		System.out.println("\n");
		System.out.println("Please Indicate your Decision :");
		System.out.println("Yes ---> Continue");
		System.out.println("No  ---> Abort the process!!");
		String choice = in.readLine();
		if (choice.equalsIgnoreCase("yes")) {
			System.out.println("Validating the Credentials!!");
			if (current.size() > 0) {
				if (checkCurrent(email, bA.getCurrentCompName()) == false) {
					System.err.println("Representaive Registed for this Account!!");
					return;
				} else {
					System.out.println("Verified!!");
				}

			} else {
				System.out.println("Verified!!");
			}
			long account = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			bA.setCurrentNumber(account);
			current.put(account,
					new BankApplication(bA.getCurrentCompName(), bA.getCurrentRepresentativeName(),
							bA.getCurrentContactNumber(), bA.getCurrentEmail(), bA.getCurrentBussinessType(),
							bA.getCurrentBalance()));
			System.out.println("Bank Account Created Successfully with Account number is  : " + account);
			return;
		} else if (choice.equalsIgnoreCase("no")) {
			System.err.println("Account creation can't be possible!!");
			return;
		}
		return;

	}

	public void createSavingsAccount() throws Exception {
		String contact = "";
		String email = "";
		System.out.println("Enter the Name for the Account!!");
		bA.setSavingsName(in.readLine());
		System.out.println("Enter the Contact Number for the Account Holder!!");
		contact = in.readLine();
		if (!isValidContact(contact)) {
			System.err.println("your Contact Number is not Valid!!");
			System.out.println("Enter the Contact Number Again!!");
			contact = in.readLine();
			if(!isValidContact(contact)) {
				System.err.println("Your Attempts Are Over Now!!");
				return;
			}
			
		}
		bA.setSavingsContacnumber(Long.parseLong(contact));
		System.out.println("Enter the Email Id for the Bank Account!!");
		email = in.readLine();
		if (!isValidEmail(email)) {
			System.err.println("The Email is Not Proper!!");
			System.out.println("Enter the Email Again!!");
			email = in.readLine();
			if(!isValidEmail(email)) {
				System.err.println("Your Attempts Are Over Now!!");
				return;
			}
		
		}
		bA.setSavingsEmail(email);
		System.out.println("\n");
		System.out.println("Please Indicate your Decision :");
		System.out.println("Yes ---> Continue");
		System.out.println("No  ---> Abort the process!!");
		String choice = in.readLine();
		if (choice.equalsIgnoreCase("yes")) {
			System.out.println("Validating your Credetials....");
			if (savings.size() > 0) {
				if (checkSavings(email, Long.parseLong(contact)) == false) {
					System.err.println("Account Exists with Details!!");
					return;
				} else {
					System.out.println("Verified!!");
				}

			} else {
				System.out.println("Verfied!!");
			}
			long account = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			bA.setSavingsNumber(account);
			savings.put(account, new BankApplication(bA.getSavingsName(), bA.getSavingsContacnumber(),
					bA.getSavingsEmail(), bA.getCurrentBalance()));
			System.out.println("Bank Account Created Successfully with Account number is  : " + account);
			return;
		} else if (choice.equalsIgnoreCase("no")) {
			System.err.println("Account creation can't be possible!!");
			return;
		}
		return;

	}

}
