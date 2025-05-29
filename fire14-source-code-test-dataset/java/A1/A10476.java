/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Scoble
 */
import java.io.*;
public class ProblemB {
    public static void main(String args[]) {
        try {
            BufferedReader breader = new BufferedReader(new FileReader("E:\\test.txt"));
            int noooo;
            noooo= Integer.parseInt(breader.readLine());
            int caseno=0;
            int noofgglrs;
            int specialcases;
            int maxnumber,i;
            String tempstr;
            String outpuuttt;
            outpuuttt="";
            String nos[];
            int tmp;
            int count;
            while( caseno < noooo ) {
                tempstr = breader.readLine();
                nos = tempstr.split(" ");
                outpuuttt += "Case #"+(caseno+1)+": ";

                noofgglrs = Integer.parseInt(nos[0]);
                specialcases = Integer.parseInt(nos[1]);
                maxnumber = Integer.parseInt(nos[2]);
                count = 0;
                for(i=0;i<noofgglrs;i++) {
                    tmp = Integer.parseInt(nos[i+3]);
                    if( tmp / 3 >= maxnumber )
                        count++;
                    else if( tmp%3 == 1 && (tmp/3)+(tmp%3) >= maxnumber) {
                        count++;
                    }
                    else if( tmp%3 == 2 && specialcases > 0 && (tmp%3)+(tmp/3) >= maxnumber ) {
                        count++;
                        specialcases--;
                    }
                    else if( tmp%3 == 2 && ((tmp/3)+((tmp/3)+1)*2) == tmp && (tmp/3)+1>=maxnumber ) {
                        count++;
                    }
                    else if( tmp!=0 && tmp%3 == 0 && specialcases > 0 && (tmp/3)+1 >= maxnumber ) {
                        count++;
                        specialcases--;
                    }
                }
                outpuuttt += count;
                if( caseno != noooo-1 )
                    outpuuttt += "\n";
                caseno++;
            }
            System.out.println(outpuuttt);
            BufferedWriter bwrtr = new BufferedWriter( new FileWriter("E:\\result.txt"));
            bwrtr.write(outpuuttt);
            bwrtr.close();
            breader.close();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }
}