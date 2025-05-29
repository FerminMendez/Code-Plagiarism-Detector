import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Recycle
{
  public static void main(String[] args)
  {
    BufferedReader input = null;
    PrintWriter output = null;
    try
    {
      input = new BufferedReader(new FileReader(args[0]));
      output = new PrintWriter(new FileWriter(args[1]));
    
      String currentLine;
      int lineNumber = -1;
      String[] array = new String[2];
      
      while((currentLine = input.readLine()) != null)
      {
        lineNumber++;
        if(lineNumber>0)
        {
          array = currentLine.split(" ");
          int number1 = Integer.parseInt(array[0]);
          int number2 = Integer.parseInt(array[1]);
          int numberOfCases = 0;
          
          for(int count1=number1; count1<number2; count1++)
          {
            int numberOfPlaces = -1;
            int first = count1;
            while(first > 0)
            {
              first = first/10;
              numberOfPlaces++;
            } // while
            
            for(int count=count1+1; count<=number2; count++)
            {  
              first = count1;
              if(first != count)
              {
                do
                {
                  int d = first % 10;
                  first = first/10;
                  int multiply = (int) Math.pow(10, numberOfPlaces);
                  first = d*multiply + first;
                  if(first == count)
                    numberOfCases++;
    
                }while(first != count1);
            
              } // if
            } // for  
          } // for
          output.println("Case #" + lineNumber + ": " + numberOfCases);
        } // if
      } // while
      
    } // try
    
    catch (Exception exception)
    {
    System.err.println(exception);
    } // catch
    
    finally
    {
      try{ if(input != null) input.close(); }
      catch (IOException exception)
      { System.err.println("Could not close input: " + exception); }
      
      if(output != null)
      {
        output.close();
        if(output.checkError())
          System.err.println("Soemthing went wrong with the output");
      } // if
    } // finally
  } // main
} // class 
      
      