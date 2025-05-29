package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.StringTokenizer;
import java.math.*;

public class DancingGoogler {
    public DancingGoogler() {
        super();
    }

    public static void main(String[] args) throws FileNotFoundException,
                                                  IOException {
        DancingGoogler dancingGoogler = new DancingGoogler();
     FileReader fr = new FileReader("B-small-attempt3.in");
      //FileReader fr = new FileReader("A-small-practice.in");
        BufferedReader br = new BufferedReader(fr);
        String noofT = br.readLine();
        int noOfTestCases = Integer.parseInt(noofT);
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        
        for (int i=0; i < noOfTestCases; i++ ){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String nofG = st.nextToken();
            int noOfGooglers = Integer.parseInt(nofG);
            String nofS = st.nextToken();
            int noOfSurprises = Integer.parseInt(nofS);
            String p = st.nextToken();
            int P = Integer.parseInt(p);
            int cnt = 0;
            int cntS =0;
            int[] cntr = new int[noOfGooglers];
            forloop:      for (int j=0 ; j < noOfGooglers; j++){
               
                String jG = st.nextToken();
                int totjG = Integer.parseInt(jG);
                int q = totjG/3;
                int r = totjG%3;
                int[][] ar = new int[100][3];
                boolean flagr = false;
               
                if (r == 0){
                    ar[0][0] = q;
                    ar[0][1] = q;
                    ar[0][2] = q;
                    for(int k=0;k<3;k++){
                        if (ar[0][k] >= P)
                            cntr[j] = cntr[j] + 1;
                    }

                }
                if (q+1 <= 10){
                if (Math.abs(totjG - q - q - 1 - q) <= 1 && Math.abs(totjG - q - q - 1 - q -1) <=1 ){
                    ar[0][0] = q;
                    ar[0][1] = q+1;
                    ar[0][2] = totjG - q - q - 1;
                    for(int k=0;k<3;k++){
                        if (ar[0][k] >= P)
                            cntr[j] = cntr[j] + 1;
                    }

                }
                }
                
                
                for (int k=0;k<j;k++){
                    if (cntr[k] >= 2)
                        flagr= true;
                   // System.out.println("cntr =" + cntr[k]);
                }
                if (noOfSurprises > 0 && ((cntS < noOfSurprises) || (flagr == true))){
                    if (q + 1 <= 10 && q-1>=0){
                    if (( Math.abs(totjG - 2*q - q + 1) <= 2) && (Math.abs(totjG-2*q - q -1) <= 2)){
                    ar[1][0] = q + 1;
                    ar[1][1] = q-1;
                    ar[1][2] = totjG - 2*q;
                    
                    for(int k=0;k<3;k++){
                        if (ar[1][k] >= P){
                            cntr[j] = cntr[j] + 1;
                            cntS++;
                            break;
                        }
                    }
                        

                    }
                    }
                    if (q+2 <= 10){
                    if ((Math.abs(totjG - q- q -2 - q) <= 2) && (Math.abs(totjG - q- q -2 - q -2) <=2)){
                        ar[1][0] = q;
                        ar[1][1] = q+2;
                        ar[1][2] = totjG- q - q -2;
                       
                        for(int k=0;k<3;k++){
                            if (ar[1][k] >= P){
                                cntr[j] = cntr[j] + 1;
                                cntS++;
                                break;
                            }
                        }

                    }
                    }
                    }
                
                for (int m=0;m < 2; m++){
                    for(int n = 0; n < 3;n++){
                      System.out.print(ar[m][n]);
                    }
                   System.out.println("");
                }
                int val=0;
                for (int m=0;m <2; m++){
                    for(int n = 0; n < 3;n++){
                        val = ar[m][n];
                        if (ar[m][n] >= P){
                            cnt++;
                            break;
                            
                        }
                                           }
                    if (val >= P)
                        break;

                    
                }
                
                
            }
            String out = "Case #" + (i+1) + ": " + cnt;
            bw.write(out);
            bw.newLine();
            System.out.println("Case #" + (i+1) + ": " + cnt);
        }
        bw.close();
    }
}
