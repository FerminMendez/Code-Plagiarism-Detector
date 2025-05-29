/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package codejam2012;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author BUDDHIMA
 */
public class Codejam2012 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("outputC-small.txt")));

        int tests = Integer.parseInt(br.readLine());

        for (int testIndex = 1; testIndex <= tests; testIndex++) {

            int count = 0;

            String[] lineParts = br.readLine().split(" "); // A B

            if (lineParts[0].length() < 2) {
                out.write("Case #" + testIndex + ": " + 0 + "\n");
                continue;


            } else {

                int A = Integer.parseInt(lineParts[0]);
                int B = Integer.parseInt(lineParts[1]);


                for (int x = A; x < B; x++) {
                    
                    ArrayList<Integer> preAdded=new ArrayList<Integer>(); //memory
                    
                    for (int i = 1; i < lineParts[0].length(); i++) {
                        String numpart1 = String.valueOf(x).substring(0, i);
                        String numpart2 = String.valueOf(x).substring(i);

                        int newnum = Integer.parseInt(numpart2 + numpart1);
                        
                        
                        
                        if (newnum <= B && x < newnum) {
                            boolean isIn=false;
                            
                            for(int y=0;y<preAdded.size();y++){
                            if(preAdded.get(y)==newnum){
                            isIn=true;
                            break;
                            }
                            }
                            
                            if(!isIn){
                            System.out.println(x + "-->" + newnum);
                            count++;
                            preAdded.add(newnum);
                            isIn=false;
                            }
                        }



                    }
                }

            }

//print results
            out.write("Case #" + testIndex + ": " + count + "\n");

        }



        out.close();
    }
}
