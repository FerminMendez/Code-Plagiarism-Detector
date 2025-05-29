
package codejam;

import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B {
    static String str = "C:\\carl\\fileB.txt";
    static String text = "";

    static int N, S, P,T;
    static int[][] list;


    public static void main(String[] args) {

        try {
            int caser = 1;
            int count = 0;
            File file = new File(str);
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter outer = new PrintWriter(new FileWriter("C:\\carl\\outB.txt"));


            while((text = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(text);

                if(count == 0) {
                    T = Integer.parseInt(st.nextToken());
                    System.out.println(T);
                    count++;
                } else  {
                    /* each subsequent line */
                    N = Integer.parseInt(st.nextToken());
                    list = new int[N][3];
                    S = Integer.parseInt(st.nextToken());
                    P = Integer.parseInt(st.nextToken());
                    //System.out.println(N + " :: " + S + " :: " + P);
                    int c = 0;
                    while(st.hasMoreTokens()) {
                        float temp = Float.parseFloat(st.nextToken());
                        //double a = temp/3.0;
                        list[c][0] = Math.round(temp/3.0f);
                        list[c][1] = Math.round(temp/3.0f);
                        list[c][2] = (int)(temp - (2 * Math.round(temp/3.0f)));
                        //System.out.println(temp + " :: " + list[c][0] + " " + list[c][1] + " " + list[c][2]);
                        c++;
                    }
                   

                    /* calculations */
                    int counter = 0;
                    for(int[] i : list) {

                        if(i[0] >= P || i[1] >= P || i[2] >= P) {
                            counter++;
                        } else {
                            if(S > 0 ) {
                                double a = (i[0]+i[1]+i[2]) - P;
                                //System.out.println("a : " + a);
                                double b = a/2.0;
                                
                                if((P - b) <= 2 && a > 0) {
                                    //System.out.println("special " +  S + " : " + (P - b) + " :: pass");
                                   counter++;
                                    S--;
                                } else {
                                    //System.out.println("special " +  S + " : " + (P - b) + " :: fail");
                                }
                                
                            }
                        }

                        
                    }
                    //System.out.println("");
                    outer.println("Case #" + count + ": " + counter);
                    
                    count++;

                    //caser++;
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

}
