/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlejam2012qrb;

import java.io.*;
/**
 *
 * @author Vincent
 */
public class GoogleJam2012QRB {

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
                int googlerCount = Integer.parseInt(problemData[0]);
                int suprCount = Integer.parseInt(problemData[1]);
                int targetResult = Integer.parseInt(problemData[2]);
                
                int autoPassScore = targetResult * 3 - 2;
                int surpPassScore = autoPassScore - 2;
                
                if(surpPassScore < 1) surpPassScore = 1;
                
                int autoCountPass = 0;
                int surpCountPass = 0;
                int totalCountPass;
                
                for(int j = 0; j < googlerCount; j++){
                    int currentScore = Integer.parseInt(problemData[j+3]);
                    if(currentScore >= autoPassScore) autoCountPass++;
                    else if(currentScore >= surpPassScore) surpCountPass++;
                }
                
                totalCountPass = autoCountPass;
                if(suprCount <= surpCountPass) totalCountPass += suprCount;
                else totalCountPass += surpCountPass;
                
                out.write("Case #" + (i+1) + ": ");
                out.write("" + totalCountPass);
                
                out.newLine();
                System.out.println();
            }
            in.close();
            out.close();
        }
        catch (Exception e){
            System.out.println("Read Failed");
        }
    }
}
