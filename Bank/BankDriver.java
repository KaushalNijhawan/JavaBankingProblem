package com.classes.Bank;
import java.io.*;
public class BankDriver {
    BankServices bS = new BankServices();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
	    
        BankDriver bD = new BankDriver();
	    bD.bot();
	}
	
	public void callBankServices(String option)throws Exception {
		String choice = "";
		switch(option){
		 case "A":
			 System.out.println("Enter the Type of Account you want to open");
			 System.out.println("Current or Savings Account");
			 choice = in.readLine();
			 if(choice.equalsIgnoreCase("current")) {
				 bS.createCurrentAccount();
			 }else if(choice.equalsIgnoreCase("savings")) {
				 bS.createSavingsAccount();
			 }
			 bot();
		 case "W":
			 bS.withdrawAmount();
			 bot();
		 case "D":
			 bS.depositAmount();
			 bot();
		 case "R":
			 bS.reportAccount();
			 bot();
		 case "E":
			 System.err.println("You Exited the Banking Services!!");
			 System.out.println("Thankyou For Choosing Our Bank!!");
			 System.exit(0);
		}
		
	}
    
    public void bot() throws Exception{
    	
    	String option = "";
    	
    	while(true) {
    		System.out.println("Welcome To Our EBanking Portal!!");
    		System.out.println("Enter the Choice You want to Avail ");
    		System.out.println("(A)ccount Opening\n(W)ithdraw\n(D)eposit\n(R)eport\n(E)xit ");
    		option = in.readLine();
    		callBankServices(option);
    	}
    }
}
