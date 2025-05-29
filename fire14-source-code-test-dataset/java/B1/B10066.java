
package codejam;

import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class C {
    static String str = "C:\\carl\\fileC.txt";
    static String text = "";

    static int A, B, T, cnt;
    static HashMap hm;


    public static void main(String[] args) {

        try {
            int count = 0;

            hm = new HashMap();

            File file = new File(str);
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter outer = new PrintWriter(new FileWriter("C:\\carl\\outC.txt"));


            while((text = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(text);

                if(count == 0) {
                    T = Integer.parseInt(st.nextToken());
                    count++;
                } else  {

                    A = Integer.parseInt(st.nextToken());
                    int n = A;
                    B = Integer.parseInt(st.nextToken());

                    while (n != B) {
                        char[] temp = Integer.toString(n).toCharArray();
                        scramble(temp, n);
                        n++;
                    }
                    outer.println("Case #" + count + ": " + hm.entrySet().size());
                //System.out.println(hm.entrySet().size());
                hm.clear();
                count++;
                    
                }
                
            }

            
            outer.close();

        } catch(IOException ex) {
            System.out.println("Error with IO you foooool");
        } catch(Exception ex) {
            System.out.println("Generic Error. Noob.");
            ex.printStackTrace();
        }
    }

    public static void scramble(char[] temp, int n) {
        Integer[] no = new Integer[temp.length];
        for(int i=0; i<temp.length;i++) { no[i] = Integer.parseInt( Character.toString(temp[i]) ); }
        //Integer[] test = {1, 2, 3, 4, 5};
        for (int i = 0; i < temp.length - 1; i++) {
            Collections.rotate(Arrays.asList(no), -1);

            int m = trans(no);
            //System.out.println(n + " " + m);
            if( n < m && m <= B && no[0] != 0 ) {

                if( !hm.containsKey(n + " " + m)) {
                    hm.put(n + " " + m, n + " " + m);
                    //System.out.println(n + ", " + m);
                }

                //System.out.println(b);
            }
        }


    }

    public static int trans(Integer[] a) {
        String s = "";
        for(int i : a) {
            s = s + i;
        }
        //System.out.println(" @@ " + s);
        return Integer.parseInt(s);
    }

}
