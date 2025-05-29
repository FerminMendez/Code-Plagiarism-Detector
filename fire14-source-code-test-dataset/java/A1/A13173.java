
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dave
 */
public class Main {

    public static void main(String g[]) {
        char map[] = new char[300];

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        int k = 1;
        while (t > 0) {
            t--;
            int n = Integer.parseInt(sc.next());

            int s = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
            int list[] = new int[35]; // scores

            int initialCount = 0;

            int i = 0; // googler index
            while (n > 0) {
                n--;
                int score = Integer.parseInt(sc.next());
                int minVal = b + 2 * (b - 2);
                if(minVal<0)
                    minVal=b;
                int specialNumber = (3 * b - 3);
                if(specialNumber<0)
                {
                    specialNumber=0;
                    
                }
                
                //System.out.println("score = "+score);
                //System.out.println("minVal = "+minVal);
                if (score < minVal) 
                {
                    //System.out.println("SKIP");
                    continue;
                }

                initialCount++;

                if (score <= specialNumber  ) {
                    if (s > 0 && score>=2 && score<=28) {
                        //System.out.println("using special for :" + score);
                        s--;
                    } 
                    else 
                    {
                        //System.out.println("required but cannot use!");
                        initialCount--;
                    }
                    
                    if(score<2)
                        initialCount++;
                }



            }


            System.out.println("Case #" + (k++) + ": " + initialCount);

        }

    }
}
