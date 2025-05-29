package problemc;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

public class ProblemC {
    
    public static void main(String args[]){
        List<String> inputs = readInput();
        String n;
        String m;
        int count = 0;
        for(String input : inputs ){
            count++;
            n = input.split(" ")[0];
            m = input.split(" ")[1];
            
            output(count, findRecycledNumbers(n,m));            
        }
    }
    
    
    private static int findRecycledNumbers(String n, String m){
        int recycledNumbers = 0;
        n = n.trim();
        m = m.trim();
        int mFirst = Integer.parseInt(m.substring(0,1));
        int nLong = Integer.parseInt(n);
        int mLong = Integer.parseInt(m);
        String nString = "";
                
        for(int i = nLong; i<mLong; i++){
            nString = ""+i;
            nLong = Integer.parseInt(nString);
            //System.out.println("INTERESTING");
            //System.out.println("I: " + i);
            for(int j=nString.length() - 1; j>0; j--){
               // System.out.println("nSTRING: " + nString);
              String valueAt = nString.substring(j, j+1);
                //System.out.println("VALUE AT: " + valueAt);
                if(Integer.parseInt(valueAt) <= mFirst){
                    //System.out.println("IN HERE");
                    String end = nString.substring(j);
                  String remaining = nString.substring(0, j);
                  String finalNum = end + remaining;
                  
                  
                  if(Integer.parseInt(finalNum) <= mLong && Integer.parseInt(finalNum) > nLong){                      
                    recycledNumbers++;
                  }
                }
            }
        }
        
        
        return recycledNumbers;
    }
  private static List<String> readInput(){
    List<String> untranslatedStrings = new ArrayList<String>();
    try{
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        Long numTestCases = Long.parseLong(in.readLine());
        for(int i=0; i<numTestCases.intValue(); i++){
            untranslatedStrings.add(in.readLine());
        }          
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return untranslatedStrings;
  }
  
  private static void output(int input, int recycledNum){
    System.out.println("Case #"+input+": "+recycledNum);
  }
}
