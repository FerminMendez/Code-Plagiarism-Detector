import java.io.*;
import java.util.Scanner;
public class RecycledNumbers{
  
  public static void main(String[] args){
    
    //read filename from user
    Scanner request = new Scanner(System.in);
    System.out.println("Enter file name");
    String fileName = request.nextLine();
    
    
    try{
    //create a filereader to read through file contents
      
    Scanner inputFile = new Scanner(new File(fileName));
    //create output file
    BufferedWriter outputFile = new BufferedWriter(new FileWriter("output.txt"));
    
    //read file contents
    
    int lineCount = inputFile.nextInt();
    for(int i=0; i<lineCount;i++){
      int totalCount = 0;
      int a = inputFile.nextInt();
      int b = inputFile.nextInt();
      for(int x=a;x<=b;x++){
      totalCount += recycle(x,b);
      }
      //System.out.println("------------------>"+totalCount);
      outputFile.write("Case #"+ (i+1) + ": " +totalCount);
      outputFile.newLine();
      
    }
   outputFile.close();
    }
    catch(IOException e){
      System.out.println("Error getting file");
    }
  }//end of main
  
  public static int recycle(int base, int max){
    
    String num = base+"";
    int length = num.length();
    //System.out.println(num + " "+length);
    int loop = length-1;
    String front="";
    String back="";
    int result=0;
    int correct=0;
    int current=-99;
    
    for(int i=0; i<=loop; i++){
      
      front = num.substring(0,loop-i);
      back = num.substring(loop-i);
      String res=back+front;
      
      result = Integer.parseInt(res);
      //System.out.println(result);
      
      if((result!=current) && (result > base) && (result <=max)){
        
        current = result;
        correct++;
      }
    }
    return correct;
  }//end of recycle
  
}//end of class