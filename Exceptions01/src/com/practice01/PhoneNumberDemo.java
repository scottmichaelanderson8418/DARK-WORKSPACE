package com.practice01;
import java.util.Scanner;

public class PhoneNumberDemo
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      String name;
      String phoneNumber;
      String repeat;
      
      do
      {
         try
         {
           System.out.println("Name: ");
           name = keyboard.nextLine();
           System.out.print("Phone Number: ");
           phoneNumber = keyboard.nextLine();
           
           // call the isValid method to test to see if the exception is needed
           if(isValid(phoneNumber))
           {
              System.out.println(phoneNumber + " is valid");
           }
         }
         catch (PhoneNumberException error)
         {
            System.out.println(error.getMessage());
         }
      
         System.out.print("Enter 'y' or 'yes' to continue, anything else to stop: ");
         repeat = keyboard.nextLine();
         
      }while(repeat.equalsIgnoreCase("Y") || repeat.equalsIgnoreCase("Yes"));
   }
   
   // use a private method to check to see if the phone number is entered in the
   // following format: (XXX)XXX-XXXX
   private static boolean isValid(String number) throws PhoneNumberException
   {
      boolean valid = true;
      int index = 0;
      /*
       a valid phone number has the following:
         - 13 characters in length
         - parenthesis at positions 0 and 4
         - dash at position 8
         - all of the other characters must be numbers
      */
      
      if(number.length() != 13)
      {
         // if there are not enough characters, throw an exception
         throw new PhoneNumberException("Wrong number of characters.");
      }
      
      // check the indexes for valid characters
      while(valid && index < 13)
      {
         // check for the parenthesis
         if(index == 0 || index == 4)
         {
            // check to see if the parenthesis are in the first and fifth positions
            if(number.charAt(0) != '(' || number.charAt(4) != ')')
            {
               // if the parenthesis is in the wrong place, throw an exception
               throw new PhoneNumberException("Parenthesis is in the wrong place.");
            }
         }
         else if(index == 8)
         {
            // check for the dash
            if(number.charAt(index) != '-')
            {
               // if the dash is in the wrong place, throw an exception
               throw new PhoneNumberException("Dash is in the wrong place.");
            }
         }
         else
         {
            // check to see if any of the other characters are digits
            if(!Character.isDigit(number.charAt(index)))
            {
               // if the other characters are NOT digits, throw an exception
               throw new PhoneNumberException("Contains a character that is not " +
               "a number at index " + index);
            }
         }
         
         // move to the next character
         index++;
      }
      
      // if everything is good, return true!
      return valid;
   }
}