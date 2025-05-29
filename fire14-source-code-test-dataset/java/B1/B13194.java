import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Numbers{   
  public static ArrayList<Triplet> scores;
  
  public static void main(String arg[]){
    System.out.print("Enter the file path of the input file : ");
    String path = new Scanner(System.in).nextLine();
    String ANS ="", output="";
    int a, b;
    
    try{
      Scanner read = new Scanner(new File(path));
      int testCases =  Integer.parseInt(read.nextLine());
      int cn=0; String tongue; 
      while(cn++<testCases){
          a = read.nextInt();
          b = read.nextInt();
          //read.nextLine();
        
        output = "Case #"+cn+": "+ solve(a,b);//WRITE ANS TO DIFFERENT FILE 
        ANS += output +" \n";
        System.out.println(ANS);
      }
      writeToFile("numbers.out",ANS);
    }
    catch(FileNotFoundException e){//if file is not found
      System.err.println("data file \'"+path+"\' was not found\nPress <enter> to exit...");
      (new Scanner(System.in)).nextLine();
      System.exit(1);
    }
  }
  
  public static void writeToFile(String file, String text){
    PrintStream out = null;
    try {
      out = new PrintStream(new FileOutputStream(file));
      out.print(text);
    }
    catch(Exception e){}
    finally {
      if (out != null) out.close();
    }   
  }
   
  public static int solve(int a, int b){
    int counter=0;
    for(int i=a; i<=b; i++){
      counter += recycle(""+i,b);      
    }
    System.out.println(counter);    
    return counter;
  }
  
  public static int recycle(String numb, int max){
    int numbOfLoops=numb.length()-1, count=0;
    int newNumb, success=0;
    String first="", second=""; int last=-10;
    
    while(count< numb.length()-1){
      second = numb.substring(numbOfLoops-count);
      first = numb.substring(0,numbOfLoops-count);
      newNumb = Integer.parseInt(second+first);      
      
      if(newNumb != last && newNumb > Integer.parseInt(numb) && newNumb <= max){
        last = newNumb;
        success++;
      }
      
      count++;
    }
    return success;
  }
}

