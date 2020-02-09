/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.problem.Bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author rashikasingh64
 */
public class BankingAdmin {
      BankingServices bS = new BankingServices();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
	    
        BankingAdmin bD = new BankingAdmin();
	    bD.bot();
	}
	
	public void callBankServices(String option)throws Exception {
		String choice = "";
		switch(option){
		 case "A":
			 System.out.println("Enter the Type of Account you want to open");
			 System.out.println("Current or Savings Account");
                         System.out.println("Exit to Get Out!!");
			 choice = in.readLine();
			 if(choice.equalsIgnoreCase("current")) {
				 bS.createCurrentAccount();
			 }else if(choice.equalsIgnoreCase("savings")) {
				 bS.createSavingsAccount();
			 }else if(choice.equalsIgnoreCase("exit")){
                             break;
                         }
			 bot();
		 case "W":
			 bS.withdrawAmount();
			 bot();
		 case "D":
			 bS.depositAmount();
			 bot();
                 case "GA":
                     System.out.println("Enter the Type of Account");
                     String choicee = in.readLine();
                     bS.getAccountNumber(choicee);
                     bot();
		 case "R":
			 bS.reportAccount();
			 bot();
		 case "E":
			 System.err.println("You Exited the Banking Services!!");
			 System.out.println("Thankyou For Choosing Our Bank!!");
			 System.exit(0);
                 default :
                     System.err.println("It's an Unidentified Option!!");
		}
		
	}
    
    public void bot() throws Exception{
    	
    	String option = "";
    	
    	while(true) {
    		System.out.println("Welcome To Our EBanking Portal!!");
    		System.out.println("Enter the Choice You want to Avail ");
    		System.out.println("(A)ccount Opening\n(W)ithdraw\n(D)eposit\n(R)eport\n(GA)Get Account Number\n(E)xit ");
    		option = in.readLine();
    		callBankServices(option);
    	}
    }   
}
