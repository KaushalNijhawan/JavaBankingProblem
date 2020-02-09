/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.problem.Bank;

import java.io.*;
import java.sql.*;

/**
 *
 * @author rashikasingh64
 */
public class BankingServices {

    Statement stmt;
    BankingInfo bI = new BankingInfo();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void createCurrentAccount() throws Exception {
        String contact = "";
        String email = "";
        System.out.println("Enter the Company Name");
        bI.setCurrentCompName(in.readLine());
        System.out.println("Enter the Representative Name");
        bI.setCurrentRepresentativeName(in.readLine());
        System.out.println("Enter the Contact Number");
        contact = in.readLine();
        Validation val = new Validation();
        if (!val.isValidContact(contact)) {
            System.err.println("The Contact is not Valid!!\n");
            System.out.println("Enter the Valid Contact !!");
            contact = in.readLine();
            if (!val.isValidContact(contact)) {
                System.err.println("Your Attempts Got Over!!\n");
                return;
            }

        }
        bI.setCurrentContactNumber(contact);
        System.out.println("Enter the Email for the account!!");
        email = in.readLine();
        if (!val.isValidEmail(email)) {
            System.err.println("Your Email is not Valid!!\n");
            System.out.println("Entet the Email Again!!");
            email = in.readLine();
            if (!val.isValidEmail(email)) {
                System.err.println("Your Attempts are Over!!");
                return;
            }

        }
        bI.setCurrentEmail(email);
        System.out.println("Enetr the Type Of Business!!");
        bI.setCurrentBussinessType(in.readLine());
        System.out.println("Please Indicate your Decision :");
        System.out.println("Yes ---> Continue\nNo  ---> Abort the process!!");
        String choice = in.readLine();
        if (choice.equalsIgnoreCase("no")) {
            System.err.println("Account creation can't be possible!!");
            return;
        } else if (choice.equalsIgnoreCase("yes")) {
            long account = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            bI.setCurrentNumber(Long.toString(account));
            BankDB bdb = new BankDB();
            Connection con = bdb.createCon();
            PreparedStatement stmt = con.prepareStatement("insert into current(CompanyName ,RepresentativeName ,Contact,Email,Type,account, curBalance) values (? , ? , ? , ? , ? , ? ,?)");
            stmt.setString(1, bI.getCurrentCompName());
            stmt.setString(2, bI.getCurrentRepresentativeName());
            stmt.setString(3, bI.getCurrentContactNumber());
            stmt.setString(4, bI.getCurrentEmail());
            stmt.setString(5, bI.getCurrentBussinessType());
            stmt.setString(6, bI.getCurrentNumber());
            stmt.setString(7, "0");
            int rs = stmt.executeUpdate();
            if (rs > 0) {
                System.out.println("Account created SuccessFully!!\n The Account number is " + account);

            } else {
                System.err.println("Some issues are there!!");
            }
        }

    }

