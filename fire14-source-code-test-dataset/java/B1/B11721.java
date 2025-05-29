import java.io.*;
import java.util.*;


class recycledNumbers{
  public static void main(String arg[]){
    System.out.println("Please Enter the name of your file");
    Scanner input = new Scanner(System.in);
    String fileName = input.next();
    recycle(fileName);
  }
  public static void recycle(String fileName){
    try{
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    BufferedWriter bw = new BufferedWriter(new FileWriter("recycle.out"));
    
    int numCases = Integer.parseInt(br.readLine());
    int A=0;
    int B=0;
    String line="";
    for(int i=0; i<numCases; i++){
    line = br.readLine();
    int indexOfSpace=line.indexOf(' ');
    A=Integer.parseInt(line.substring(0,indexOfSpace));
    B=Integer.parseInt(line.substring(indexOfSpace+1));
    int count=0;
    
    for(int m=A; m<=B; m++){
      count += swap(m,B);

    }
    String ans = "Case #" + (i+1) + ": " + count;
    System.out.println(ans);
    bw.write(ans);
    bw.newLine();
    }
    br.close();
    bw.close();
    }catch(IOException e){}
  }
  
  public static int swap(int A,int B){
    String valA = A + "";
    int var_length = valA.length();
    int var_swap = var_length-1;
    String firstpart="";
    String secondpart="";
    String combine="";
    int combined=0;
    int verified=0;
    int temp=-99;
    
    for(int i=0; i<var_swap; i++){
      firstpart=valA.substring(0,var_swap-i);
      secondpart=valA.substring(var_swap-i);
      combine = secondpart + firstpart;
      combined = Integer.parseInt(combine);
      
      //System.out.println(combined);
      
      if((temp != combined) && (combined>A) && (combined<=B)){
        temp = combined;
        verified++;
      }
      
    }
    return verified;
  }
}