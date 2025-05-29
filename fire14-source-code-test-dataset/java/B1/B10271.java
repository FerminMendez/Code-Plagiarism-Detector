/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlejam2012qrc;

import java.io.*;
/**
 *
 * @author Vincent
 */
public class GoogleJam2012QRC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
            //Prepare the reader
            BufferedReader in = new BufferedReader( new FileReader("inputFile.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("outputFile.txt"));
            
            //Get the amount of cases to be solved
            String str = in.readLine();
            int caseCount = Integer.parseInt(str);
            
            //For each test case
            for(int i = 0; i < caseCount; i++){
                //Get the line of the problem
                str = in.readLine();
                
                String[] problemData = str.split(" ");
                
                int lowerBound = Integer.parseInt(problemData[0]);
                int upperBound = Integer.parseInt(problemData[1]);
                int recycledCount = 0;
                
                for(int x = lowerBound; x <= upperBound; x++){
                    for(int y = x+1; y <= upperBound; y++){
                        String sx = ""+x;
                        String sy = ""+y;
                        if(sx.length() == sy.length()){
                            boolean matchFound = false;
                            for(int j = 1; j < sx.length() && !matchFound; j++){
                                String temp = sy;
                                sy = temp.substring(1) + temp.charAt(0);
                                if(sx.compareTo(sy) == 0){
                                    recycledCount++;
                                    matchFound = true;
                                }
                            }
                        }
                    }
                }
                
                out.write("Case #" + (i+1) + ": ");
                out.write("" + recycledCount);
                
                out.newLine();
            }
            in.close();
            out.close();
        }
        catch (Exception e){
            System.out.println("Read Failed");
        }
    }
}