    public void createSavingsAccount() throws Exception {
        String contact = "";
        String email = "";
        System.out.println("Enter the Name of the Account holder!!");
        bI.setSavingsName(in.readLine());
        System.out.println("Enter the Contact Number for the Account!!");
        contact = in.readLine();
        Validation val = new Validation();
        if (!val.isValidContact(contact)) {
            System.err.println("The Contact is not Valid!!\n");
            System.out.println("Enter the Valid Contact !!");
            contact = in.readLine();
            if (!val.isValidContact(contact)) {
                System.err.println("Your Attempts Got Over!!\n");
                return;
            }

        }
        bI.setSavingsContacnumber(contact);
        System.out.println("Enter the Email for the account!!");
        email = in.readLine();
        if (!val.isValidEmail(email)) {
            System.err.println("Your Email is not Valid!!\n");
            System.out.println("Entet the Email Again!!");
            email = in.readLine();
            if (!val.isValidEmail(email)) {
                System.err.println("Your Attempts are Over!!");
                return;
            }

        }
        bI.setSavingsEmail(email);
        System.out.println("Please Indicate your Decision :");
        System.out.println("Yes ---> Continue\nNo  ---> Abort the process!!");
        String choice = in.readLine();
        if (choice.equalsIgnoreCase("no")) {
            System.err.println("Account creation can't be possible!!");
            return;
        } else if (choice.equalsIgnoreCase("yes")) {
            long account = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            bI.setSavingsNumber(Long.toString(account));
            BankDB bdb = new BankDB();
            Connection con = bdb.createCon();
            PreparedStatement stmt = con.prepareStatement("Insert into savings(account , name , ContactNumber ,Email , savBalance) values (?,?,?,?,?)");
            stmt.setString(1, bI.getSavingsNumber());
            stmt.setString(2, bI.getSavingsName());
            stmt.setString(3, bI.getSavingsContacnumber());
            stmt.setString(4, bI.getSavingsEmail());
            stmt.setString(5, "0");
            int rs = stmt.executeUpdate();
            if (rs > 0) {
                System.out.println("Account created SuccessFully!!\n The Account number is " + account);

            } else {
                System.err.println("Some issues are there!!");
            }

        }

    }

