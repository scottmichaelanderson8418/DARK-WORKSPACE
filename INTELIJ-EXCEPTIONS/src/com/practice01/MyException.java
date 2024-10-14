// a class that represents a user-defined exception
public class MyException extends Exception
{
   public MyException()
   {
      System.out.println("MyException Was Caught!!");
   }

   public MyException(String s)
   {
      // call constructor of parent Exception
      super(s);
   }
}