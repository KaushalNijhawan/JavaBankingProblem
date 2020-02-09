/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.problem.Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author rashikasingh64
 */
public class BankDB {

    public Connection createCon() throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/kaushal", "root", "root123");
        //Statement stmt = con.createStatement();
        //return stmt;
        return con;
    }
}
