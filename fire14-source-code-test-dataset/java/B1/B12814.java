
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sanket
 */
public class RecycledNumbers {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            FillHash();
            FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);


            //System.out.print(" Enter N :");
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(in));
            ReadFile(br);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void FillHash() {
    }

    public static String GetNumbersOfPair(long A, long B) {

        ArrayList<String> a = new ArrayList<String>();


        int cnt = 0;
        for (long i = A; i <= B; i++) {

            for (long j = i; j <= B; j++) {

                String word = String.valueOf(j);
                for (int k = 0; k < word.length(); k++) {
                    StringBuilder w = new StringBuilder();
                    w.append(word.substring(word.length() - (k + 1), word.length()));
                    w.append(word.substring(0, word.length() - (k + 1)));
                    //System.out.println(w + "  word :" + word);

                    if (i == Long.parseLong(w.toString()) && i != j) {

                        // for distinct pair 
                        if (!a.contains(i + "" + j)) {
                            a.add(i + "" + j);
                            cnt++;
                        }



                    }
                }

            }


        }


        return cnt + "";

    }

    public static void ReadFile(BufferedReader br) {
        try {
            String output = "";
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());

            int items[] = new int[N];
            for (int i = 0; i < N; i++) {
                StringBuilder sbTemp = new StringBuilder(br.readLine());
                sb.append("Case #");
                sb.append((i + 1));
                sb.append(": ");

                String A = String.valueOf(sbTemp.substring(0, sbTemp.indexOf(" ")));
                String B = String.valueOf(sbTemp.substring(sbTemp.indexOf(" ") + 1, sbTemp.length()));

                sb.append(GetNumbersOfPair(Long.parseLong(A), Long.parseLong(B)));


                output = output + sb + "\n";
                sb.delete(0, sb.length());
            }

            // output starts         
            System.out.print(output);
        } catch (Exception ex) {
        }
    }
}
