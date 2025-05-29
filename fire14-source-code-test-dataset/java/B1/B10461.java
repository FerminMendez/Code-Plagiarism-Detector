
import java.io.*;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hamada
 */
public class Recylced {
    
    
    public static void main(String [] args) {
    
       String [] [] s= TextLines("C:\\C-small-attempt0.in");
        int count[]=new int[s.length];
    for(int i=0;i<s.length;i++){
     
        count[i]=RecyclePairs(Integer.parseInt(s[i][0]),Integer.parseInt(s[i][1]));
        
        System.out.println("Case #"+(i+1)+": "+count[i]);
    
    }    
    
   
    }
   
public static int RecyclePairs(int A, int B) {

    int totalCount=-1;
    
    String sA=A+"";
    String sB=B+"";
    
    char c1[]=sA.toCharArray();
    char c2[]=sB.toCharArray();
    
           
    for(int i=0; i<sA.length();i++) {
        
        for(int j=i;j<sA.length();j++)
        {
            if(c1[i] != c1[j] || c2[i]!=c2[j]) 
            {
                totalCount=0;
                break;
            }
        }
    }
    
    if(sA.length() == 1)
      totalCount=0;  
    for(int n=A;n<=B;n++)
    {
   totalCount+=getAllCycleNumbers(n, A, B);
            
    }
        
    
    return totalCount;
        }
    public static int  getAllCycleNumbers(int n, int A, int B) {
    
        String sN=n+"";
        int count =0;
        
        int m;
        for(int i=1;i<=sN.length()-1;i++){
            
           m=crossOver(sN, i);
//            System.out.println("The crossover "+m);
            if(m>n && m<=B)
                count++;    
        }
        
        
    return count;
    }
    
    public static int crossOver(String s, int cuttingPoint) {
    
        String s1="";
        String s2="";
        
        String result="";
        int r;
        char [] c=s.toCharArray();
        for(int i=0;i<cuttingPoint;i++) 
            s1+=c[i];
            
       for(int i=cuttingPoint;i<s.length();i++) 
            s2+=c[i];
       
       result=s2+s1;
       
          r=Integer.parseInt(result);
       
       return r;
    }

public static String[][] TextLines(String FileName){
int NumberOfLines;

String [] testCases=null;
String [] [] tokens=null;
try{
  // Open the file that is the first 
  // command line parameter
  FileInputStream fstream = new FileInputStream(FileName);
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  
 
  
  NumberOfLines=Integer.parseInt(br.readLine());
  
  testCases=new String[NumberOfLines];
  
   tokens =new String [NumberOfLines][2];
    int i=0;
  //Read File Line By Line
    
    StringTokenizer stk;
  while (i<NumberOfLines)   {
  
     
      testCases[i]=br.readLine();
      
      stk=new StringTokenizer(testCases[i]," ");
      
      while(stk.hasMoreTokens()) {
          
          tokens[i][0]=stk.nextToken();
          tokens[i][1]=stk.nextToken();
      }
      i++;
  }
  //Close the input stream
  in.close();
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }


return tokens;
}

}


