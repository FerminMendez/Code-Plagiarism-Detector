import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayyoob
 */
public class RecycledNumbers {

    public static void main(String[] args) {

        BufferedReader bf = null;
        BufferedWriter bw = null;
        try {
            bf = new BufferedReader(new FileReader("./C-small-attempt0.in"));
            bw =new BufferedWriter(new FileWriter("./C-small-attempt0.out"));
           int prt=Integer.parseInt(bf.readLine());
           
           for(int printer=0;printer<prt;printer++){

            String str[] = bf.readLine().split(" ");

            int first = Integer.parseInt(str[0]);
            int second = Integer.parseInt(str[1]);
            int count = 0;
            String mystr = "" + first;
            int mystr_length = mystr.length();
            int myarr[][] = new int[(second - first) + 1][mystr_length];

            for (int i = first, m = 0; i <= second; i++, m++) {

                int mytemparr[] = new int[mystr_length];
                mytemparr[0] = i;

                for (int j = 1; j < mystr_length; j++) {

                    String newstr = "" + mytemparr[j - 1];
                    while (newstr.length() != mystr_length) {
                        newstr = "0" + newstr;
                    }
                    newstr = newstr.charAt(newstr.length() - 1) + newstr.substring(0, newstr.length() - 1);
                    mytemparr[j] = Integer.parseInt(newstr);

                }
                Arrays.sort(mytemparr);

                myarr[m] = mytemparr;

            }

            for (int m = 0; m < myarr.length; m++) {
                for (int j = m + 1; j < myarr.length; j++) {
                    if (myarr[m][0] == myarr[j][0]) {
                        myarr[m][0] = -1;

                    }
                }
            }

            for (int m = 0; m < myarr.length; m++) {
                if (myarr[m][0] != -1) {
                    for (int ind = 0; ind < mystr_length-1 ; ind++) {
                        for (int ind2 = ind + 1; ind2 < mystr_length; ind2++) {
                            if (myarr[m][ind] == myarr[m][ind2]) {
                                myarr[m][ind2] = -1;

                            }
                        }
                    }
                }
            }

            if (mystr_length > 1) {

                for (int m = 0; m < myarr.length; m++) {
                    for (int j = 0; j < mystr_length; j++) {
                        if (myarr[m][0] != -1) {

                            for (int z = j + 1; z < mystr_length; z++) {
                                if (myarr[m][j] != -1) {
                                    if (myarr[m][j] >= first && myarr[m][j] <= second && myarr[m][z] >= first && myarr[m][z] <= second && myarr[m][j] != myarr[m][z] && myarr[m][z] != -1) {
                                       
                                        count++;


                                    } 

                                }
                            }

                        }
                    }
                }

            }


           
            bw.write("Case #"+(printer+1)+": "+count);
            bw.newLine();
            bw.flush();
           }
        } catch (IOException ex) {
        } finally {
            try {
                bf.close();
            } catch (IOException ex) {
            }
        }

    }
}