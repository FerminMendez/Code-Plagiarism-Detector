package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Recycle {
    public Recycle() {
        super();
    }

    public static void main(String[] args) throws FileNotFoundException,
                                                  IOException {
        Recycle recycle = new Recycle();
       // FileReader fr = new FileReader("B-large.in");
         FileReader fr = new FileReader("C-small-attempt0.in");
           BufferedReader br = new BufferedReader(fr);
           String noofT = br.readLine();
           int noOfTestCases = Integer.parseInt(noofT);
           BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
           for (int i=0;i < noOfTestCases;i++ ){
               StringTokenizer st = new StringTokenizer(br.readLine()," ");
               String sA = st.nextToken();
               int A = Integer.parseInt(sA);
               String sB = st.nextToken();
               int B = Integer.parseInt(sB);
               int cnt = 0;
               int count = 0;
               int[] numArray = new int[30000];
               TreeSet a1 = new TreeSet();
               for (int j = A; j<=B ;j++){
                   String jS = Integer.valueOf(j).toString();
                   char[] jS1 = new char[jS.length()];
                   for (int m = 0; m < jS.length() - 1;m++){
                   for (int k = jS.length() - 1; k >0 ; k--){
                       char temp = jS.charAt(jS.length() - 1);
                       jS1[k] = jS.charAt(k-1);
                       jS1[0] = temp;
                       
                       
                       
                   }
                       String jS2 = "";
                       for (int n=0;n < jS1.length; n++){
                           jS2 = jS2 + Character.valueOf(jS1[n]).toString();
                       }
                        
                    int newNum = Integer.parseInt(jS2);
                       boolean flag = false;
                       boolean flagR = false;
                    if (( newNum >= A) && (newNum <= B) && (newNum != j)) {
                        if (a1.contains(newNum)== true){
                            
                            flag = true;
                           // System.out.println("flag = " + flag);
                            //break;
                        }
                       // numArray[cnt++] = newNum;
                        else{
                            String reverseNum = "";
                            for (int l= jS1.length - 1;l >= 0;l--){
                                 reverseNum = reverseNum + Character.valueOf(jS1[l]).toString();
                            }
                            if (jS1.length == 2){
                            if (!a1.contains(new Integer(reverseNum))){       
                        a1.add(newNum);
                        cnt++;
                            }
                            }
                            else{
                                a1.add(newNum);
                                cnt++;
                            }
                           
                        }
                        //System.out.println("newNum = " + newNum);
                    }
                       
                       
                          
                           
                       
                       
                      /* if (flag == false){
                           //System.out.println("count = " + count);
                           count++;
                       }*/
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
