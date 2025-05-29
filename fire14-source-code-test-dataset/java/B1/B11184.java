package googlecodejam1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Google Code Jam 2012, Recycled Numbers
 * @author matt1618
 */
public class GoogleCodeJam1 {
   
    public static boolean digitMatch(int n, int m){        
        while(true){            
            if((n / 10) < 1 && (m / 10) < 1) return true;
            if((n / 10) < 1) return false;
            if((m / 10) < 1) return false;
            n = n / 10;
            m = m / 10;
        }        
    }
    
    public static int digits(int n){ 
        int result = 1;
        while(true){ 
            if((n / 10) < 1) return result;            
            n = n / 10;  
            result++;
        }        
    }
    
    public static boolean isRecycled(int n, int m){          
        int digits = digits(n);        
        int n1 = 10;
        int n2 = (int)Math.pow(10, digits - 1);
        for(int i = 1; i <= digits; i++){
            if(n % n1 == (m / n2)){
                if(m % n2 == (n / n1))return true;
            }
            n1 *= 10;
            n2 /= 10;
        }
        return false;
    }
    
    public static void main(String[] args) {
        
      try{          
          FileInputStream fstream = new FileInputStream("input.txt");
          
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String line = br.readLine();
          int lines = new Integer(line);
          
          for(int i = 1; i <= lines; i++){          
              if((line = br.readLine()) == null){
                  System.err.println("Error: Empty line ?");
                  break;
              }
              System.out.print("Case #"+ i +": ");
              String numbers[] = line.split(" ");
              int num1 = new Integer(numbers[0]);
              int num2 = new Integer(numbers[1]); 
              int result = 0;
              
              if(digitMatch(num1, num2) && num1 >= 1 && num2 <= 1000){                   
                  for(int n = num1; n <= num2; n++){                     
                      for(int m = n + 1; m <= num2; m++){
                          if(isRecycled(n, m)) result++;                          
                      }                  
                  }
              }
              System.out.println(result);
          }
          
          in.close();
      }catch (Exception e){
          System.err.println("Error: " + e.getMessage());
      }
    }
}
