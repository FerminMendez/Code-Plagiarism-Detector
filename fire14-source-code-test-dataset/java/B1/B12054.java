/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;
import java.io.*;
/**
 *
 * @author Nah-Abiah
 */
public class recycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            FileInputStream fstream = new FileInputStream("C-small-attempt1.in");
            
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            
            int testCount = 0;
            int caseCount = 1;
            String writeFile = "";
            while ((strLine = br.readLine()) != null)   {
                if(testCount == 0){
                    testCount = Integer.parseInt(strLine);
                } 
                else{                    
                    String[] ints = strLine.split(" ");
                    int n = Integer.parseInt(ints[0]);
                    int limit = Integer.parseInt(ints[1]);                    
                    int num = 0;
                    if(ints[0].length() != 1){
                        while (n < limit){
                            int count = 1;
                            
                            while(count < ints[0].length()){
                                String m = String.valueOf(n).substring(count)+String.valueOf(n).substring(0, count);
                                if((n<Integer.parseInt(m)) && (Integer.parseInt(m)<= limit)){
                                    num++;
                                }
                                count++;
                            }
                            n++;
                        }
                    }
                    writeFile += "Case #"+caseCount+": "+num+"\r\n";
                    caseCount++;
                }
            }
            //Close the input stream
            in.close();
            
            try{
                // Create file 
                FileWriter filestream = new FileWriter("output.txt");
                BufferedWriter out = new BufferedWriter(filestream);
                out.write(writeFile);
                //Close the output stream
                out.close();
            }
            catch (Exception e){//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
        }
        catch (IOException | NumberFormatException e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
