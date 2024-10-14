package com.practice01;
public class PhoneNumberException extends Exception
{
   public PhoneNumberException()
   {
      super("Invalid phone number entered. \n");
   }
   
   public PhoneNumberException(String error)
   {
      super(error);
   }
}