import java.sql.*;
import java.io.*;

public class DBConnect1
{
   public static void main(String[] args)
   {
      Connection conn;
      
      try
      {
         Class.forName("org.postgresql.Driver");
         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/IceCreamDemo", "postgres", "five2one");
      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(0);
      }
      
      System.out.println("Connected to the database successfully!");
      
   }
}