/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN-PC
 */
public class Validate {

    public boolean checkEmail(String email) {
        String patternMail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
        Pattern pattern = Pattern.compile(patternMail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean checkName(String name){
        String patternName = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(patternName);
        Matcher matcher = pattern.matcher(name);
       return matcher.matches();
        
        
    }
}
