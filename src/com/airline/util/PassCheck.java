package com.airline.util;

public class PassCheck{
	  public boolean passvalid(String password){
	    if (password.length() <= 8){
	      System.out.println("Your password must be atleast 8 character!");
	      return false;
	    }
	    boolean hasUpper = false;
	    boolean hasLower = false;
	    boolean hasDigit = false;
	    boolean hasSpecial = false;
	    String specials = "@#$%^&+=!";
	    for (int i = 0 ; i < password.length(); i++){
	      char c = password.charAt(i);
	      if(Character.isUpperCase(c)){
	        hasUpper = true;
	      }
	      else if (Character.isLowerCase(c)){
	        hasLower = true;
	      }
	      else if(Character.isDigit(c)){
	        hasDigit = true;
	      }
	      else if (specials.indexOf(c) != -1){
	        hasSpecial = true;
	      }
	    }
	    if(!hasUpper){
	      return false;
	    }
	    if(!hasLower){
	      return false;
	    }
	    if(!hasDigit){
	      return false;
	    }
	    if(!hasSpecial){
	      return false;
	    }
	    return true;
	  }
	}