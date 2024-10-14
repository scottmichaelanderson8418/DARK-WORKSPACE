public class ExceptionDemo
{
   public static void main(String[] args)
   {
      try
      {
         // throw a MyException
         throw new MyException();
      }
      catch(MyException e)
      {
         System.out.println("GOTCHA!!!");
         // print the message
         System.out.println(e.getMessage());
      }
      
      try
      {
         // throw a MyException
         throw new MyException("Another MyException was caught!");
      }
      catch(MyException e)
      {
         System.out.println("GOTCHA!!!");
         // print the message
         System.out.println(e.getMessage());
      }
   }
}