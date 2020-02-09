/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.problem.Bank;

import java.util.regex.*;

/**
 *
 * @author rashikasingh64
 */
public class Validation {

    public boolean isValidContact(String num) {
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(num);
        return (m.find() && m.group().equals(num));
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

}
