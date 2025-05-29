/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package a_q_gcj2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Nekomi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        String buf[] = new String[2000001];

        for(int i= 0;i< 20001;++i) {
            int nt[] = new int[10];
            String st = String.format("%d", i);

            for(char s: st.toCharArray()) {
                nt[s-'0'] ++;
            }

            int str_len = st.length();
            char c[] = new char[st.length()];

            int p= 0;
            for(int j=0; j<10;j++) {
                for(int k=0;k<nt[j];k++) {
                    c[p] = (char) (j +'0');
                    p++;
                }
            }
            buf[i] = new String(c);

            //System.out.print(i + ":" + buf[i]+"\r\n");

        }

        // TODO code application logic here
        File file = new File("c:\\work\\c.in");
        File filew = new File("c:\\work\\outC.txt");

        FileReader rr = new FileReader(file);
	BufferedReader r = new BufferedReader(rr);

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filew)));

        String line;
        int lineNo = 1;

        line = r.readLine();
        while ((line = r.readLine()) != null) {
             String[] splited = line.split(" ");

            int A = Integer.valueOf(splited[0]);
            int B = Integer.valueOf(splited[1]);

            int result = 0;

            for(int n=A;n<B;n++)
                for(int m=n+1;m<=B;m++)
                    if (buf[n].equals(buf[m])) {
                        String sn = String.valueOf(n);
                        String sm = String.valueOf(m);
                        
                        int len = sn.length();
                        for(int q=1;q<len;q++) {
                            String sm1 = sm.substring(0,q);
                            String sm2 = sm.substring(q, len);

                            if ((sm2+sm1).equals(sn)) {
                                result++;
                                //System.out.print("n:"+n +" m:"+m + "\n\r");
                                break;
                            }
                        }
                    }

            String strAns = "Case #" + Integer.toString(lineNo)
                    + ": " + String.valueOf(result)+"\n\r";

            System.out.print(strAns);

            lineNo ++;

            pw.println(strAns);
        }
        r.close();
        pw.close();
    }

}