    public void getAccountNumber(String bank) throws Exception {
        BankDB bdb = new BankDB();
        if (bank.equalsIgnoreCase("savings")) {
            System.out.println("Enter the Email attached to the Account!!");
            String email = in.readLine();
            Connection con = bdb.createCon();
            PreparedStatement stmt = con.prepareStatement("select account from savings where Email = ? ");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Your Account Number is ---> " + rs.getString("account"));
                return;
            } else {
                System.out.println("None Found!!");
                return;
            }
        } else if (bank.equalsIgnoreCase("current")) {
            System.out.println("Enter the Email attached to the Account!!");
            String email = in.readLine();
            Connection con = bdb.createCon();
            PreparedStatement stmt = con.prepareStatement("select account from current where Email = ? ");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Your Account Number is ---> " + rs.getString("account"));
                return;
            } else {
                System.out.println("None Found!!");
                return;
            }
        }

    }

    public void withdrawAmount() throws Exception {
        System.out.println("Enter the Type of the Account!!");
        String choice = in.readLine();
        if (choice.equalsIgnoreCase("current")) {
            System.out.println("Enter the Account Number!!");
            String account = in.readLine();
            System.out.println("Enter the Amount !!");
            String amount = in.readLine();
            if (Long.parseLong(amount) > 300000) {
                System.err.println("Amount Withdrawl Limit Exceeded!!");
                return;
            } else {
                BankDB dbd = new BankDB();
                Connection con = dbd.createCon();
                PreparedStatement stmt = con.prepareStatement("Select curBalance from current where account = ?");
                stmt.setString(1, account);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String MainAmount = rs.getString("curBalance");
                    if (Long.parseLong(amount) > Long.parseLong(MainAmount)) {
                        System.err.println("InSufficient Balance!!");
                        return;
                    } else {
                        long transaction = Long.parseLong(MainAmount) - Long.parseLong(amount);
                        PreparedStatement stmt2 = con.prepareStatement("Update current set curBalance =?  where account =?");
                        stmt2.setString(1, Long.toString(transaction));
                        stmt2.setString(2, account);
                        int rs2 = stmt2.executeUpdate();
                        if (rs2 > 0) {
                            System.out.println("Balance Updated!!");
                            return;
                        }
                    }
                }
            }
        } else if (choice.equalsIgnoreCase("savings")) {
            System.out.println("Enter the Account Number!!");
            String account = in.readLine();
            System.out.println("Enter the Amount !!");
            String amount = in.readLine();
            if (Long.parseLong(amount) > 75000) {
                System.err.println("Amount Withdrawl Limit Exceeded!!");
                return;
            } else {
                BankDB dbd = new BankDB();
                Connection con = dbd.createCon();
                PreparedStatement stmt = con.prepareStatement("Select savBalance from savings where account = ?");
                stmt.setString(1, account);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String MainAmount = rs.getString("savBalance");
                    if (Long.parseLong(amount) > Long.parseLong(MainAmount)) {
                        System.err.println("InSufficient Balance!!");
                        return;
                    } else {
                        long transaction = Long.parseLong(MainAmount) - Long.parseLong(amount);
                        PreparedStatement stmt2 = con.prepareStatement("Update Savings set savBalance =? where account =?");
                        stmt2.setString(1, Long.toString(transaction));
                        stmt2.setString(2, account);
                        int rs2 = stmt2.executeUpdate();
                        if (rs2 > 0) {
                            System.out.println("Balance Updated!!");
                            return;
                        }
                    }
                }
            }
        }
    }

    public void depositAmount() throws Exception {
        System.out.println("Enter the Type of the Account!!");
        String choice = in.readLine();
        if (choice.equalsIgnoreCase("current")) {
            System.out.println("Enter the Account Number!!");
            String account = in.readLine();
            System.out.println("Enter the Amount !!");
            String amount = in.readLine();
            if (Long.parseLong(amount) > 500000) {
                System.err.println("Amount Deposit Limit Exceeded!!");
                return;
            } else {
                BankDB dbd = new BankDB();
                Connection con = dbd.createCon();
                PreparedStatement stmt = con.prepareStatement("Select curBalance from current where account = ?");
                stmt.setString(1, account);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String MainAmount = rs.getString("curBalance");
                    long transaction = Long.parseLong(MainAmount) + Long.parseLong(amount);
                    PreparedStatement stmt2 = con.prepareStatement("update current set curBalance=?  where account =?");
                    stmt2.setString(1, Long.toString(transaction));
                    stmt2.setString(2, account);
                    int rs2 = stmt2.executeUpdate();
                    if (rs2 > 0) {
                        System.out.println("Balance Updated!!");
                        return;

                    }
                }
            }
        } else if (choice.equalsIgnoreCase("savings")) {
            System.out.println("Enter the Account Number!!");
            String account = in.readLine();
            System.out.println("Enter the Amount !!");
            String amount = in.readLine();
            if (Long.parseLong(amount) > 100000) {
                System.err.println("Amount Deposit Limit Exceeded!!");
                return;
            } else {
                BankDB dbd = new BankDB();
                Connection con = dbd.createCon();
                PreparedStatement stmt = con.prepareStatement("Select savBalance from savings where account = ?");
                stmt.setString(1, account);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String MainAmount = rs.getString("savBalance");
                    long transaction = Long.parseLong(MainAmount) + Long.parseLong(amount);
                    PreparedStatement stmt2 = con.prepareStatement("Update Savings set savBalance = ? where account =?");
                    stmt2.setString(1, Long.toString(transaction));
                    stmt2.setString(2, account);
                    int rs2 = stmt2.executeUpdate();
                    if (rs2 > 0) {
                        System.out.println("Balance Updated!!");
                        return;
                    }

                }
            }
        }
    }

    public void reportAccount() throws Exception {
        System.out.println("Enter the type of Account!!");
        String choice = in.readLine();
        System.out.println("Enter the Account Number!!");
        String account = in.readLine();
        BankDB bdb = new BankDB();
        if (choice.equalsIgnoreCase("savings")) {
            Connection con = bdb.createCon();
            PreparedStatement stmt = con.prepareStatement("Select savBalance from savings where account = ? ");
            stmt.setString(1, account);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("The Opening Balance is ---> " + 0 + " Cr\nThe Current Balance of the Savings Account is ---> " + rs.getString("savBalance") + " Cr");

            }
        } else if (choice.equalsIgnoreCase("current")) {
            Connection con = bdb.createCon();
            PreparedStatement stmt = con.prepareStatement("Select curBalance from current where account = ? ");
            stmt.setString(1, account);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("The Opening Balance is ---> " + 0 + " Cr\nThe Current Balance of the Savings Account is ---> " + rs.getString("curBalance") + " Cr");

            }
        }
    }

}
