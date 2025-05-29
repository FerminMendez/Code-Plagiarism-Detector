import java.io.*;
import java.util.StringTokenizer;
import java.util.Hashtable;

/**
 * Created by IntelliJ IDEA.
 * User: marcus
 * Date: 4/14/12
 * Time: 1:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecycledNumbers {
    
    public static void main(String a[]) throws IOException {


        FileInputStream fInputstream = null;
        try {
            fInputstream = new FileInputStream("C-small.in");
        } catch (FileNotFoundException e) {
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        DataInputStream in = new DataInputStream(fInputstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;

        FileWriter fstream = new FileWriter("C-small.out");
        BufferedWriter out = new BufferedWriter(fstream);

        String strT = null;
        strT = br.readLine();

        int T =  Integer.parseInt(strT);
        for(int d = 1; d <= T; d++)  {

            String testCase =  br.readLine();
            StringTokenizer st = new StringTokenizer(testCase, " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int dev = 0;
            int base = 10;
            while ( dev == 0){
                if(A < base){
                    dev = base /10;
                } else
                    base *= 10;
            }

            int count = 0;
            Hashtable <String, Integer> table = new Hashtable <String, Integer>();

            for(int i = A; i <= B; i++){
                //System.out.println("i :" + i);
                int mul = 10;
                for(int j = dev; j > 1 ; j/= 10, mul *= 10){
                    //System.out.println("J :" + j);
                    int val = i / j;

                    int rem = i % j;
                    int recycledHalf = (rem * mul) + val;
                    //System.out.println("recycledHalf :" + recycledHalf);





                    if(A <= i && i < recycledHalf && recycledHalf <= B ) {
                        System.out.println(A + " <= " + i + " < " + recycledHalf + " <= " + B);
                        String s = String.valueOf(i) + "," + String.valueOf(recycledHalf);
                        //System.out.println( s );
                        table.put(s, new Integer(0));

                    }


                }

            }
            count = table.size();
            //System.out.println("Dev :" + dev);
            //System.out.println("Count :" + count);
            out.write("Case #" + d + ": " + count + "\n");

        }

        in.close();
        out.close();
    }
}
