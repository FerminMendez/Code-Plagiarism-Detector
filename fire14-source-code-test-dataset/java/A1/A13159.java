import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Dancers{   
  public static ArrayList<Triplet> scores;
  
  public static void main(String arg[]){
    System.out.print("Enter the file path of the input file : ");
    String path = new Scanner(System.in).nextLine();
    String ANS ="", output="", test;
    int diff;
    
    try{
      Scanner read = new Scanner(new File(path));
      int testCases =  Integer.parseInt(read.nextLine());
      int cn=0; String tongue; 
      while(cn++<testCases){
        test  = read.nextLine();
        
        output = "Case #"+cn+": "+ solve(test);//WRITE ANS TO DIFFERENT FILE 
        ANS += output +" \n";
        System.out.println(ANS);
      }
      writeToFile("dancers.out",ANS);
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
  
  public static int solve(String test){
    String temp[] = test.split(" ");
    ArrayList<Triplet> tempList = new ArrayList<Triplet>();
    Triplet[] scores;
    int dancerNo, surpriseNo, bestResult;
      
    dancerNo = Integer.parseInt(temp[0]);
    surpriseNo = Integer.parseInt(temp[1]);
    bestResult = Integer.parseInt(temp[2]);
    int counter = 0;
    
    while(counter < dancerNo){
      tempList.add(new Triplet(temp[3+counter])); 
      counter++;
    }
    
    scores = tempList.toArray(new Triplet[tempList.size()]);
    
    
    Arrays.sort(scores);
    
    scores = doTheSurprises(scores,surpriseNo, bestResult);  
    
    System.out.println(Arrays.toString(scores));
    
    return count(scores, bestResult);
  }
  
  public static Triplet[] doTheSurprises(Triplet sc[], int surprise, int max){
    Triplet temp;
    int sNo=0;
    for(int i=sc.length-1; i>=0; i--){
      if(sNo==surprise){
        break;
      }
      
      if(sc[i].scores[2]<max){
        if(sc[i].doSurprise()){
          sNo++;
        }
      }
    }    
    return sc;
  }
  
  public static int count(Triplet sc[], int max){
    int temp=0;
    for(int i=0; i<sc.length; i++){
      if(sc[i].scores[2]>=max){
        temp++;
      }
    }
    return temp;}
}

class Triplet implements Comparable<Triplet>{
  public int scores[] = new int[3];
  public Triplet(int x, int y, int z){
    scores[0]=x;
    scores[1]=y;
    scores[2]=z;
  }
  
  public Triplet(String x){setThrees(Integer.parseInt(x));}
  
  public Triplet(int x){setThrees(x);}
  
  public void setThrees(int numb){
    this.scores[0] =numb/3;
    this.scores[1] = (numb-scores[0])/2;
    this.scores[2] = numb - scores[0] - scores[1];
  } 
  
  public int compareTo(Triplet x){
    if(scores[2]<x.scores[2]){
      return -1;
    }
    else if(scores[2]>x.scores[2]){
      return 1;
    }
    else{
      return 0;
    }
    
  }
  
  public boolean doSurprise(){
    int s1 = scores[1], s2 = scores[2];
    
    if(s1 == s2){
      s1--; s2++;
      if(s1>=0 && s2<=10){
        scores[1] = s1;
        scores[2] = s2;
        return true;
      }
    }
    return false;
  }
  
  public String toString(){
    return Arrays.toString(scores);
  }
}
