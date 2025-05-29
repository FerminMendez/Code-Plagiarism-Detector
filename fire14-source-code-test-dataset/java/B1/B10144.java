import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;


public class GoogleCodeInP3{
    
    //processing file
    public static void main(String[] args) throws IOException {
        BufferedReader dog = new BufferedReader(new FileReader(args[0]));
        int a = -1;
        try {
            a = Integer.parseInt(dog.readLine());
        }
        catch (Exception e) { }
        FileWriter file = new FileWriter("outputFile8");
        BufferedWriter cat = new BufferedWriter(file);
        for (int i = 0; i < a; i++) {
            String line = dog.readLine();
            String[] barf= line.split(" ");
            cat.write("Case #" + (i + 1) + ": " + GoogleCodeInP3.solver(Integer.parseInt(barf[0]),Integer.parseInt(barf[1])));
            if (i < a - 1) { 
                cat.write("\n"); 
            }
        }
        cat.close();
    }
    
    
    
    public static int solver(int a, int b){
        int totalRecycledPair = 0; // returns the total number of recyled pairs 
        int m= a+1;
        for (int n= a; n < m; n++){
               for (m= n + 1; m < b+1; m++){
                   if ((m+"").length() == (n+"").length()){
                       String interN= n+"";
                       if (Integer.parseInt(interN) == m){
                           totalRecycledPair++;
                       }
                       for (int i= 0; i < interN.length(); i++){
                           interN= interN.charAt(interN.length()-1) + interN.substring(0,interN.length()-1);
                           if (Integer.parseInt(interN) == m){
                               totalRecycledPair++;
                           }
                       }
                   }
                }
         }
       return totalRecycledPair;
    }
}